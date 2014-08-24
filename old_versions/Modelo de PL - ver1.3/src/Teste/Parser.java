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
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        Pattern pattern = Pattern.compile("(\\w+&[a-zA-Z&]+);1");
        Matcher matcher = pattern.matcher(modelo);
        colum = 5;
        row = 3;
        
        
        
        JFrame frame = new JFrame("Quadro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(row,colum));

        Border border = LineBorder.createGrayLineBorder();
        
        
        
        
        
        while (matcher.find()) {
           
            aulas.add(matcher.group(1));
        }
        Collections.sort(aulas.subList(0, aulas.size()));
        List<JLabel> labels = new ArrayList<JLabel>();
        JLabel jl;
        int total = row * colum;
        for(int i = 0; i < total; i++){
            jl = new JLabel();
            jl.setBorder(border);
            jl.setHorizontalAlignment( SwingConstants.CENTER );
            labels.add(jl);
            frame.add(jl);
        }
            
        for(String s: aulas){
            System.out.println(s);
        }
        
        
        
        boolean vazio = aulas.isEmpty();
        List<String> lista = new ArrayList<String>();
        
        while(!vazio){
            String a = aulas.get(0);
            String [] stats = a.split("&");
            quadro = new AulaQuadro(stats);
            String prof = quadro.getProfessor();
            String mat = quadro.getMateria();
            //String aula = quadro.getAula();
            
            String text = "<html><center>" + prof + "<br>" + mat + "</center>";
            lista.add(text);
            
            
            aulas.remove(0);
            vazio = aulas.isEmpty();
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
        
        
        

        frame.setSize(1200, 400);
        frame.setVisible(true);
    }
    
    
    
    public static void main (String args[]){
       Parser p= new Parser();
       //p.gerarQuadro(String teste);
    }
}