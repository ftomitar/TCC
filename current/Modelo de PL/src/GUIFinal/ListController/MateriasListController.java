/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.ListController;

import GUIFinal.Principal;
import Modelo.de.PL.Aula;
import javax.swing.JList;

/**
 *
 * @author aaratame
 */
public class MateriasListController implements IListController{
    
    private Principal _tela;
    private JList _listaPrincipal;
    private Aula _aula;

    public MateriasListController(Principal tela, JList listaPrincipal, Aula aula){
        _tela = tela;
        _listaPrincipal = listaPrincipal;
        _aula = aula;
    }

    
    @Override
    public void adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Object escolhido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover() {
        _tela.removeElements(_aula.getMaterias());
    }

    @Override
    public void refresh() {
        _listaPrincipal.setListData(_aula.getMaterias().toArray());
    }
    
}
