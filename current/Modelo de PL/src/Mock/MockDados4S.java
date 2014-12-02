/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mock;

import Modelo.de.PL.Aula;
import Modelo.de.PL.Horario;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;
import Modelo.de.PL.Semestre;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alexandre
 */
public class MockDados4S {
    Map<String, Professor> professores;
    Map<String, Materia> materias;
    List<Horario> horarios;
    Map<String, Semestre> semestres;
    public MockDados4S(){
        professores = new HashMap<String, Professor>();
        materias = new HashMap<String, Materia>();
        horarios = new ArrayList<Horario>();
        semestres = new HashMap<String, Semestre>();
        inicializar();
    }
    
    public final void inicializar(){
        gerarElementos();
        gerarRestricao();
    }
    
    public void gerarElementos(){
        gerarProfessores();
        gerarMaterias();
        gerarHorarios();
        gerarSemestres();
        
    }
    
    public void gerarProfessores(){
        professores.put("lisbete", new Professor("Lisbete"));
        professores.put("milton", new Professor("Milton"));
        professores.put("italo", new Professor("Italo"));
        professores.put("satoshi", new Professor("Satoshi"));
        professores.put("wladmir", new Professor("Wladmir"));
        professores.put("carlos", new Professor("Carlos"));
        
        professores.put("carla", new Professor("carla"));
        professores.put("vega", new Professor("vega"));
        professores.put("bicas", new Professor("bicas"));
        professores.put("marye", new Professor("marye"));
        professores.put("ferrari", new Professor("ferrari"));
        professores.put("felipe", new Professor("felipe"));

        
        
    }
    
    public void gerarMaterias(){
        materias.put("Algoritmos", new Materia("Algoritmos", 2, "A"));
        materias.put("EstruturaDeDados", new Materia("EstruturaDeDados", 2, "A"));
        
        materias.put("Redes", new Materia("Redes", 1, "A"));
        materias.put("LabRedes", new Materia("LabRedes", 2, "A"));
        
        materias.put("OrientacaoObjetos", new Materia("OrientacaoObjetos", 1, "A"));
        materias.put("EngenhariaSoftware", new Materia("EngenhariaDeSoftware", 2, "A"));
        
        materias.put("BancoDeDados", new Materia("BancoDeDados", 2, "A"));
        
        materias.put("EST", new Materia("EST", 2, "A"));
        materias.put("ESP", new Materia("ESP", 1, "A"));
        
        
        
        
        materias.put("RedesII", new Materia("RedesII", 1, "B"));
        materias.put("LabRedesII", new Materia("LabRedesII", 2, "B"));
        
        materias.put("BancoDeDadosII", new Materia("BancoDeDadosII", 2, "B"));
        materias.put("LabBancoDeDadosII", new Materia("LabBancoDeDadosII", 2, "B"));
        
        materias.put("LPI", new Materia("LPI", 2, "B"));
        
        materias.put("LPII", new Materia("LPII", 2, "B"));
        
        materias.put("Grafos", new Materia("Grafos", 2, "B"));
        
        materias.put("SistemasDistribuidos", new Materia("SistemasDistribuidos", 2, "B"));
        
        
        materias.put("AlgoritmosII", new Materia("AlgoritmosII", 2, "A"));
        materias.put("EstruturaDeDadosII", new Materia("EstruturaDeDadosII", 2, "A"));
        
        materias.put("RedesAB", new Materia("RedesAB", 1, "A"));
        materias.put("LabRedesAB", new Materia("LabRedesAB", 2, "A"));
        
        materias.put("OrientacaoObjetosII", new Materia("OrientacaoObjetosII", 1, "A"));
        materias.put("EngenhariaSoftwareII", new Materia("EngenhariaDeSoftwareII", 2, "A"));
        
        materias.put("BancoDeDadosAB", new Materia("BancoDeDadosAB", 2, "A"));
        
        materias.put("ESTAB", new Materia("EST", 2, "A"));
        materias.put("ESPAB", new Materia("ESP", 1, "A"));
        
        
        
        
        materias.put("RedesIIAB", new Materia("RedesIIAB", 1, "B"));
        materias.put("LabRedesIIAB", new Materia("LabRedesIIAB", 2, "B"));
        
        materias.put("BancoDeDadosIIAB", new Materia("BancoDeDadosIIAB", 2, "B"));
        materias.put("LabBancoDeDadosIIAB", new Materia("LabBancoDeDadosIIAB", 2, "B"));
        
        materias.put("LPIAB", new Materia("LPIAB", 2, "B"));
        
        materias.put("LPIIAB", new Materia("LPIIAB", 2, "B"));
        
        materias.put("GrafosAB", new Materia("GrafosAB", 2, "B"));
        
        materias.put("SistemasDistribuidosAB", new Materia("SistemasDistribuidosAB", 2, "B"));
        
    }
    
