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
public class MockGenerico {
    



    Map<String, Professor> professores;
    Map<String, Materia> materias;
    List<Horario> horarios;
    Map<String, Semestre> semestres;
    
    char semestre = '@';
    public MockGenerico(){
        professores = new HashMap<String, Professor>();
        materias = new HashMap<String, Materia>();
        horarios = new ArrayList<Horario>();
        semestres = new HashMap<String, Semestre>();
        //semestre =  'A';
        
        int potenciaProblema = 13;
        gerarHorarios();
        gerarSemestres(potenciaProblema * 2);
        char posfix = 'A';
        for (int i = 0; i< potenciaProblema; i++){
            inicializar(posfix +  "");
            posfix++;
        }
        
    }
    
    public final void inicializar(String posfixo){
        gerarElementos(posfixo);
        gerarRestricao(posfixo);
    }
    
    public void gerarElementos(String posfixo){
        gerarProfessores( posfixo);
        gerarMaterias( posfixo);

        
    }
    public void gerarProfessores(String posfixo){
        professores.put("lisbete"+ posfixo, new Professor("Lisbete"+ posfixo));
        professores.put("milton"+ posfixo, new Professor("Milton"+ posfixo));
        professores.put("italo"+ posfixo, new Professor("Italo"+ posfixo));
        professores.put("satoshi"+ posfixo, new Professor("Satoshi"+ posfixo));
        professores.put("wladmir"+ posfixo, new Professor("Wladmir"+ posfixo));
        professores.put("carlos"+ posfixo, new Professor("Carlos"+ posfixo));
    }
    
