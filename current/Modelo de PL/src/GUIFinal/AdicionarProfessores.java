/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal;

import Modelo.de.PL.Aula;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Alexandre
 */
public class AdicionarProfessores extends javax.swing.JPanel {
    Aula _aula;
    List _listTodasMaterias;
    Vector <Materia>_materiasDisponiveis;
    Vector <Materia>_materiasLecionadas;
    private final Principal _tela;
    /**
     * Creates new form AdicionarProfessores
     * @param aula
     * @param tela
     */
    public AdicionarProfessores(Aula aula, Principal tela) {
        initComponents();
        _aula = aula;
        _listTodasMaterias = new ArrayList(_aula.getMaterias());
        Collections.sort(_listTodasMaterias);
        iniciarListas();
        _tela = tela;
    }
    
    private void iniciarListas(){
        
        _materiasDisponiveis = new Vector(_listTodasMaterias);
        _materiasLecionadas = new Vector();
        listMateriasDisponiveis.setListData(_materiasDisponiveis);
        listMateriasLecionadas.setListData(_materiasLecionadas);
        listMateriasDisponiveis.setSelectionInterval(0, 0);
        listMateriasLecionadas.setSelectionInterval(0, 0);
    }
    
    private void atualizarListas(){
        Collections.sort((List)_materiasDisponiveis);
        Collections.sort((List)_materiasLecionadas);
        listMateriasDisponiveis.setListData(_materiasDisponiveis);
        listMateriasLecionadas.setListData(_materiasLecionadas);
        if(listMateriasDisponiveis.getSize().height > 0){
             listMateriasDisponiveis.setSelectionInterval(0, 0);
        }
        if(listMateriasLecionadas.getSize().height > 0){
             listMateriasLecionadas.setSelectionInterval(0, 0);
        }
    }
  
    
    private void trocarMaterias(JList lista, Vector <Materia> origem, Vector <Materia> destino){
        int[] indexes = lista.getSelectedIndices();
        List<Materia> auxiliar = new ArrayList<>();
        if(!origem.isEmpty()){
            for(int i = 0; i < indexes.length; i++){
                Materia m = origem.get(indexes[i]);
                destino.add(m);
                auxiliar.add(m);
            }
            for(Materia mat: auxiliar){
                origem.remove(mat);
            }
            atualizarListas();
        }
        
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
        botaoEditHorarios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMateriasDisponiveis = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMateriasLecionadas = new javax.swing.JList();
        botaoRemoverMateria = new javax.swing.JButton();
        botaoAdicionarMateria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNome.setText("Nome: ");

        textFieldNome.setColumns(10);
        textFieldNome.setText("Nome Professor");

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

        botaoEditHorarios.setText("Editar Horario Livre");

        jScrollPane1.setViewportView(listMateriasDisponiveis);

        jScrollPane2.setViewportView(listMateriasLecionadas);

        botaoRemoverMateria.setText("->");
        botaoRemoverMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverMateriaActionPerformed(evt);
            }
        });

        botaoAdicionarMateria.setText("<-");
        botaoAdicionarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarMateriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Materias Disponiveis");

        jLabel3.setText("Materias Lecionadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoRemoverMateria)
                                    .addComponent(botaoAdicionarMateria))))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botaoEditHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botaoResetMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(botaoRemoverMateria)
                        .addGap(27, 27, 27)
                        .addComponent(botaoAdicionarMateria))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoAdicionar)
                                .addGap(31, 31, 31)
                                .addComponent(botaoResetMaterias)
                                .addGap(33, 33, 33)
                                .addComponent(botaoEditHorarios))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        String nome = textFieldNome.getText();
        System.out.println("nome: " + nome);
        String nomeSemEspaco = nome.replaceAll("\\s+","");
        Professor prof = new Professor(nomeSemEspaco);
        Set professores = _aula.getProfessores();
        professores.add(prof);
        _tela.refresh();
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoAdicionarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarMateriaActionPerformed
        trocarMaterias(listMateriasDisponiveis,_materiasDisponiveis,_materiasLecionadas);
        
    }//GEN-LAST:event_botaoAdicionarMateriaActionPerformed

    private void botaoRemoverMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverMateriaActionPerformed
        trocarMaterias(listMateriasLecionadas,_materiasLecionadas,_materiasDisponiveis);
    }//GEN-LAST:event_botaoRemoverMateriaActionPerformed

    private void botaoResetMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoResetMateriasActionPerformed
        iniciarListas();
    }//GEN-LAST:event_botaoResetMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAdicionarMateria;
    private javax.swing.JButton botaoEditHorarios;
    private javax.swing.JButton botaoRemoverMateria;
    private javax.swing.JButton botaoResetMaterias;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JList listMateriasDisponiveis;
    private javax.swing.JList listMateriasLecionadas;
    private javax.swing.JTextField textFieldNome;
    // End of variables declaration//GEN-END:variables
}
