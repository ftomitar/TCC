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

public class MateriaSemestreListController implements ITelaMateriasListController{
    Aula _aula;
    JList _listSemestresDisponiveis;
    JList _listSemestresUtilizados;
    Vector <Professor>_professoresDisponiveis;
    Vector <Professor>_professoresUtilizados;
    Vector <Semestre>_semestresDisponiveis;
    Vector <Semestre>_semestresUtilizados;
    

    public MateriaSemestreListController(Aula aula, JList listSemestresDisponiveis, JList listSemestresUtilizados, 
            Vector professoresDisponiveis, Vector professoresUtilizados, Vector semestresDisponiveis, Vector semsetresUtilizados) {
         _aula = aula;
        _listSemestresDisponiveis = listSemestresDisponiveis;
        _listSemestresUtilizados = listSemestresUtilizados;
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
        Collections.sort((List)_semestresDisponiveis);
        Collections.sort((List)_semestresUtilizados);
        _listSemestresDisponiveis.setListData(_semestresDisponiveis);
        _listSemestresUtilizados.setListData(_semestresUtilizados);
        if(_listSemestresDisponiveis.getLastVisibleIndex()!= -1){
             _listSemestresDisponiveis.setSelectionInterval(0, 0);
        }
        if(_listSemestresUtilizados.getLastVisibleIndex()!= -1){
             _listSemestresUtilizados.setSelectionInterval(0, 0);
        }
    }

    @Override
    public void trocarElementos(JList lista, Vector origem, Vector destino) {
        if(existeElementosSelecionados(lista)){
            List<Semestre> itens = lista.getSelectedValuesList();
            for(Semestre s: itens){
                origem.remove(s);
                destino.add(s);
            }   
            atualizarListas();
        }
    }
    
    private boolean existeElementosSelecionados(JList lista){
        return lista.getLastVisibleIndex() != -1;
    }

    @Override
    public void resetarElementos() {
        _semestresDisponiveis.clear();
        _semestresDisponiveis.addAll(_aula.getSemestres());
        Collections.sort((List)_semestresDisponiveis);
        _semestresUtilizados.clear();
        refresh();
    }

    @Override
    public void refresh() {
        _listSemestresDisponiveis.setListData(_semestresDisponiveis);
        _listSemestresUtilizados.setListData(_semestresUtilizados);
        _listSemestresDisponiveis.setSelectionInterval(0, 0);
        _listSemestresUtilizados.setSelectionInterval(0, 0);
    }

    

   
    
    
}