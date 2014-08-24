package Modelo.de.PL;

import java.util.Set;
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
    public Cronograma(Aula aula){
        this.aula = aula;
    }
    
    public void gerarModelo(){
        System.out.println("MAX");
        gerarAulasPossiveis();
        System.out.println("ST");
        gerarRestricao();
        System.out.println("END");
        setVariableType("integer");
        //setVariableType("boolean");
        
        
    }
    
    public void gerarAulasPossiveis(){
        Set <Professor> professor = aula.getProfessores();
        Set <Materia> materia;
        Set <Horario> horario;
        
        String nomeProf = "";
        String nomeMat = "";
        String nomeAula = "";
        
        String equacao = "";
        
        for(Professor prof: professor){
            nomeProf = prof.getNome();
            materia = prof.getMateriasLecionadas();
            horario = prof.getPeriodoLivre();
            for(Materia mat: materia){
                nomeMat = mat.getNome();
                for(Horario hora: horario){
                    nomeAula = hora.getNome();
                    
                    equacao = equacao + nomeAula+ nomeProf + nomeMat + "+";
                    
                }
            }
        }
        if(equacao != ""){
            equacao = equacao.substring(0, equacao.length()-1); //apaga o ultimo '+'
        }
        
        System.out.println(equacao);
    }
    
    public void gerarRestricao(){
        tempoAula();
        aulasSemana();
    }
    
    public void tempoAula(){
        Set <Professor> professores = aula.getProfessores();
        Set <Horario> horarios = aula.getHorarios();
        Set <Materia> materias;
        
        String nomeProf = null;
        String nomeMat = null;
        String nomeAula = null;
        
        String eq = null;
        for (Horario periodo: horarios){
            eq = "";
            nomeAula = periodo.getNome();
            for(Professor prof: professores){
                if (prof.horarioLivre(periodo)){
                    nomeProf = prof.getNome();
                    materias = prof.getMateriasLecionadas();
                    for(Materia mat: materias){
                        nomeMat = mat.getNome();
                        eq = eq + nomeAula + nomeProf + nomeMat + "+";
                    }
                }
            }
            if (eq != ""){
                eq = eq.substring(0, eq.length()-1); //apaga o ultimo '+'
                eq = eq + "<1";
                System.out.println(eq);
            }
        }
        
    }
    
    public void aulasSemana(){
        Set <Materia> materias = aula.getMaterias();
        Set <Professor> professores = aula.getProfessores();
        Set <Horario> horarios ;
       
        
        String nomeMat = null;
        String nomeProf = null;
        String nomeAula = null;
        
        int qtdAulas = 0;
        String eq = null;
        
        for(Materia mat: materias){
            eq = "";
            nomeMat = mat.getNome();
            qtdAulas = mat.numeroAulas();
            for(Professor prof: professores){
                if(prof.lecionaMateria(mat)){
                    nomeProf = prof.getNome();
                    horarios = prof.getPeriodoLivre();
                    for(Horario periodo: horarios){
                        nomeAula = periodo.getNome();
                        eq = eq + nomeAula + nomeProf + nomeMat + "+";
                    }
                }
            }
            if (eq != ""){
                eq = eq.substring(0, eq.length()-1); //apaga o ultimo '+'
                eq = eq + "=" + qtdAulas;
                //eq = eq + "<" + qtdAulas; //Relaxamento de restrições, teste caso a solução seja inviavel
                System.out.println(eq);
            }
            
            
        }
        
    }
    
    public void setVariableType(String type){
        Set <Professor> professor = aula.getProfessores();
        Set <Materia> materia;
        Set <Horario> horario;
        
        String nomeProf = "";
        String nomeMat = "";
        String nomeAula = "";
        
        String variavel = "";
        
        for(Professor prof: professor){
            nomeProf = prof.getNome();
            materia = prof.getMateriasLecionadas();
            horario = prof.getPeriodoLivre();
            for(Materia mat: materia){
                nomeMat = mat.getNome();
                for(Horario hora: horario){
                    nomeAula = hora.getNome();
                    
                    variavel = nomeAula+ nomeProf + nomeMat + " ";
                    if(type == "integer"){
                        variavel =  "GIN " + variavel ;
                        System.out.println(variavel);
                    }
                    
                    else if(type == "boolean"){
                        variavel =  "INT " + variavel ;
                        System.out.println(variavel);
                    }
                    else{
                        System.out.println("Tipo de variavel invalida");
                    }
                }
            }
        }
    }
    
    
}
