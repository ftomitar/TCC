/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.Materias;

import GUIFinal.ActionListener.ComboOpcoesActionListener;
import GUIFinal.Materias.ControllerAndListener.ComboOptionActionListener;
import GUIFinal.Materias.ControllerAndListener.ITelaMateria;
import GUIFinal.Materias.ControllerAndListener.ITelaMateriasListController;
import GUIFinal.Materias.ControllerAndListener.MateriaProfessoresListController;
import GUIFinal.Materias.ControllerAndListener.MateriaSemestreListController;
import GUIFinal.Principal;
import Modelo.de.PL.Aula;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;
import Modelo.de.PL.Semestre;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Alexandre
 */
public class EditarMaterias extends javax.swing.JPanel implements ITelaMateria{
    private Aula _aula;
    private List _listTodosProfessores;
    private List _listTodosSemestres;
    private Vector _professoresDisponiveis;
    private Vector _professoresUtilizados;
    private Vector _semestresDisponiveis;
    private Vector _semestresUtilizados;
    private Vector _elementosDisponiveis;
    private Vector _elementosUtilizados;
    
    ITelaMateriasListController listController;
    MateriaProfessoresListController professoresListController;
    MateriaSemestreListController semestreListController;
    
    Materia _materia;
    private final Principal _tela;
    /**
     * Creates new form EditarMaterias
     * @param aula
     * @param tela
     */
    public EditarMaterias(Aula aula, Principal tela) {
        initComponents();
        
        _aula = aula;
        _listTodosProfessores = new ArrayList(_aula.getProfessores());
        Collections.sort(_listTodosProfessores);
        _listTodosSemestres = new ArrayList(_aula.getSemestres());
        Collections.sort(_listTodosSemestres);        
        iniciarListas();
        inicializarListControllers();
        inicializarListeners();
        _tela = tela;
    }
    
    private void inicializarListeners(){
        comboOpcoes.addActionListener(new ComboOptionActionListener(this));
    }
    
    private void inicializarListControllers(){
        professoresListController = new MateriaProfessoresListController(_aula, listElementosDisponiveis, listElementosUtilizados,
                _professoresDisponiveis, _professoresUtilizados, _semestresDisponiveis, _semestresUtilizados);
        semestreListController = new MateriaSemestreListController(_aula, listElementosDisponiveis, listElementosUtilizados,
                _professoresDisponiveis, _professoresUtilizados, _semestresDisponiveis, _semestresUtilizados);
        listController = professoresListController;
    }
    
    private void iniciarListas(){
        
        _professoresDisponiveis = new Vector(_listTodosProfessores);
        _professoresUtilizados = new Vector();
        _semestresDisponiveis = new Vector(_listTodosSemestres);
        _semestresUtilizados = new Vector();
        
        _elementosDisponiveis = _professoresDisponiveis;
        _elementosUtilizados = _professoresUtilizados;
        listElementosDisponiveis.setListData(_professoresDisponiveis);
        listElementosUtilizados.setListData(_professoresUtilizados);
        listElementosDisponiveis.setSelectionInterval(0, 0);
        listElementosUtilizados.setSelectionInterval(0, 0);
    }
    
  
    
    @Override
    public void comboSelectElement(String name) {
        switch (name) {
            case "Professores":
                listController = professoresListController;
                _elementosDisponiveis = _professoresDisponiveis;
                _elementosUtilizados = _professoresUtilizados;
                
                break;
            case "Semestres":
                listController = semestreListController;
                _elementosDisponiveis = _semestresDisponiveis;
                _elementosUtilizados = _semestresUtilizados;
                break;
        }
        labelElementosDisponiveis.setText(name + " Disponiveis");
        labelElementosUtilizados.setText(name + " Utilizados");
        listController.refresh();
    }
    
    public void materiaEscolhida(Materia materia) {
        _materia = materia;
    }
    
    public void organizarGUI() {
        String nome = _materia.getNome();
        int quantidade = _materia.numeroAulas();
        textFieldNome.setText(nome);
        textFieldQuantidade.setText(quantidade + "");
        carregarListas();
        
    }
    
