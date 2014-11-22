package GUIFinal.Horarios;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class TelaHorarios {
    int colum = 0;
    int row = 0;
    
    int numeroSemestre = 1;
    public TelaHorarios(){
        
    }
    
    public void gerarQuadro(String modelo){
        
        ArrayList<String> aulas ;
        colum = 5;
        row = 3;
        
        JTabbedPane tabPanel = new JTabbedPane();
 
        JFrame frame = new JFrame("Quadro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        frame.add(tabPanel);
        frame.setSize(1200, 400);
        frame.setVisible(true);
        
        
        /*
        tabPanel.addTab("Semestre 1", frame.getContentPane() );
        
        tabPanel.setSize(1200, 400);
        tabPanel.setVisible(true);
        */
    }
    

}