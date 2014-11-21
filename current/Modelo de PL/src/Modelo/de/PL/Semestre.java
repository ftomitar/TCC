/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.de.PL;

import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author aaratame
 */
public class Semestre implements Comparable{
    String nome = null;
    Set<Materia> materias;
    public Semestre(String nome){
        materias = new HashSet<Materia>();
        this.nome = nome;
    }
    
    public void addMateria(Materia materia){
        materias.add(materia);
    }
    
    public void removeMateria(Materia materia){
        materias.remove(materia);
    }
    
    public boolean materiaLecionada(Materia materia){
        boolean status = materias.contains(materia);
        
        return status;
    }
    
    public Set getMateriasLecionadas(){
        return materias;
    }
    
    public String getNome(){
        
        return nome;
    }
    
    public String toString(){
        return nome;
    }

    @Override
    public int compareTo(Object outroSemestre) {
         if (!(outroSemestre instanceof Semestre))
            throw new ClassCastException("A Semestre object expected.");
        String outraSemestreNome = ((Semestre) outroSemestre).getNome();
        return nome.compareTo(outraSemestreNome);
    }
    
}
