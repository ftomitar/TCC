package Modelo.de.PL;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class Aula {
    
    private Set <Professor> professores;
    private Set <Materia> materias;
    private Set <Horario> horarios;
    
    public Aula(){
        professores = new HashSet<Professor>();
        materias = new HashSet <Materia>();
        horarios = new HashSet <Horario>();
    }
    
    public void addProfessor(Professor prof){
        professores.add(prof);
    }
    
    public void addProfessor(Set<Professor> prof){
        if (professores.isEmpty()){
            professores = prof;
        }
        else{
            for(Professor p: prof){
                professores.add(p);
            }
        }
    }
    
    public void addMateria(Materia mat){
        materias.add(mat);
    }
    
    public void addMateria(Set<Materia> mat){
        if (materias.isEmpty()){
            materias = mat;
        }
        else{
            for(Materia m: mat){
                materias.add(m);
            }
        }
    }
    
    public void addHorario(Horario horario){
        horarios.add(horario);
    }

    public void addHorario(Set<Horario> hora){
        if(horarios.isEmpty()){
            horarios = hora;
        }
        else{
            for(Horario h: hora){
                horarios.add(h);
            }
        }
    }
    
    public Set getProfessores(){
        
        return professores;
    }
    
    public Set getMaterias(){
        
        return materias;
    }
    
    public Set getHorarios(){
        
        return horarios;
    }
    
    
}
