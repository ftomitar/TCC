/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.Materias.ControllerAndListener;

import Modelo.de.PL.Aula;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;
import Modelo.de.PL.Semestre;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.JList;

/**
 *
 * @author Alexandre
 */
public class MateriaProfessoresListController implements ITelaMateriasListController{
    Aula _aula;
    JList _listProfessoresDisponiveis;
    JList _listProfessoresUtilizados;
    Vector <Professor>_professoresDisponiveis;
    Vector <Professor>_professoresUtilizados;
    Vector <Semestre>_semestresDisponiveis;
    Vector <Semestre>_semestresUtilizados;
    

    public MateriaProfessoresListController(Aula aula, JList listProfessoresDisponiveis, JList listProfessoresUtilizados, 
            Vector professoresDisponiveis, Vector professoresUtilizados, Vector semestresDisponiveis, Vector semsetresUtilizados) {
         _aula = aula;
        _listProfessoresDisponiveis = listProfessoresDisponiveis;
        _listProfessoresUtilizados = listProfessoresUtilizados;
        _professoresDisponiveis = professoresDisponiveis;
        _professoresUtilizados = professoresUtilizados;
        _semestresDisponiveis = semestresDisponiveis;
        _semestresUtilizados = semsetresUtilizados;
    }
    
    @Override
    public void criarElemento(String nome, int quantidade) {
        Materia mat = new Materia(nome, quantidade);
        carregarDados(mat);
        _aula.addMateria(mat);
        
    }
    
    private void carregarDados(Materia mat){
        
        for(Professor p: _professoresUtilizados){
            p.addMateria(mat);
        }
        
        for(Semestre s: _semestresUtilizados){
            s.addMateria(mat);
        }
    }
    
    @Override
    public void recriarElemento(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public void atualizarListas(){
        Collections.sort((List)_professoresDisponiveis);
        Collections.sort((List)_professoresUtilizados);
        _listProfessoresDisponiveis.setListData(_professoresDisponiveis);
        _listProfessoresUtilizados.setListData(_professoresUtilizados);
        if(_listProfessoresDisponiveis.getLastVisibleIndex()!= -1){
             _listProfessoresDisponiveis.setSelectionInterval(0, 0);
        }
        if(_listProfessoresUtilizados.getLastVisibleIndex()!= -1){
             _listProfessoresUtilizados.setSelectionInterval(0, 0);
        }
    }

    @Override
    public void trocarElementos(JList lista, Vector origem, Vector destino) {
        if(existeElementosSelecionados(lista)){
            List<Professor> itens = lista.getSelectedValuesList();
            for(Professor m: itens){
                origem.remove(m);
                destino.add(m);
            }   
            atualizarListas();
        }
    }
    
    private boolean existeElementosSelecionados(JList lista){
        return lista.getLastVisibleIndex() != -1;
    }

    @Override
    public void resetarElementos() {
        _professoresDisponiveis.clear();
        _professoresDisponiveis.addAll(_aula.getProfessores());
        Collections.sort((List)_professoresDisponiveis);
        _professoresUtilizados.clear();
        refresh();
    }

    @Override
    public void refresh() {
        _listProfessoresDisponiveis.setListData(_professoresDisponiveis);
        _listProfessoresUtilizados.setListData(_professoresUtilizados);
        _listProfessoresDisponiveis.setSelectionInterval(0, 0);
        _listProfessoresUtilizados.setSelectionInterval(0, 0);
    }
    
    public void organizarGUI(){
        
    }

   
    
    
}
