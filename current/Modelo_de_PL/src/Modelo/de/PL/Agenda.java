package Modelo.de.PL;


import java.util.HashSet;
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
public class Agenda {
    private Set horarioLivre;
    public Agenda(){
        horarioLivre = new HashSet<Horario>();
        
    }
    
    public void addHorarioLivre(Horario periodo){
        horarioLivre.add(periodo);
    }
    
    public void removeHorarioLivre(Horario periodo){
        horarioLivre.remove(periodo);      
    }
    
    public boolean horarioLivre(Horario periodo){
        boolean resp = false;
        
        if(horarioLivre.contains(periodo)){
            resp = true;
        }
        
        return resp;  
    }
    
    public Set getPeriodoLivre(){
        return horarioLivre;
    }
    
    
}
