package Modelo.de.PL;

import LPSolveComunication.LPSolveInterface;
import LPSolveComunication.FileManager;

import Teste.Parser;

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
    Map<String, Materia> materias;
    List<Horario> horarios;
    Map<String, Semestre> semestres;
    public Aplication(){
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
    }
    
    public void gerarRestricao(){
        gerarResticaoHorario();
        gerarRestricaoMateria();
        gerarRestricaoSemestre();
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
    
    public static void main (String args[]){
        
        String file = "files//model_LP.txt";
        
        String type = "";
        
        type = "file";
        //type = "terminal";
        
        Aplication apl = new Aplication();
      
        Aula aula = new Aula();
        
        apl.inicializarAulas(aula);
        
        
        
        if(type.equals("file")){
            
        
            IModelOutput outputManager = new FileManager(file);

            Cronograma crono = new Cronograma(aula, outputManager);

            crono.gerarModelo();

            LPSolveInterface lpsolve = new LPSolveInterface(file);

            String solution = lpsolve.solveModel();

            System.out.println(solution);

            Parser parser = new Parser();

            parser.gerarQuadro(solution);
        
        }
        
        else if (type.equals("terminal")){
            IModelOutput outputManager = new TerminalOutput();
            
            Cronograma crono = new Cronograma(aula, outputManager);
        
            crono.gerarModelo();
        }
        /*
        Aplication apl = new Aplication();
      
        Aula aula = new Aula();
        
        apl.inicializarAulas(aula);
        
        Cronograma crono = new Cronograma(aula);
        
        crono.gerarModelo();
        */
        
    }
    
    
    
}
