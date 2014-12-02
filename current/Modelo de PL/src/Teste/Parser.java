/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Teste;

import Modelo.de.PL.Aula;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalIconFactory;

public class Parser {
    Aula _aula;
    int colum = 0;
    int row = 0;
    
    int numeroSemestre = 1;
    public Parser(Aula aula){
        _aula = aula;
    }
    
    public void gerarQuadro(String modelo){
        
        ArrayList<String> aulas ;
        colum = 5;
        row = 3;
        colum = _aula.getQuadroAltura();
        row = _aula.getQuadroLargura();
        
        
        JTabbedPane tabPanel = new JTabbedPane();
 
        JFrame frame = new JFrame("Quadro");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        
        aulas = parsearDados(modelo);
        
        gerarQuadro(tabPanel, aulas);
        
        frame.add(tabPanel);
        frame.setSize(1200, 400);
        frame.setVisible(true);
        
        
        /*
        tabPanel.addTab("Semestre 1", frame.getContentPane() );
        
        tabPanel.setSize(1200, 400);
        tabPanel.setVisible(true);
        */
    }
    
    private ArrayList<String> parsearDados(String dados){
        ArrayList<String> aulas = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(\\w+&\\w+&[a-zA-Z&]+);1");
        Matcher matcher = pattern.matcher(dados);
        while (matcher.find()) {
           
            aulas.add(matcher.group(1));
        }
        
        Collections.sort(aulas.subList(0, aulas.size()));
        
        return aulas;
    }
    
    private boolean aulaVazia(String aula, char[] pos){
        boolean status = false;
        List <Character> aulaPosList = new ArrayList<>();
        aulaPosList.toArray();
        char [] aulaPos = aula.toCharArray();
        
        
        for(int i = 0; i< pos.length; i++ ){

            if(aulaPos[i] != pos[i]){
                status = true;
            } 
        }
        
        return status;
    }
    
    private void incrementarPosicao(char[] pos){
        // Suporta até 676 posições 26*26 (verifico apenas a ultima letra e aumento a penultima.
        
        int size = pos.length;
        char begin = 'A';
        char end = 'Z';
        char last = pos[size -1];
        try{
            if(last == end){
                pos[size - 2]++;
                pos[size -1] = begin;
            }
            else{
                pos[size-1]++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
        
        //return pos;
    }
    
    private void gerarPainel(JTabbedPane tabPanel, List<String> aulas){
        
        JPanel panel = new JPanel(new GridLayout(row,colum));
        List<JLabel> labels = new ArrayList<JLabel>();
        JLabel jl;
        Border border = LineBorder.createGrayLineBorder();
        String nomeSemestre = null;
        
        
        int total = row * colum;
        for(int i = 0; i < total; i++){
            jl = new JLabel();
            jl.setBorder(border);
            jl.setHorizontalAlignment( SwingConstants.CENTER );
            labels.add(jl);
            panel.add(jl);
        }
        
        completarPainel(labels, aulas);
        nomeSemestre = "Semestre " + numeroSemestre;
        tabPanel.addTab(nomeSemestre, panel);
        numeroSemestre ++;
        
        
        
    }
    
    private void completarPainel(List<JLabel> labels, List<String> lista){
        JLabel jl = null;
        int col = 0;
        int linha = 0;
        int pos = 0;
        for(String s: lista){
            pos = (linha * colum) + col;
            jl = labels.get(pos);
            jl.setText(s);
            linha++;
            if(linha % row == 0){
                linha = 0;
                col++;     
            }
        }
    }
    
    private void gerarQuadro(JTabbedPane tabPanel, ArrayList<String> aulas){
        AulaQuadro quadro;
        boolean vazio = aulas.isEmpty();
        List<String> lista = new ArrayList<String>();
        char[] posQuadro = null;
        char[] contadorSemestre = null;
        
        
        String a = aulas.get(0);
        String [] stats = a.split("&");
        quadro = new AulaQuadro(stats);
        String prof = quadro.getProfessor();
        String mat = quadro.getMateria();
        String aula = quadro.getAula();
        String semestre = quadro.getSemestre();
        int sizeAula = aula.length();
        int sizeSemestre = semestre.length();
        
        posQuadro = iniciarContador(sizeAula);
        contadorSemestre = iniciarContador(sizeSemestre);
        
        
        if(semestreDiferente(semestre, contadorSemestre)){
            gerarPainel(tabPanel,lista);
            lista = new ArrayList<String>();
            incrementarPosicao(contadorSemestre);
            posQuadro = iniciarContador(posQuadro.length);
        }

        if(aulaVazia(aula, posQuadro)){
            /*
            String text = "<html><center>" + "----" + "<br>" + "----" + "</center>";
            */
            String text =  "";
            lista.add(text);

            incrementarPosicao(posQuadro);
        }
        
        else{
            String text = "<html><center>" + prof + "<br>" + mat + "</center>";
            lista.add(text);

            incrementarPosicao(posQuadro);

            aulas.remove(0);
        }
           
        for (String au: aulas){
            stats = au.split("&");
            quadro = new AulaQuadro(stats);
            prof = quadro.getProfessor();
            mat = quadro.getMateria();
            aula = quadro.getAula();
            semestre = quadro.getSemestre();
            if(semestreDiferente(semestre, contadorSemestre)){
                gerarPainel(tabPanel,lista);
                lista = new ArrayList<String>();
                incrementarPosicao(contadorSemestre);
                posQuadro = iniciarContador(posQuadro.length);
                
            }
            
            while(aulaVazia(aula, posQuadro)){
                
                //String text = "<html><center>" + "----" + "<br>" + "----" + "</center>";
                String text =  "";
                lista.add(text);
                
                incrementarPosicao(posQuadro);
            }
            
            String text = "<html><center>" + prof + "<br>" + mat + "</center>";
            lista.add(text);

            incrementarPosicao(posQuadro);

            
        }
        
        
        gerarPainel(tabPanel,lista);
        
        
    }
    
    private boolean semestreDiferente(String semestre, char[] posQuadro){
        boolean status;
        status = aulaVazia(semestre, posQuadro);
        return status;
    }
    
    
    private char[] iniciarContador( int size){
        List<Character> contadorLista = new ArrayList<>();
        char []contador = new char[size];
        for(int i = 0; i < size; i++){
            contadorLista.add('A');
            contador[i] = 'A';
        }
        
        return contador;
    }
        
    
    
    
    public static void main (String args[]){
       //Parser p= new Parser();
       //p.gerarQuadro(String teste);
    }
}