    public void gerarHorarios(){
    
        horarios.add(new Horario("A"));
        horarios.add(new Horario("B"));
        horarios.add(new Horario("C"));
        horarios.add(new Horario("D"));
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
    
    public void gerarSemestres(){
        semestres.put("A", new Semestre("A"));
        semestres.put("B", new Semestre("B"));
        semestres.put("C", new Semestre("C"));
        semestres.put("D", new Semestre("D"));
    }
    
    public void gerarRestricao(){
        gerarResticaoHorario();
        gerarRestricaoMateria();
        gerarRestricaoSemestre();
    }
    
    public void gerarResticaoHorario(){
        Professor lisbete = professores.get("lisbete");
        lisbete.addHorarioDisponivel(horarios.get(0));
        lisbete.addHorarioDisponivel(horarios.get(1));
        lisbete.addHorarioDisponivel(horarios.get(3));
        lisbete.addHorarioDisponivel(horarios.get(4));
        lisbete.addHorarioDisponivel(horarios.get(6));
        lisbete.addHorarioDisponivel(horarios.get(7));
        lisbete.addHorarioDisponivel(horarios.get(9));
        lisbete.addHorarioDisponivel(horarios.get(10));
        lisbete.addHorarioDisponivel(horarios.get(12));
        lisbete.addHorarioDisponivel(horarios.get(13));
        
        Professor milton = professores.get("milton");
        milton.addHorarioDisponivel(horarios.get(2));
        milton.addHorarioDisponivel(horarios.get(3));
        milton.addHorarioDisponivel(horarios.get(4));
        milton.addHorarioDisponivel(horarios.get(5));
        milton.addHorarioDisponivel(horarios.get(8));
        milton.addHorarioDisponivel(horarios.get(9));
        milton.addHorarioDisponivel(horarios.get(10));
        milton.addHorarioDisponivel(horarios.get(11));
        milton.addHorarioDisponivel(horarios.get(14));
        
        
        
        Professor italo = professores.get("italo");
        italo.addHorarioDisponivel(horarios.get(1));
        italo.addHorarioDisponivel(horarios.get(2));
        italo.addHorarioDisponivel(horarios.get(4));
        italo.addHorarioDisponivel(horarios.get(5));
        italo.addHorarioDisponivel(horarios.get(10));
        italo.addHorarioDisponivel(horarios.get(11));
        italo.addHorarioDisponivel(horarios.get(13));
        italo.addHorarioDisponivel(horarios.get(14));
        
        Professor satoshi = professores.get("satoshi");
        satoshi.addHorarioDisponivel(horarios.get(6));
        satoshi.addHorarioDisponivel(horarios.get(7));
        satoshi.addHorarioDisponivel(horarios.get(8));
        satoshi.addHorarioDisponivel(horarios.get(12));
        satoshi.addHorarioDisponivel(horarios.get(13));
        satoshi.addHorarioDisponivel(horarios.get(14));
        
        Professor wladmir = professores.get("wladmir");
        wladmir.addHorarioDisponivel(horarios.get(0));
        wladmir.addHorarioDisponivel(horarios.get(2));
        wladmir.addHorarioDisponivel(horarios.get(3));
        wladmir.addHorarioDisponivel(horarios.get(6));
        wladmir.addHorarioDisponivel(horarios.get(7));
        wladmir.addHorarioDisponivel(horarios.get(13));
        wladmir.addHorarioDisponivel(horarios.get(14));
        
        Professor carlos = professores.get("carlos");
        carlos.addHorarioDisponivel(horarios.get(0));
        carlos.addHorarioDisponivel(horarios.get(2));
        carlos.addHorarioDisponivel(horarios.get(3));
        carlos.addHorarioDisponivel(horarios.get(5));
        carlos.addHorarioDisponivel(horarios.get(6));
        carlos.addHorarioDisponivel(horarios.get(8));
        carlos.addHorarioDisponivel(horarios.get(9));
        carlos.addHorarioDisponivel(horarios.get(11));
        carlos.addHorarioDisponivel(horarios.get(12));
        carlos.addHorarioDisponivel(horarios.get(14));
        
        
        lisbete = professores.get("carla");
        lisbete.addHorarioDisponivel(horarios.get(0));
        lisbete.addHorarioDisponivel(horarios.get(1));
        lisbete.addHorarioDisponivel(horarios.get(3));
        lisbete.addHorarioDisponivel(horarios.get(4));
        lisbete.addHorarioDisponivel(horarios.get(6));
        lisbete.addHorarioDisponivel(horarios.get(7));
        lisbete.addHorarioDisponivel(horarios.get(9));
        lisbete.addHorarioDisponivel(horarios.get(10));
        lisbete.addHorarioDisponivel(horarios.get(12));
        lisbete.addHorarioDisponivel(horarios.get(13));
        
        milton = professores.get("vega");
        milton.addHorarioDisponivel(horarios.get(2));
        milton.addHorarioDisponivel(horarios.get(3));
        milton.addHorarioDisponivel(horarios.get(4));
        milton.addHorarioDisponivel(horarios.get(5));
        milton.addHorarioDisponivel(horarios.get(8));
        milton.addHorarioDisponivel(horarios.get(9));
        milton.addHorarioDisponivel(horarios.get(10));
        milton.addHorarioDisponivel(horarios.get(11));
        milton.addHorarioDisponivel(horarios.get(14));
        
        
        
        italo = professores.get("bicas");
        italo.addHorarioDisponivel(horarios.get(1));
        italo.addHorarioDisponivel(horarios.get(2));
        italo.addHorarioDisponivel(horarios.get(4));
        italo.addHorarioDisponivel(horarios.get(5));
        italo.addHorarioDisponivel(horarios.get(10));
        italo.addHorarioDisponivel(horarios.get(11));
        italo.addHorarioDisponivel(horarios.get(13));
        italo.addHorarioDisponivel(horarios.get(14));
        
        satoshi = professores.get("marye");
        satoshi.addHorarioDisponivel(horarios.get(6));
        satoshi.addHorarioDisponivel(horarios.get(7));
        satoshi.addHorarioDisponivel(horarios.get(8));
        satoshi.addHorarioDisponivel(horarios.get(12));
        satoshi.addHorarioDisponivel(horarios.get(13));
        satoshi.addHorarioDisponivel(horarios.get(14));
        
        wladmir = professores.get("ferrari");
        wladmir.addHorarioDisponivel(horarios.get(0));
        wladmir.addHorarioDisponivel(horarios.get(2));
        wladmir.addHorarioDisponivel(horarios.get(3));
        wladmir.addHorarioDisponivel(horarios.get(6));
        wladmir.addHorarioDisponivel(horarios.get(7));
        wladmir.addHorarioDisponivel(horarios.get(13));
        wladmir.addHorarioDisponivel(horarios.get(14));
        
        carlos = professores.get("felipe");
        carlos.addHorarioDisponivel(horarios.get(0));
        carlos.addHorarioDisponivel(horarios.get(2));
        carlos.addHorarioDisponivel(horarios.get(3));
        carlos.addHorarioDisponivel(horarios.get(5));
        carlos.addHorarioDisponivel(horarios.get(6));
        carlos.addHorarioDisponivel(horarios.get(8));
        carlos.addHorarioDisponivel(horarios.get(9));
        carlos.addHorarioDisponivel(horarios.get(11));
        carlos.addHorarioDisponivel(horarios.get(12));
        carlos.addHorarioDisponivel(horarios.get(14));
    }
    
    public void gerarRestricaoMateria(){
        Professor lisbete = professores.get("lisbete");
        lisbete.addMateria(materias.get("Algoritmos"));
        lisbete.addMateria(materias.get("EstruturaDeDados"));
        lisbete.addMateria(materias.get("Grafos"));
        
        
        Professor milton = professores.get("milton");
        milton.addMateria(materias.get("Redes"));
        milton.addMateria(materias.get("LabRedes"));
        milton.addMateria(materias.get("RedesII"));
        milton.addMateria(materias.get("LabRedesII"));
        
        
        Professor italo = professores.get("italo");
        italo.addMateria(materias.get("OrientacaoObjetos"));
        italo.addMateria(materias.get("EngenhariaSoftware"));
        italo.addMateria(materias.get("LPII"));
        
        Professor satoshi = professores.get("satoshi");
        satoshi.addMateria(materias.get("BancoDeDados"));
        satoshi.addMateria(materias.get("BancoDeDadosII"));
        satoshi.addMateria(materias.get("LabBancoDeDadosII"));
        
        Professor wladmir = professores.get("wladmir");
        wladmir.addMateria(materias.get("EST"));
        wladmir.addMateria(materias.get("SistemasDistribuidos"));
        
        Professor carlos = professores.get("carlos");
        carlos.addMateria(materias.get("ESP"));
        carlos.addMateria(materias.get("LPI"));
        
        
        lisbete = professores.get("carla");
        lisbete.addMateria(materias.get("AlgoritmosII"));
        lisbete.addMateria(materias.get("EstruturaDeDadosII"));
        lisbete.addMateria(materias.get("GrafosAB"));
        
        
        milton = professores.get("vega");
        milton.addMateria(materias.get("RedesAB"));
        milton.addMateria(materias.get("LabRedesAB"));
        milton.addMateria(materias.get("RedesIIAB"));
        milton.addMateria(materias.get("LabRedesIIAB"));
        
        
        italo = professores.get("bicas");
        italo.addMateria(materias.get("OrientacaoObjetosII"));
        italo.addMateria(materias.get("EngenhariaSoftwareII"));
        italo.addMateria(materias.get("LPIIAB"));
        
        satoshi = professores.get("marye");
        satoshi.addMateria(materias.get("BancoDeDadosAB"));
        satoshi.addMateria(materias.get("BancoDeDadosIIAB"));
        satoshi.addMateria(materias.get("LabBancoDeDadosIIAB"));
        
        wladmir = professores.get("ferrari");
        wladmir.addMateria(materias.get("ESTAB"));
        wladmir.addMateria(materias.get("SistemasDistribuidosAB"));
        
        carlos = professores.get("felipe");
        carlos.addMateria(materias.get("ESPAB"));
        carlos.addMateria(materias.get("LPIAB"));
    }
    
    public void gerarRestricaoSemestre(){
        Semestre primeiro = semestres.get("A");
        
        primeiro.addMateria(materias.get("Algoritmos"));
        primeiro.addMateria(materias.get("EstruturaDeDados"));
        primeiro.addMateria(materias.get("Redes"));
        primeiro.addMateria(materias.get("LabRedes"));
        primeiro.addMateria(materias.get("OrientacaoObjetos"));
        primeiro.addMateria(materias.get("EngenhariaSoftware"));
        primeiro.addMateria(materias.get("BancoDeDados"));
        primeiro.addMateria(materias.get("EST"));
        primeiro.addMateria(materias.get("ESP"));
        
        
        Semestre segundo = semestres.get("B");
        segundo.addMateria(materias.get("RedesII"));
        segundo.addMateria(materias.get("LabRedesII"));
        segundo.addMateria(materias.get("BancoDeDadosII"));
        segundo.addMateria(materias.get("LabBancoDeDadosII"));
        segundo.addMateria(materias.get("LPI"));
        segundo.addMateria(materias.get("LPII"));
        segundo.addMateria(materias.get("Grafos"));
        segundo.addMateria(materias.get("SistemasDistribuidos"));
        
        
        primeiro = semestres.get("C");
        
        primeiro.addMateria(materias.get("AlgoritmosII"));
        primeiro.addMateria(materias.get("EstruturaDeDadosII"));
        primeiro.addMateria(materias.get("RedesAB"));
        primeiro.addMateria(materias.get("LabRedesAB"));
        primeiro.addMateria(materias.get("OrientacaoObjetosII"));
        primeiro.addMateria(materias.get("EngenhariaSoftwareII"));
        primeiro.addMateria(materias.get("BancoDeDadosAB"));
        primeiro.addMateria(materias.get("ESTAB"));
        primeiro.addMateria(materias.get("ESPAB"));
        
        
        segundo = semestres.get("D");
        segundo.addMateria(materias.get("RedesIIAB"));
        segundo.addMateria(materias.get("LabRedesIIAB"));
        segundo.addMateria(materias.get("BancoDeDadosIIAB"));
        segundo.addMateria(materias.get("LabBancoDeDadosIIAB"));
        segundo.addMateria(materias.get("LPIAB"));
        segundo.addMateria(materias.get("LPIIAB"));
        segundo.addMateria(materias.get("GrafosAB"));
        segundo.addMateria(materias.get("SistemasDistribuidosAB"));
        
        
    }
    
    
    public void inicializarAulas(Aula aula){
        
        for (Professor p: professores.values()){
            aula.addProfessor(p);
        }
        
        for (Materia m: materias.values()){
            aula.addMateria(m);
        }
        
        HashSet<Horario> hora = new HashSet<Horario>(horarios);
        aula.addHorario(hora);
        
        for (Semestre s: semestres.values()){
            aula.addSemestre(s);
        }
    }
}
