/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Strategy;

import AlgoritmoGenetico.AlgoritmoGenetico;
import AlgoritmoGenetico.QuadroHorarios;
import Modelo.de.PL.Aula;

/**
 *
 * @author Alexandre
 */
public class StrategyAlgoritmoGenetico implements IStrategy{
    
    AlgoritmoGenetico _ag;
    
    public StrategyAlgoritmoGenetico(Aula aula){
        _ag = new AlgoritmoGenetico(aula);
    }
    @Override
    public String obterSolucao() {
        QuadroHorarios qh = _ag.obterHorarios();
        return qh.obterHorarios();
    }
    
}
