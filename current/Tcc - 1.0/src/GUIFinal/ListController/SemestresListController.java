/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.ListController;

import GUIFinal.Semestres.AdicionarSemestres;
import GUIFinal.Semestres.EditarSemestres;
import GUIFinal.Principal;
import Modelo.de.PL.Aula;
import Modelo.de.PL.Semestre;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author aaratame
 */
public class SemestresListController implements IListController{
    
    private Principal _tela;
    private JList _listaPrincipal;
    private Aula _aula;
    private JFrame _telaAdicionarSemestres;
    private JFrame _telaEditarSemestres;
    private EditarSemestres _painelEditar;

    public SemestresListController(Principal tela, JList listaPrincipal, Aula aula){
        _tela = tela;
        _listaPrincipal = listaPrincipal;
        _aula = aula;
        _telaAdicionarSemestres = criarTela(new AdicionarSemestres(_aula, _tela));
        _painelEditar = new EditarSemestres(aula, tela);
        _telaEditarSemestres = criarTela(_painelEditar);
        
    }
    public JFrame criarTela(JPanel painel){
        
        JFrame tela = new JFrame ("Painel Semestres");
        tela.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        tela.getContentPane().add (painel);
        tela.pack();
        tela.setVisible(false);
        return tela;
    }
    
    
    @Override
    public void adicionar() {
        _telaAdicionarSemestres.setVisible(true);
    }

    @Override
    public void editar(Object escolhido) {
        if(escolhido != null){
            _painelEditar.semestreEscolhido((Semestre)escolhido);
            _painelEditar.organizarGUI();
            _telaEditarSemestres.setVisible(true);
        }
        else{
            System.out.println("seleção vazia");
        }
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
