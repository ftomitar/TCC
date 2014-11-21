/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.Professores;

import Modelo.de.PL.Aula;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alexandre
 */
public class EditarHorarios extends JFrame{
    private int _row;
    private int _colum;
    //TODO: verificar se é melhor mostrar as aulas na horizontal ou vertical.
    public EditarHorarios(Aula aula){
        
    }
    
    
    private void gerarPainel(JTabbedPane tabPanel, List<String> aulas){
        
        JPanel panel = new JPanel(new GridLayout(_row,_colum));
        List<JLabel> labels = new ArrayList<JLabel>();
        JLabel jl;
        Border border = LineBorder.createGrayLineBorder();
        String nomeSemestre = null;
        
        
        int total = _row * _colum;
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
            pos = (linha * _colum) + col;
            jl = labels.get(pos);
            jl.setText(s);
            linha++;
            if(linha % _row == 0){
                linha = 0;
                col++;     
            }
        }
    }
}
