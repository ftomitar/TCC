/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Teste;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalIconFactory;

public class Parser {

    public Parser(){
        
    }
    public void gerarQuadro(String modelo){
        AulaQuadro quadro;
        ArrayList<String> aulas = new ArrayList<String>();
        Pattern pattern = Pattern.compile("([a-zA-Z&]+);(1)");
        Matcher matcher = pattern.matcher(modelo);
        
        
        
        JFrame frame = new JFrame("Quadro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3,5));

        Border border = LineBorder.createGrayLineBorder();
        Icon warnIcon = MetalIconFactory.getTreeComputerIcon();
        
        
        
        
        while (matcher.find()) {
           
            aulas.add(matcher.group(1));
        }
        Collections.sort(aulas.subList(1, aulas.size()));
        Set<JLabel> labels = new HashSet<JLabel>();
        JLabel jl;
        
        boolean vazio = aulas.isEmpty();
        
        while(!vazio){
            String a = aulas.get(0);
            String [] stats = a.split("&");
            quadro = new AulaQuadro(stats);
            String prof = quadro.getProfessor();
            String mat = quadro.getMateria();
            //String aula = quadro.getAula();
            
            String text = "<html>" + prof + "<br>" + mat;
            jl = new JLabel();
            jl.setText(text);
            jl.setBorder(border);
            frame.add(jl);
            
            aulas.remove(0);
            vazio = aulas.isEmpty();
        }
        

        frame.setSize(1200, 400);
        frame.setVisible(true);
    }
    
    public static void main (String args[]){
       Parser p= new Parser();
       //p.gerarQuadro(String teste);
    }
}