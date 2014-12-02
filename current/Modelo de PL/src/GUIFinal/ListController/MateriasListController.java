/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.ListController;

import GUIFinal.Materias.AdicionarMaterias;
import GUIFinal.Materias.EditarMaterias;
import GUIFinal.Principal;
import Modelo.de.PL.Aula;
import Modelo.de.PL.Materia;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author aaratame
 */
public class MateriasListController implements IListController{
    
    private Principal _tela;
    private JList _listaPrincipal;
    private Aula _aula;
    private JFrame _telaAdicionarMaterias;
    private JFrame _telaEditarMaterias;
    private AdicionarMaterias _painelAdicionar;
    private EditarMaterias _painelEditar;

    public MateriasListController(Principal tela, JList listaPrincipal, Aula aula){
        _tela = tela;
        _listaPrincipal = listaPrincipal;
        _aula = aula;
        _painelAdicionar = new AdicionarMaterias(aula, tela);
        _telaAdicionarMaterias = criarTela(_painelAdicionar);
        _painelEditar = new EditarMaterias(aula, tela);
        _telaEditarMaterias = criarTela(_painelEditar);
        
    }
    
     public JFrame criarTela(JPanel painel){
        
        JFrame tela = new JFrame ("Painel Matérias");
        tela.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        tela.getContentPane().add (painel);
        tela.pack();
        tela.setVisible(false);
        return tela;
    }

    
    @Override
    public void adicionar() {
        _painelAdicionar.iniciarListas();
        _telaAdicionarMaterias.setVisible(true);
    }

    @Override
    public void editar(Object escolhido) {
        if(escolhido != null){
            _painelEditar.materiaEscolhida((Materia)escolhido);
            _painelEditar.organizarGUI();
            _telaEditarMaterias.setVisible(true);
        }
        else{
            System.out.println("seleção vazia");
        }
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
