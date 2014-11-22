/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.ActionListener;

import GUIFinal.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Alexandre
 */
public class ComboOpcoesActionListener implements ActionListener{
   

    Principal _tela;
    public ComboOpcoesActionListener(Principal tela) {
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
