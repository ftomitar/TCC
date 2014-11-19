/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.ListController;

import GUIFinal.AdicionarProfessores;
import GUIFinal.AdicionarSemestres;
import GUIFinal.Principal;
import Modelo.de.PL.Aula;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author aaratame
 */
public class SemestresListController implements IListController{
    
    private Principal _tela;
    private JList _listaPrincipal;
    private Aula _aula;
    private JFrame _telaAdicionarSemestres;

    public SemestresListController(Principal tela, JList listaPrincipal, Aula aula){
        _tela = tela;
        _listaPrincipal = listaPrincipal;
        _aula = aula;
        _telaAdicionarSemestres = criarTelaAdicionarSemestres();
    }
    
    private JFrame criarTelaAdicionarSemestres(){
        JFrame telaAdicionarSemestres =new JFrame ("Painel Professores");
        telaAdicionarSemestres.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        telaAdicionarSemestres.getContentPane().add (new AdicionarSemestres(_aula, _tela));
        telaAdicionarSemestres.pack();
        telaAdicionarSemestres.setVisible(false);
        return telaAdicionarSemestres;
    }
    
    @Override
    public void adicionar() {
        _telaAdicionarSemestres.setVisible(true);
    }

    @Override
    public void editar(Object escolhido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover() {
        _tela.removeElements(_aula.getSemestres());
    }

    @Override
    public void refresh() {
        _listaPrincipal.setListData(_aula.getSemestres().toArray());
    }
    
}