    public void gerarMaterias(String posfixo){
        materias.put("Algoritmos"+ posfixo, new Materia("Algoritmos"+ posfixo, 2, "A"));
        materias.put("EstruturaDeDados"+ posfixo, new Materia("EstruturaDeDados"+ posfixo, 2, "A"));
        
        materias.put("Redes"+ posfixo, new Materia("Redes"+ posfixo, 1, "A"));
        materias.put("LabRedes"+ posfixo, new Materia("LabRedes"+ posfixo, 2, "A"));
        
        materias.put("OrientacaoObjetos"+ posfixo, new Materia("OrientacaoObjetos"+ posfixo, 1, "A"));
        materias.put("EngenhariaSoftware"+ posfixo, new Materia("EngenhariaDeSoftware"+ posfixo, 2, "A"));
        
        materias.put("BancoDeDados"+ posfixo, new Materia("BancoDeDados"+ posfixo, 2, "A"));
        
        materias.put("EST"+ posfixo, new Materia("EST"+ posfixo, 2, "A"));
        materias.put("ESP"+ posfixo, new Materia("ESP"+ posfixo, 1, "A"));
        
        
        
        
        materias.put("RedesII"+ posfixo, new Materia("RedesII"+ posfixo, 1, "B"));
        materias.put("LabRedesII"+ posfixo, new Materia("LabRedesII"+ posfixo, 2, "B"));
        
        materias.put("BancoDeDadosII"+ posfixo, new Materia("BancoDeDadosII"+ posfixo, 2, "B"));
        materias.put("LabBancoDeDadosII"+ posfixo, new Materia("LabBancoDeDadosII"+ posfixo, 2, "B"));
        
        materias.put("LPI"+ posfixo, new Materia("LPI"+ posfixo, 2, "B"));
        
        materias.put("LPII"+ posfixo, new Materia("LPII"+ posfixo, 2, "B"));
        
        materias.put("Grafos"+ posfixo, new Materia("Grafos"+ posfixo, 2, "B"));
        
        materias.put("SistemasDistribuidos"+ posfixo, new Materia("SistemasDistribuidos"+ posfixo, 2, "B"));
        
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
    
    public void gerarSemestres(int quantidade){
        char teste = 'A';
        
        for(int i = 0; i<quantidade; i++){
            semestres.put(teste + "", new Semestre(teste + ""));
            teste++;
        }
        /*        
        semestres.put("A", new Semestre("A"));
        semestres.put("B", new Semestre("B"));
        semestres.put("C", new Semestre("C"));
        semestres.put("D", new Semestre("D"));
        semestres.put("E", new Semestre("E"));
        semestres.put("F", new Semestre("F"));
        */
    }
    
    public void gerarRestricao(String posfixo){
        gerarResticaoHorario(posfixo);
        gerarRestricaoMateria(posfixo);
        gerarRestricaoSemestre(posfixo);
    }
    
    public void gerarResticaoHorario(String posfixo){
        Professor lisbete = professores.get("lisbete"+ posfixo);
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
        
        Professor milton = professores.get("milton"+ posfixo);
        milton.addHorarioDisponivel(horarios.get(2));
        milton.addHorarioDisponivel(horarios.get(3));
        milton.addHorarioDisponivel(horarios.get(4));
        milton.addHorarioDisponivel(horarios.get(5));
        milton.addHorarioDisponivel(horarios.get(8));
        milton.addHorarioDisponivel(horarios.get(9));
        milton.addHorarioDisponivel(horarios.get(10));
        milton.addHorarioDisponivel(horarios.get(11));
        milton.addHorarioDisponivel(horarios.get(14));
        
        
        
        Professor italo = professores.get("italo"+ posfixo);
        italo.addHorarioDisponivel(horarios.get(1));
        italo.addHorarioDisponivel(horarios.get(2));
        italo.addHorarioDisponivel(horarios.get(4));
        italo.addHorarioDisponivel(horarios.get(5));
        italo.addHorarioDisponivel(horarios.get(10));
        italo.addHorarioDisponivel(horarios.get(11));
        italo.addHorarioDisponivel(horarios.get(13));
        italo.addHorarioDisponivel(horarios.get(14));
        
        Professor satoshi = professores.get("satoshi"+ posfixo);
        satoshi.addHorarioDisponivel(horarios.get(6));
        satoshi.addHorarioDisponivel(horarios.get(7));
        satoshi.addHorarioDisponivel(horarios.get(8));
        satoshi.addHorarioDisponivel(horarios.get(12));
        satoshi.addHorarioDisponivel(horarios.get(13));
        satoshi.addHorarioDisponivel(horarios.get(14));
        
        Professor wladmir = professores.get("wladmir"+ posfixo);
        wladmir.addHorarioDisponivel(horarios.get(0));
        wladmir.addHorarioDisponivel(horarios.get(2));
        wladmir.addHorarioDisponivel(horarios.get(3));
        wladmir.addHorarioDisponivel(horarios.get(6));
        wladmir.addHorarioDisponivel(horarios.get(7));
        wladmir.addHorarioDisponivel(horarios.get(13));
        wladmir.addHorarioDisponivel(horarios.get(14));
        
        Professor carlos = professores.get("carlos"+ posfixo);
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
    
    public void gerarRestricaoMateria(String posfixo){
        Professor lisbete = professores.get("lisbete"+ posfixo);
        lisbete.addMateria(materias.get("Algoritmos"+ posfixo));
        lisbete.addMateria(materias.get("EstruturaDeDados"+ posfixo));
        lisbete.addMateria(materias.get("Grafos"+ posfixo));
        
        
        Professor milton = professores.get("milton"+ posfixo);
        milton.addMateria(materias.get("Redes"+ posfixo));
        milton.addMateria(materias.get("LabRedes"+ posfixo));
        milton.addMateria(materias.get("RedesII"+ posfixo));
        milton.addMateria(materias.get("LabRedesII"+ posfixo));
        
        
        Professor italo = professores.get("italo"+ posfixo);
        italo.addMateria(materias.get("OrientacaoObjetos"+ posfixo));
        italo.addMateria(materias.get("EngenhariaSoftware"+ posfixo));
        italo.addMateria(materias.get("LPII"+ posfixo));
        
        Professor satoshi = professores.get("satoshi"+ posfixo);
        satoshi.addMateria(materias.get("BancoDeDados"+ posfixo));
        satoshi.addMateria(materias.get("BancoDeDadosII"+ posfixo));
        satoshi.addMateria(materias.get("LabBancoDeDadosII"+ posfixo));
        
        Professor wladmir = professores.get("wladmir"+ posfixo);
        wladmir.addMateria(materias.get("EST"+ posfixo));
        wladmir.addMateria(materias.get("SistemasDistribuidos"+ posfixo));
        
        Professor carlos = professores.get("carlos"+ posfixo);
        carlos.addMateria(materias.get("ESP"+ posfixo));
        carlos.addMateria(materias.get("LPI"+ posfixo));
    }
    
    public void gerarRestricaoSemestre(String posfixo){
        semestre ++;
        System.out.println("Semestre: " + semestre );
        Semestre primeiro = semestres.get(semestre + "");
        
        primeiro.addMateria(materias.get("Algoritmos"+ posfixo));
        primeiro.addMateria(materias.get("EstruturaDeDados"+ posfixo));
        primeiro.addMateria(materias.get("Redes"+ posfixo));
        primeiro.addMateria(materias.get("LabRedes"+ posfixo));
        primeiro.addMateria(materias.get("OrientacaoObjetos"+ posfixo));
        primeiro.addMateria(materias.get("EngenhariaSoftware"+ posfixo));
        primeiro.addMateria(materias.get("BancoDeDados"+ posfixo));
        primeiro.addMateria(materias.get("EST"+ posfixo));
        primeiro.addMateria(materias.get("ESP"+ posfixo));
        
        semestre ++;
        System.out.println("Semestre: " + semestre );
        Semestre segundo = semestres.get(semestre + "");
        segundo.addMateria(materias.get("RedesII"+ posfixo));
        segundo.addMateria(materias.get("LabRedesII"+ posfixo));
        segundo.addMateria(materias.get("BancoDeDadosII"+ posfixo));
        segundo.addMateria(materias.get("LabBancoDeDadosII"+ posfixo));
        segundo.addMateria(materias.get("LPI"+ posfixo));
        segundo.addMateria(materias.get("LPII"+ posfixo));
        segundo.addMateria(materias.get("Grafos"+ posfixo));
        segundo.addMateria(materias.get("SistemasDistribuidos"+ posfixo));
        
        
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