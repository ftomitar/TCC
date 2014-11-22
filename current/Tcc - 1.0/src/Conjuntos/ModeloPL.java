/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conjuntos;

import Modelo.de.PL.Aula;
import Modelo.de.PL.IModelOutput;

/**
 *
 * @author Alexandre
 */
public class ModeloPL implements IModelo{
    
    Aula aula;
    
    IModelOutput outputManager;
    
    public ModeloPL(Aula aula, IModelOutput outputmanager){
        this.aula = aula;
        this.outputManager = outputmanager;
    }
    
    @Override
    public void gerarModelo() {
        
    }
    
    
    
}
