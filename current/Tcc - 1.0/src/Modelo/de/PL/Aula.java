package Modelo.de.PL;


import java.util.HashSet;
import java.util.Set;

/*
 *
 * @author aaratame
 */
public class Aula {
    private Set <Professor> professores;
    private Set <Materia> materias;
    private Set <Horario> horarios;
    private Set <Semestre> semestres;
    
    public Aula(){
        professores = new HashSet<Professor>();
        materias = new HashSet <Materia>();
        horarios = new HashSet <Horario>();
        semestres = new HashSet <Semestre>();
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
    
    public void addSemestre(Semestre semestre){
        semestres.add(semestre);
    }

    public void addSemestre(Set<Semestre> semestre){
        if(semestres.isEmpty()){
            semestres = semestre;
        }
        else{
            for(Semestre s: semestre){
                semestres.add(s);
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
    
    public Set getSemestres(){
        
        return semestres;
    }    
}
