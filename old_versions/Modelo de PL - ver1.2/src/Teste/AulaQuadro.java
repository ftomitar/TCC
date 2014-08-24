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
    
    public AulaQuadro(String[] stats){
        aula = stats[0];
        professor = stats[1];
        materia = stats[2];
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
    
    
    
}
