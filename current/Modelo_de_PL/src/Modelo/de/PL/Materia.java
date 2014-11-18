package Modelo.de.PL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aaratame
 */
public class Materia {
    
    private String nome;
    private int quantidade;
    private String semestre;
    public Materia(String nome, int quantidade, String semestre){
        this.nome = nome;
        this.quantidade = quantidade;
        this.semestre = semestre;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int numeroAulas(){
        return quantidade;
    }
    
    public String getSemestre(){
        return semestre;
    }
    
    public boolean lecionada(Semestre semestre){
        boolean status;
        status = semestre.materiaLecionada(this);
        
        return status;
    }

   
    
}