    private void carregarListas(){
        Set<Professor> professoresUtilizados = procurarProfessores();
        Set<Semestre> semestresUtilizados = procurarSemestres();
        Set<Professor> professoresDisponiveis = new HashSet(_aula.getProfessores());
        Set<Semestre> semestresDisponiveis = new HashSet(_aula.getSemestres());
        _professoresUtilizados.clear();
        _professoresUtilizados.addAll(professoresUtilizados);
        _semestresUtilizados.clear();
        _semestresUtilizados.addAll(semestresUtilizados);
        professoresDisponiveis.removeAll(_professoresUtilizados);
        _professoresDisponiveis.clear();
        _professoresDisponiveis.addAll(professoresDisponiveis);
        semestresDisponiveis.removeAll(_semestresUtilizados);
        _semestresDisponiveis.clear();
        _semestresDisponiveis.addAll(semestresDisponiveis);
        comboOpcoes.setSelectedItem("Professores");
    }
    
    private Set procurarProfessores(){
        Set<Professor> professores = new HashSet();
        Set<Professor> professoresDisponiveis = _aula.getProfessores();
        
        for(Professor p: professoresDisponiveis){
            if(p.lecionaMateria(_materia)){
                professores.add(p);
            }
        }
        
        return professores;
    }
    
    private Set procurarSemestres(){
        Set<Semestre> semestres = new HashSet();
        Set<Semestre> semestresDisponiveis = _aula.getSemestres();
        
        for(Semestre s: semestresDisponiveis){
            if(s.materiaLecionada(_materia)){
                semestres.add(s);
            }
        }
        
        return semestres;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        botaoAdicionar = new javax.swing.JButton();
        botaoResetMaterias = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listElementosDisponiveis = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listElementosUtilizados = new javax.swing.JList();
        botaoRemoverElemento = new javax.swing.JButton();
        botaoAdicionarElemento = new javax.swing.JButton();
        labelElementosDisponiveis = new javax.swing.JLabel();
        labelElementosUtilizados = new javax.swing.JLabel();
        comboOpcoes = new javax.swing.JComboBox();
        labelQuantidade = new javax.swing.JLabel();
        textFieldQuantidade = new javax.swing.JTextField();

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNome.setText("Nome: ");

        textFieldNome.setColumns(10);
        textFieldNome.setText("Nome Materia");

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoResetMaterias.setText("Resetar materias");
        botaoResetMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoResetMateriasActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listElementosDisponiveis);

        jScrollPane2.setViewportView(listElementosUtilizados);

        botaoRemoverElemento.setText("->");
        botaoRemoverElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverElementoActionPerformed(evt);
            }
        });

        botaoAdicionarElemento.setText("<-");
        botaoAdicionarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarElementoActionPerformed(evt);
            }
        });

        labelElementosDisponiveis.setText("Professores Disponiveis");

        labelElementosUtilizados.setText("Professores Utilizados");

        comboOpcoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professores", "Semestres" }));
        comboOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOpcoesActionPerformed(evt);
            }
        });

        labelQuantidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelQuantidade.setText("Quantidade de Aulas: ");

        textFieldQuantidade.setColumns(3);
        textFieldQuantidade.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelElementosUtilizados)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoRemoverElemento)
                                    .addComponent(botaoAdicionarElemento))))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelElementosDisponiveis)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botaoResetMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboOpcoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuantidade)
                    .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelElementosDisponiveis)
                            .addComponent(labelElementosUtilizados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoAdicionar)
                                .addGap(31, 31, 31)
                                .addComponent(botaoResetMaterias)
                                .addGap(41, 41, 41)
                                .addComponent(comboOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(botaoRemoverElemento)
                        .addGap(27, 27, 27)
                        .addComponent(botaoAdicionarElemento)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        
        _materia = listController.recriarMateria(_materia);
        
        _tela.refresh();
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoAdicionarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarElementoActionPerformed
        listController.trocarElementos(listElementosDisponiveis, _elementosDisponiveis, _elementosUtilizados);
        
    }//GEN-LAST:event_botaoAdicionarElementoActionPerformed

    private void botaoRemoverElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverElementoActionPerformed
        listController.trocarElementos(listElementosUtilizados,_elementosUtilizados,_elementosDisponiveis);
    }//GEN-LAST:event_botaoRemoverElementoActionPerformed

    private void botaoResetMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoResetMateriasActionPerformed
        listController.resetarElementos();
    }//GEN-LAST:event_botaoResetMateriasActionPerformed

    private void comboOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOpcoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOpcoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAdicionarElemento;
    private javax.swing.JButton botaoRemoverElemento;
    private javax.swing.JButton botaoResetMaterias;
    private javax.swing.JComboBox comboOpcoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelElementosDisponiveis;
    private javax.swing.JLabel labelElementosUtilizados;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JList listElementosDisponiveis;
    private javax.swing.JList listElementosUtilizados;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldQuantidade;
    // End of variables declaration//GEN-END:variables

    


}
