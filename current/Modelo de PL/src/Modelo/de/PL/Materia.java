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
public class Materia implements Comparable{
    
    private String nome;
    private int quantidade;
    private String semestre;
    public Materia(String nome, int quantidade, String semestre){
        this.nome = nome;
        this.quantidade = quantidade;
        this.semestre = semestre;
    }
    
    public Materia(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int numeroAulas(){
        return quantidade;
    }
    /*
    public String getSemestre(){
        return semestre;
    }
    */
    public boolean lecionada(Semestre semestre){
        boolean status;
        status = semestre.materiaLecionada(this);
        
        return status;
    }
    public String toString(){
        
        return nome;
    }

    
    @Override
    public int compareTo(Object outraMateria) {
         if (!(outraMateria instanceof Materia))
            throw new ClassCastException("A Materia object expected.");
        String outraMateriaNome = ((Materia) outraMateria).getNome();
        return nome.compareTo(outraMateriaNome);
    }

   
    
}
