/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Teste;

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
    int colum = 0;
    int row = 0;
    public Parser(){
        
    }
    public void gerarQuadro(String modelo){
        AulaQuadro quadro;
        ArrayList<String> aulas = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(\\w+&\\w+&[a-zA-Z&]+);1");
        Matcher matcher = pattern.matcher(modelo);
        
        List<JLabel> labels = new ArrayList<JLabel>();
        JLabel jl;
        
        
        colum = 5;
        row = 3;
        
        JTabbedPane tabPanel = new JTabbedPane();
        
        
        
        
        JFrame frame = new JFrame("Quadro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.setLayout(new GridLayout(row,colum));

        Border border = LineBorder.createGrayLineBorder();
        
        JPanel panel = new JPanel(new GridLayout(row,colum));
        
        
        
        
        while (matcher.find()) {
           
            aulas.add(matcher.group(1));
        }
        
        Collections.sort(aulas.subList(0, aulas.size()));
        
        int total = row * colum;
        for(int i = 0; i < total; i++){
            jl = new JLabel();
            jl.setBorder(border);
            jl.setHorizontalAlignment( SwingConstants.CENTER );
            labels.add(jl);
            panel.add(jl);
        }
        
        
        
        /*
        for(String s: aulas){
            System.out.println(s);
        }
        */
        
        
        boolean vazio = aulas.isEmpty();
        List<String> lista = new ArrayList<String>();
        char[] posQuadro = null;
        
        if(!vazio){
            String a = aulas.get(0);
            String [] stats = a.split("&");
            quadro = new AulaQuadro(stats);
            String prof = quadro.getProfessor();
            String mat = quadro.getMateria();
            String aula = quadro.getAula();
            int size = aula.length();
            posQuadro = new char[size];
            
            for(int i = 0; i < aula.length(); i++){
                posQuadro[i] = 'A';
            }
            
            if(aulaVazia(aula, posQuadro)){
                String text = "<html><center>" + "----" + "<br>" + "----" + "</center>";
                lista.add(text);
                posQuadro = incrementarPosicao(posQuadro);
            }
            else{
                String text = "<html><center>" + prof + "<br>" + mat + "</center>";
                lista.add(text);
                
                posQuadro = incrementarPosicao(posQuadro);
                
                aulas.remove(0);
                vazio = aulas.isEmpty();
            }
            
            
        }
        
        
        while(!vazio){
            String a = aulas.get(0);
            String [] stats = a.split("&");
            quadro = new AulaQuadro(stats);
            String prof = quadro.getProfessor();
            String mat = quadro.getMateria();
            String aula = quadro.getAula();
            
            
            if(aulaVazia(aula, posQuadro)){
                String text = "<html><center>" + "----" + "<br>" + "----" + "</center>";
                lista.add(text);
                posQuadro = incrementarPosicao(posQuadro);
            }
            else{
                String text = "<html><center>" + prof + "<br>" + mat + "</center>";
                lista.add(text);
                
                posQuadro = incrementarPosicao(posQuadro);
                
                aulas.remove(0);
                vazio = aulas.isEmpty();
            }
        }
        
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
            
            /*
            System.out.println(linha);
            System.out.println(col);
            apont = (col*linha);
            pos = (col*linha) - 1;
            jl = labels.get(pos);
            
            jl.setText(s);
            linha ++;
            if ((linha - 1) % row == 0){
                col++;
                linha = 1;
            }
                    
            */
            
            
        }
        
        tabPanel.addTab("Semestre 1", panel);
        frame.add(tabPanel);
        
        frame.setSize(1200, 400);
        frame.setVisible(true);
        
        /*
        tabPanel.addTab("Semestre 1", frame.getContentPane() );
        
        tabPanel.setSize(1200, 400);
        tabPanel.setVisible(true);
        */
    }
    
    public boolean aulaVazia(String aula, char[] pos){
        boolean status = false;
        
        char [] aulaPos = aula.toCharArray();
        
        
        for(int i = 0; i< pos.length; i++ ){

            if(aulaPos[i] != pos[i]){
                status = true;
            } 
        }
        
        return status;
    }
    
    public char[] incrementarPosicao(char[] pos){
        int size = pos.length;
        char end = 'Z';
        char last = pos[size -1];
        
        if(last == end){
            pos[size - 2]++;
        }
        else{
            pos[size-1]++;
        }
        return pos;
    }
    
    
    
    public static void main (String args[]){
       Parser p= new Parser();
       //p.gerarQuadro(String teste);
    }
}