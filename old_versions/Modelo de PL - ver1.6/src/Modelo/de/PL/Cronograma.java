package Modelo.de.PL;

import java.util.Set;
import LPSolveComunication.FileManager;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aaratame
 */
public class Cronograma {
    Aula aula;
    String separador;
    FileManager file;
    public Cronograma(Aula aula,FileManager manager){
        this.aula = aula;
        file = manager;
        separador = "&";
    }
    
    public void gerarModelo(){
        file.abrirArquivoEscrita();
        
        file.escreverLinha("MAX");
        gerarAulasPossiveis();
        file.escreverLinha("ST");
        gerarRestricao();
        file.escreverLinha("END");
        setVariableType("integer");
        //setVariableType("boolean");
        
        file.fecharArquivo();
    }
    
    public String concat(String nomeSemestre, String nomeAula, String nomeProf, String nomeMat){
        String resp = "";
        
        resp = nomeSemestre + separador + nomeAula + separador + nomeProf + separador + nomeMat;
        
        return resp;
    }
    
    public void gerarAulasPossiveis(){
        Set <Professor> professor = aula.getProfessores();
        Set <Materia> materia;
        Set <Horario> horario;
        Set <Semestre> semestre = aula.getSemestres();
        
        String nomeProf = "";
        String nomeMat = "";
        String nomeAula = "";
        String nomeSemestre = "";
        
        String equacao = "";
        for(Semestre semes: semestre){
            nomeSemestre = semes.getNome();
            for(Professor prof: professor){
                nomeProf = prof.getNome();
                materia = prof.getMateriasLecionadas();
                horario = prof.getPeriodoLivre();
                for(Materia mat: materia){
                    if(mat.lecionada(semes)){
                        nomeMat = mat.getNome();

                        for(Horario hora: horario){
                            nomeAula = hora.getNome();

                            equacao = equacao + concat(nomeSemestre, nomeAula, nomeProf, nomeMat)+ "+";

                        }
                    }
                }
            }
        }
        if(equacao != ""){
            equacao = equacao.substring(0, equacao.length()-1); //apaga o ultimo '+'
        }
        
        file.escreverLinha(equacao);
    }
    
    public void gerarRestricao(){
        tempoAula();
        aulasSemana();
        professor2AulasSimultaneas();
    }
    
    public void tempoAula(){
        Set <Professor> professores = aula.getProfessores();
        Set <Horario> horarios = aula.getHorarios();
        Set <Materia> materias;
        Set <Semestre> semestres = aula.getSemestres();
        
        String nomeProf = null;
        String nomeMat = null;
        String nomeAula = null;
        String nomeSemes = null;
        
        String eq = null;
        for(Semestre sem: semestres){
            nomeSemes = sem.getNome();
        
            for (Horario periodo: horarios){
                eq = "";
                nomeAula = periodo.getNome();

                for(Professor prof: professores){
                    if (prof.horarioLivre(periodo)){
                        nomeProf = prof.getNome();
                        materias = prof.getMateriasLecionadas();
                        for(Materia mat: materias){
                            if(mat.lecionada(sem)){
                                nomeMat = mat.getNome();

                                eq = eq + concat(nomeSemes, nomeAula, nomeProf, nomeMat) + "+";
                            }
                        }
                    }
                }
            
                if (eq != ""){
                    eq = eq.substring(0, eq.length()-1); //apaga o ultimo '+'
                    eq = eq + "<1";
                    file.escreverLinha(eq);
                }
            }
        }
        
    }
    
    public void aulasSemana(){
        Set <Materia> materias = aula.getMaterias();
        Set <Professor> professores = aula.getProfessores();
        Set <Horario> horarios ;
        Set <Semestre> semestres = aula.getSemestres() ;
        
        String nomeMat = null;
        String nomeProf = null;
        String nomeAula = null;
        String nomeSem = null;
        
        int qtdAulas = 0;
        String eq = null;
        for(Semestre sem: semestres){
            nomeSem = sem.getNome();
            for(Materia mat: materias){
                if(mat.lecionada(sem)){
                    eq = "";
                    nomeMat = mat.getNome();
                    qtdAulas = mat.numeroAulas();
                    for(Professor prof: professores){
                        if(prof.lecionaMateria(mat)){
                            nomeProf = prof.getNome();
                            horarios = prof.getPeriodoLivre();
                            for(Horario periodo: horarios){
                                nomeAula = periodo.getNome();
                                eq = eq + concat(nomeSem, nomeAula, nomeProf, nomeMat)+ "+";
                            }
                        }
                    }
                    if (eq != ""){
                        eq = eq.substring(0, eq.length()-1); //apaga o ultimo '+'
                        eq = eq + "=" + qtdAulas;
                        //eq = eq + "<" + qtdAulas; //Relaxamento de restrições, teste caso a solução seja inviavel
                        file.escreverLinha(eq);
                    }

                }
            }
        }
    }
    
    public void professor2AulasSimultaneas(){
        Set <Professor> professores = aula.getProfessores();
        Set <Horario> horarios = aula.getHorarios();
        Set <Materia> materias;
        Set <Semestre> semestres = aula.getSemestres();
        
        String nomeProf = null;
        String nomeMat = null;
        String nomeAula = null;
        String nomeSemes = null;
        
        String eq = null;
        
        
        for (Professor prof: professores){
            nomeProf = prof.getNome();
            materias = prof.getMateriasLecionadas();
            for(Horario hora: horarios){
                if(prof.horarioLivre(hora)){
                    eq = "";
                    nomeAula = hora.getNome();
                    for(Semestre sem: semestres){
                        nomeSemes = sem.getNome();
                        for(Materia mat: materias){
                            nomeMat = mat.getNome();
                            if(mat.lecionada(sem)){
                                eq = eq + concat(nomeSemes, nomeAula, nomeProf, nomeMat) + "+";
                            }
                        }
                    }
                    if (eq != ""){
                        eq = eq.substring(0, eq.length()-1); //apaga o ultimo '+'
                        eq = eq + "<1";
                        file.escreverLinha(eq);
                    }
                }
            } 
        }
        
        
        
    }
    
    public void setVariableType(String type){
        Set <Professor> professor = aula.getProfessores();
        Set <Materia> materia;
        Set <Horario> horario;
        Set <Semestre> semestre = aula.getSemestres();
        
        String nomeProf = "";
        String nomeMat = "";
        String nomeAula = "";
        String nomeSem = "";
        
        String variavel = "";
        for(Semestre sem: semestre){
            nomeSem = sem.getNome();
            for(Professor prof: professor){
                nomeProf = prof.getNome();
                materia = prof.getMateriasLecionadas();
                horario = prof.getPeriodoLivre();
                for(Materia mat: materia){
                    if(mat.lecionada(sem)){
                        nomeMat = mat.getNome();
                        for(Horario hora: horario){
                            nomeAula = hora.getNome();

                            variavel = concat(nomeSem, nomeAula, nomeProf, nomeMat );
                            if(type == "integer"){
                                variavel =  "GIN " + variavel ;
                                file.escreverLinha(variavel);
                            }

                            else if(type == "boolean"){
                                variavel =  "INT " + variavel ;
                                file.escreverLinha(variavel);
                            }
                            else{
                                file.escreverLinha("Tipo de variavel invalida");
                            }
                        }
                    }
                }
            }
        }
    }
    
    
}
