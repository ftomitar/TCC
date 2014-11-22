/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIFinal.Professores;

import Modelo.de.PL.Aula;
import Modelo.de.PL.Horario;
import Modelo.de.PL.Professor;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alexandre
 */
public class EditarHorarios extends JFrame{
    private int _row = 3;
    private int _colum = 5;
    private List<JToggleButton> _buttons;
    private Aula _aula;
    
    private JPanel _painelBotoes;
    private JPanel _painelPrincipal;
    
    private JButton _botaoSalvar;
    private JButton _botaoCancelar;
    
    private Professor _professor;
    //TODO: verificar se é melhor mostrar as aulas na horizontal ou vertical.
    public EditarHorarios(Aula aula){
        _aula = aula;
        _row = aula.getQuadroLargura();
        _colum = aula.getQuadroAltura();
        _painelBotoes = gerarPainelHorarios();
        
        
        this.setTitle("Horários Disponíveis");
        
        
        _painelPrincipal = new JPanel();
        
        _painelPrincipal.setLayout(new BoxLayout(_painelPrincipal, BoxLayout.Y_AXIS));
        add(_painelPrincipal);
        
        
        _painelPrincipal.add(_painelBotoes);
        _botaoSalvar = new JButton("Salvar");
        _botaoCancelar = new JButton("Cancelar");
        //painelPrincipal.add(_botaoSalvar);
        //painelPrincipal.add(_botaoCancelar);
        //gerarActionListeners();
        
        this.setSize(1200, 400);
        
    }
    public void refreshBoardSize(){
        _row = _aula.getQuadroLargura();
        _colum = _aula.getQuadroAltura();
        
        _painelPrincipal.remove(_painelBotoes);
        _painelBotoes = gerarPainelHorarios();
        _painelPrincipal.add(_painelBotoes);
        
        System.out.println("refreshBoardSize");
        
    }
    
    public void setProfessor (Professor prof){
        _professor = prof;
    }
    
    private JPanel gerarPainelHorarios(){
        
        JPanel panel = new JPanel(new GridLayout(_row,_colum));
        _buttons = new ArrayList<JToggleButton>();
        JToggleButton jButton;
        Border border = LineBorder.createGrayLineBorder();
        
        
        int total = _row * _colum;
        for(int i = 0; i < total; i++){
            jButton = new JToggleButton();
            jButton.setBorder(border);
            jButton.setHorizontalAlignment( SwingConstants.CENTER );
            _buttons.add(jButton);
            panel.add(jButton);
        }
        
        
        return panel;
        
    }
    
    
    
    public Set getHorariosProfessor(){
        Set horariosAula = _aula.getHorarios();
        Set horariosDisponiveisProfessor = new HashSet();
        List <Boolean> status;
        List horarios = new ArrayList(horariosAula);
        Collections.sort(horarios);
        status = getPainelStatus(horarios);
        int i = 0;
        for(Boolean b: status){
            if(b.booleanValue()){
                horariosDisponiveisProfessor.add(horarios.get(i));
            }
            i++;
        }
        
        
        
        return horariosDisponiveisProfessor;
    }
    
    private List getPainelStatus(List<Horario> lista){
        List<Boolean> status = new ArrayList<>();
        JToggleButton jl = null;
        int col = 0;
        int linha = 0;
        int pos = 0;
        for(Horario h: lista){
            pos = (linha * _colum) + col;
            jl = _buttons.get(pos);
            //jl.setSelected(true);
            status.add(jl.isSelected());
            linha++;
            if(linha % _row == 0){
                linha = 0;
                col++;     
            }
        }
        
        
        return status;
    }
    
    public void organizarGUI(){
        List<Horario> lista = new ArrayList<>(_aula.getHorarios());
        Collections.sort(lista);
        Map<Horario,Boolean> horariosProf = obterMapaHorarios(lista);
        
        
        
        JToggleButton jl = null;
        
        boolean status;
        int col = 0;
        int linha = 0;
        int pos = 0;
        for(Horario h: lista){
            pos = (linha * _colum) + col;
            jl = _buttons.get(pos);
            status = horariosProf.get(h);
            jl.setSelected(status);
            
            linha++;
            if(linha % _row == 0){
                linha = 0;
                col++;     
            }
        }
        
        
    }
    
    private Map obterMapaHorarios(List<Horario> lista){
        Set<Horario> profHorarios = _professor.getPeriodoLivre();
        Map<Horario,Boolean> horarios = new HashMap();
        for(Horario h: lista){
            horarios.put(h, false);
        }
        for(Horario h: profHorarios){
            horarios.put(h, true);
        }
        
        
        return horarios;
    }
    
    private void _botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        System.out.println("salvar");
    }
    
    private void _botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        System.out.println("cancelar");
    }
     
     
    private void gerarActionListeners(){
        _botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               _botaoSalvarActionPerformed(evt);
           }
       });

        _botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               _botaoCancelarActionPerformed(evt);
           }
       });



    }

    public void resetarHorarios() {
        for(JToggleButton jtb: _buttons){
            jtb.setSelected(false);
        }
    }
}
