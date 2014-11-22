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
public class Horario implements Comparable{
    private String nome;
    public  Horario(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        
        return nome;
    }
    
    public String toString(){
        return nome;
    }
    
    @Override
    public int compareTo(Object outrohorario) {
         if (!(outrohorario instanceof Horario))
            throw new ClassCastException("A Horario object expected.");
        String outroHorarioNome = ((Horario) outrohorario).getNome();
        return nome.compareTo(outroHorarioNome);
    }

}
