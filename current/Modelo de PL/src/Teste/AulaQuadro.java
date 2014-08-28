/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Teste;

/**
 *
 * @author aaratame
 */
public class AulaQuadro {
    String professor;
    String materia;
    String aula;
    String semestre;
    
    public AulaQuadro(String[] stats){
        semestre = stats[0];
        aula = stats[1];
        professor = stats[2];
        materia = stats[3];
    }
    
    public String getMateria(){
        return materia;
    }
    
    public String getProfessor(){
        return professor;
    }
    
    public String getAula(){
        return aula;
    }
    
    public String getSemestre(){
        return semestre;
    }
    
    
}
