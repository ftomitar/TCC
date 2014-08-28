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
public class Professor {
    
    private String nome;
    private Set materias;
    private Agenda agenda;
    public Professor(String nome){
        this.nome = nome;

        materias = new HashSet<Materia>();
        agenda = new Agenda();
    }
    
    public void addHoraDisp(Horario periodo){
        agenda.addHorarioLivre(periodo);
    }
    
    public void removeHoraDisp(Horario periodo){
        agenda.removeHorarioLivre(periodo);
    }
    
    public void addMateria(Materia mat){
        materias.add(mat);
    }
    
    public void removeMateria(Materia mat){
        materias.remove(mat);
    }
    
    public String getNome(){
        
        return nome;
    }
    
    public Set getMateriasLecionadas(){
        return materias;
    }
    
    public Set getPeriodoLivre(){
        return agenda.getPeriodoLivre();
    }
    
    public boolean horarioLivre(Horario periodo){
        boolean disponivel = false;
        
        if(agenda.horarioLivre(periodo)){
            disponivel = true;
        }
        
        return disponivel;
    }
    
    public boolean lecionaMateria(Materia mat){
        boolean resp = false;
        
        if(materias.contains(mat)){
            resp = true;
        }
        
        return resp;
    }
}
