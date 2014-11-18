/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal;

import GUI.ActionListener.ComboOpcoesActionListener;
import GUI.TelaQuadro;
import Modelo.de.PL.Aplication;
import Modelo.de.PL.Aula;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;
import Modelo.de.PL.Semestre;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Alexandre
 */
public class Principal extends javax.swing.JFrame {
    private GerarQuadro telaQuadro;
    private AdicionarProfessores addProf;
    private int _x = 3;
    private int _y = 5;
    Aula aula;
    private String _state = "Professores";
    
    private JFrame _quadroInicial;
    private JFrame _telaProfessores;
    /**
     * Creates new form Principal
     */
    public Principal() {
        aula = new Aula();
        mockGeracaoAulas();
        
        gerarTelasAdicionais();
        initComponents();
        inicializarListeners();
        telaQuadro.setVisible(true);
        
        
    }
    private void mockGeracaoAulas(){
        Aplication apl = new Aplication();
        apl.inicializarAulas(aula);
    }
    
    private void gerarTelasAdicionais(){
        telaQuadro = new GerarQuadro(this);
        addProf = new AdicionarProfessores(aula, this);
  
        
        
        _quadroInicial = new JFrame ("Tamanho do quadro");
        _quadroInicial.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        _quadroInicial.getContentPane().add (telaQuadro);
        _quadroInicial.pack();
        _quadroInicial.setVisible(false);
        
        _telaProfessores =new JFrame ("Painel Professores");
         _telaProfessores.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        _telaProfessores.getContentPane().add (addProf);
        _telaProfessores.pack();
        _telaProfessores.setVisible(false);
    }
    
    private void inicializarListeners(){
        comboOpcoes.addActionListener(new ComboOpcoesActionListener(this));
    }
    
    public void setBoardSize(int x, int y){
        _x = x;
        _y = y;
        _quadroInicial.setVisible(false);
       
    }
    
     public void comboSelectElement(String name) {
        System.out.println(name);
        switch (name) {
            case "Professores":
                _state = "Professores";
                listaPrincipal.setListData(aula.getProfessores().toArray());
                System.out.println("Professor");
                break;
            case "Materias":
                 _state = "Materias";
                listaPrincipal.setListData(aula.getMaterias().toArray());
                System.out.println("Materia");
                break;
            case "Semestres":
                _state = "Semestres";
                listaPrincipal.setListData(aula.getSemestres().toArray());
                System.out.println("Semestre");
                break;
        }
    }
     
    public void refresh() {
        switch (_state) {
            case "Professores":
                listaPrincipal.setListData(aula.getProfessores().toArray());
                break;
            case "Materias":
                listaPrincipal.setListData(aula.getMaterias().toArray()); 
                break;
            case "Semestres":
                listaPrincipal.setListData(aula.getSemestres().toArray());
                break;
        }
    }
    
    private void removeElementFrom(Set conjunto, Object ob ){
       
        if (ob instanceof Professor) {
            Professor escolhido =  (Professor)ob;
            System.out.println("escolhido: " + escolhido.getNome());
            conjunto.remove(escolhido);
        }
        else if(ob instanceof Materia){
            Materia escolhido =  (Materia)ob;
            conjunto.remove(escolhido);
            removerMateria(escolhido);
        }
        else if(ob instanceof Semestre){
            Semestre escolhido =  (Semestre)ob;
            conjunto.remove(escolhido);
        }
    }
    
    private void removerMateria(Materia mat){
        Set<Professor> professores = aula.getProfessores();
        Set<Semestre> semestres = aula.getSemestres();
        
        for(Professor p: professores){
            p.removeMateria(mat);
        }
        for(Semestre s: semestres){
            s.removeMateria(mat);
        }
    }
    
    private void removeElements(Set conjunto){
        List elements = listaPrincipal.getSelectedValuesList();
        
        for (Object ob: elements){
            removeElementFrom(conjunto, ob);
        }
        
        refresh();
        System.out.println("conjunto: " + conjunto);
        System.out.println("conjunto tamanho: " + conjunto.size());
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoNovoQuadro = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboOpcoes = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPrincipal = new javax.swing.JList(aula.getProfessores().toArray());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoNovoQuadro.setText("Novo Quadro");
        botaoNovoQuadro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoQuadroActionPerformed(evt);
            }
        });

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Opções");

        comboOpcoes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboOpcoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professores", "Materias", "Semestres" }));
        comboOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOpcoesActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(comboOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botaoAdicionar)
                            .addGap(41, 41, 41)
                            .addComponent(botaoEditar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botaoNovoQuadro)
                            .addGap(18, 18, 18)
                            .addComponent(botaoRemover))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoNovoQuadro)
                            .addComponent(botaoRemover))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoAdicionar)
                            .addComponent(botaoEditar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoQuadroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoQuadroActionPerformed
       _quadroInicial.setVisible(true);
       
        System.out.println("gerar novo quadro");
    }//GEN-LAST:event_botaoNovoQuadroActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        switch (_state) {
            case "Professores":
                _telaProfessores.setVisible(true);
                break;
            case "Materias":
                System.out.println("Materia");
                break;
            case "Semestres":
                System.out.println("Semestre");
                break;
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        //TODO: funcao de remoção
        switch (_state) {
            case "Professores":
                removeElements(aula.getProfessores());
                break;
            case "Materias":
                removeElements(aula.getMaterias());
                System.out.println("Materia");
                break;
            case "Semestres":
                removeElements(aula.getSemestres());
                break;
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void comboOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOpcoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOpcoesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoNovoQuadro;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JComboBox comboOpcoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaPrincipal;
    // End of variables declaration//GEN-END:variables

    


}
