/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conjuntos;

import Modelo.de.PL.Aula;
import Modelo.de.PL.Horario;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;
import Modelo.de.PL.Semestre;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alexandre
 */
public class FabConjuntos {
    Aula aula;
    String separador;
    public FabConjuntos(Aula aula, String separador){
        this.aula = aula;
        this.separador = separador;
        
    }    
    
    public Set plausivel(){
        Set <String> conjunto = new HashSet<String>();
        Set <Professor> professor = aula.getProfessores();
        Set <Materia> materia;
        Set <Horario> horario;
        Set <Semestre> semestre = aula.getSemestres();
        
        String nomeProf = "";
        String nomeMat = "";
        String nomeAula = "";
        String nomeSemestre = "";
        
        String elemento = "";
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

                            elemento = concat(nomeSemestre, nomeAula, nomeProf, nomeMat);
                            conjunto.add(elemento);
                        }
                    }
                }
            }
        }
       
        
        
    
        
        
        return conjunto;
    }
    
    public Set todasCombinacoes(Horario horario, Semestre semestre){
        
        Set <String> conjunto = new HashSet<String>();
        
        Set <Professor> professores = aula.getProfessores();
        Set <Materia> materias;
        
        String nomeProf = null;
        String nomeMat = null;
        String nomeAula = null;
        String nomeSemes = null;
        
        String elemento = null;
        
        nomeSemes = semestre.getNome();
        
        nomeAula = horario.getNome();

        for(Professor prof: professores){
            nomeProf = prof.getNome();
            materias = prof.getMateriasLecionadas();
            for(Materia mat: materias){

                nomeMat = mat.getNome();

                elemento = concat(nomeSemes, nomeAula, nomeProf, nomeMat);
                conjunto.add(elemento);

            }
            
        }

        return conjunto;
    }
    
    
    
    
    private String concat(String semestre, String aula, String prof, String mat){
        String resposta;
        resposta = semestre + separador + aula + separador + prof + separador + mat;
        
        return resposta;
    }
}
