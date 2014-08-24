package Modelo.de.PL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class Aplication {
    Map<String, Professor> professores;
    Map<String, Materia> materia;
    List<Horario> horarios;
    public Aplication(){
        professores = new HashMap<String, Professor>();
        materia = new HashMap<String, Materia>();
        horarios = new ArrayList<Horario>();
        
        inicializar();
    }
    
    public final void inicializar(){
        gerarProfessores();
        gerarMaterias();
        gerarHorarios();
        gerarRestricao();
    }
    
    public void gerarProfessores(){
        professores.put("lisbete", new Professor("Lisbete"));
        professores.put("milton", new Professor("Milton"));
        professores.put("italo", new Professor("Italo"));
        professores.put("satoshi", new Professor("Satoshi"));
        professores.put("wladmir", new Professor("Wladmir"));
        professores.put("carlos", new Professor("Carlos"));
    }
    
    public void gerarMaterias(){
        materia.put("Algoritmos", new Materia("Algoritmos", 2));
        materia.put("EstruturaDeDados", new Materia("EstruturaDeDados", 2));
        
        materia.put("Redes", new Materia("Redes", 1));
        materia.put("LabRedes", new Materia("LabRedes", 2));
        
        materia.put("OrientacaoObjetos", new Materia("OrientacaoObjetos", 1));
        materia.put("EngenhariaSoftware", new Materia("EngenhariaDeSoftware", 2));
        
        materia.put("BancoDeDados", new Materia("BancoDeDados", 2));
        
        materia.put("EST", new Materia("EST", 2));
        materia.put("ESP", new Materia("ESP", 1));
    }
    
    public void gerarHorarios(){
    
        horarios.add(new Horario("A1"));
        horarios.add(new Horario("B2"));
        horarios.add(new Horario("C3"));
        horarios.add(new Horario("D4"));
        horarios.add(new Horario("E"));
        horarios.add(new Horario("F"));
        horarios.add(new Horario("G"));
        horarios.add(new Horario("H"));
        horarios.add(new Horario("I"));
        horarios.add(new Horario("J"));
        horarios.add(new Horario("K"));
        horarios.add(new Horario("L"));
        horarios.add(new Horario("M"));
        horarios.add(new Horario("N"));
        horarios.add(new Horario("O"));

        
        
    }
    
    public void gerarRestricao(){
        gerarResticaoHorario();
        gerarRestricaoMateria();
        
    }
    
    public void gerarResticaoHorario(){
        Professor lisbete = professores.get("lisbete");
        lisbete.addHoraDisp(horarios.get(0));
        lisbete.addHoraDisp(horarios.get(1));
        lisbete.addHoraDisp(horarios.get(3));
        lisbete.addHoraDisp(horarios.get(4));
        lisbete.addHoraDisp(horarios.get(6));
        lisbete.addHoraDisp(horarios.get(7));
        lisbete.addHoraDisp(horarios.get(9));
        lisbete.addHoraDisp(horarios.get(10));
        lisbete.addHoraDisp(horarios.get(12));
        lisbete.addHoraDisp(horarios.get(13));
        
        Professor milton = professores.get("milton");
        milton.addHoraDisp(horarios.get(2));
        milton.addHoraDisp(horarios.get(3));
        milton.addHoraDisp(horarios.get(4));
        milton.addHoraDisp(horarios.get(5));
        milton.addHoraDisp(horarios.get(8));
        milton.addHoraDisp(horarios.get(9));
        milton.addHoraDisp(horarios.get(10));
        milton.addHoraDisp(horarios.get(11));
        milton.addHoraDisp(horarios.get(14));
        
        
        
        Professor italo = professores.get("italo");
        italo.addHoraDisp(horarios.get(1));
        italo.addHoraDisp(horarios.get(2));
        italo.addHoraDisp(horarios.get(4));
        italo.addHoraDisp(horarios.get(5));
        italo.addHoraDisp(horarios.get(10));
        italo.addHoraDisp(horarios.get(11));
        italo.addHoraDisp(horarios.get(13));
        italo.addHoraDisp(horarios.get(14));
        
        Professor satoshi = professores.get("satoshi");
        satoshi.addHoraDisp(horarios.get(6));
        satoshi.addHoraDisp(horarios.get(7));
        satoshi.addHoraDisp(horarios.get(8));
        satoshi.addHoraDisp(horarios.get(12));
        satoshi.addHoraDisp(horarios.get(13));
        satoshi.addHoraDisp(horarios.get(14));
        
        Professor wladmir = professores.get("wladmir");
        wladmir.addHoraDisp(horarios.get(0));
        wladmir.addHoraDisp(horarios.get(2));
        wladmir.addHoraDisp(horarios.get(3));
        wladmir.addHoraDisp(horarios.get(6));
        wladmir.addHoraDisp(horarios.get(7));
        wladmir.addHoraDisp(horarios.get(13));
        wladmir.addHoraDisp(horarios.get(14));
        
        Professor carlos = professores.get("carlos");
        carlos.addHoraDisp(horarios.get(0));
        carlos.addHoraDisp(horarios.get(2));
        carlos.addHoraDisp(horarios.get(3));
        carlos.addHoraDisp(horarios.get(5));
        carlos.addHoraDisp(horarios.get(6));
        carlos.addHoraDisp(horarios.get(8));
        carlos.addHoraDisp(horarios.get(9));
        carlos.addHoraDisp(horarios.get(11));
        carlos.addHoraDisp(horarios.get(12));
        carlos.addHoraDisp(horarios.get(14));       
        
    }
    
    public void gerarRestricaoMateria(){
        Professor lisbete = professores.get("lisbete");
        lisbete.addMateria(materia.get("Algoritmos"));
        lisbete.addMateria(materia.get("EstruturaDeDados"));
        
        
        Professor milton = professores.get("milton");
        milton.addMateria(materia.get("Redes"));
        milton.addMateria(materia.get("LabRedes"));
        
        Professor italo = professores.get("italo");
        italo.addMateria(materia.get("OrientacaoObjetos"));
        italo.addMateria(materia.get("EngenhariaSoftware"));

        Professor satoshi = professores.get("satoshi");
        satoshi.addMateria(materia.get("BancoDeDados"));
        
        Professor wladmir = professores.get("wladmir");
        wladmir.addMateria(materia.get("EST"));
        
        Professor carlos = professores.get("carlos");
        carlos.addMateria(materia.get("ESP"));
    }
    
    public void inicializarAulas(Aula aula){
        
        for (Professor p: professores.values()){
            aula.addProfessor(p);
        }
        
        for (Materia m: materia.values()){
            aula.addMateria(m);
        }
        
        HashSet<Horario> hora = new HashSet<Horario>(horarios);
        aula.addHorario(hora);
    }
    
    public static void main (String args[]){
        
        Aplication apl = new Aplication();
      
        Aula aula = new Aula();
        
        apl.inicializarAulas(aula);
        
        Cronograma crono = new Cronograma(aula);
        
        crono.gerarModelo();
        
        
    }
    
    
    
}
