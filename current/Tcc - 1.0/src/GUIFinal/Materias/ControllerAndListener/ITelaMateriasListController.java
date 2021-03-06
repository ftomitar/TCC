/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.Materias.ControllerAndListener;

import Modelo.de.PL.Materia;
import java.util.Vector;
import javax.swing.JList;

/**
 *
 * @author Alexandre
 */
public interface ITelaMateriasListController {
    
    public void criarElemento(String nome, int quantidade);
    
    public Materia recriarMateria(Materia mat);
    
    public void atualizarListas();
    
    public void trocarElementos(JList lista, Vector origem, Vector destino);
    
    public void resetarElementos();
    
    public void refresh();
    
}
