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
    
}
