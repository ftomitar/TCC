/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.ListController;

import GUIFinal.Professores.AdicionarProfessores;
import GUIFinal.Professores.EditarProfessores;
import GUIFinal.Principal;
import Modelo.de.PL.Aula;
import Modelo.de.PL.Professor;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author aaratame
 */
public final class ProfessoresListController implements IListController{
    
    private Principal _tela;
    private JList _listaPrincipal;
    private Aula _aula;
    private JFrame _telaAdicionarProfessores;
    private JFrame _telaEditarProfessores;
    
    private EditarProfessores _painelEditar;

    public ProfessoresListController(Principal tela,JList listaPrincipal, Aula aula){
        _tela = tela;
        _listaPrincipal = listaPrincipal;
        _aula = aula;
        _telaAdicionarProfessores = criarTela(new AdicionarProfessores(aula, tela));
        _painelEditar = new EditarProfessores(aula, tela);
        _telaEditarProfessores = criarTela(_painelEditar);
    }
    
    public JFrame criarTela(JPanel painel){
        
        JFrame tela = new JFrame ("Painel Professores");
        tela.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        tela.getContentPane().add (painel);
        tela.pack();
        tela.setVisible(false);
        return tela;
    }
    
    @Override
    public void adicionar() {
        _telaAdicionarProfessores.setVisible(true);
    }

    @Override
    public void editar(Object escolhido) {
        if(escolhido != null){
            _painelEditar.professorEscolhido((Professor)escolhido);
            _painelEditar.organizarGUI();
            _telaEditarProfessores.setVisible(true);
        }
        else{
            System.out.println("seleção vazia");
        }
        
    }

    @Override
    public void remover() {
        _tela.removeElements(_aula.getProfessores());
    }

    @Override
    public void refresh() {
        _listaPrincipal.setListData(_aula.getProfessores().toArray());
    }
    
}
