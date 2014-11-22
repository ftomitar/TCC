/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.Materias.ControllerAndListener;

import GUIFinal.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Alexandre
 */


public class ComboOptionActionListener implements ActionListener{
   

    ITelaMateria _tela;
    public ComboOptionActionListener(ITelaMateria tela) {
        _tela = tela;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String name = (String)cb.getSelectedItem();
        System.out.println(name);
        
        _tela.comboSelectElement(name);
    }
    

    
}
