/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Strategy;

import LPSolveComunication.FileManager;
import LPSolveComunication.LPSolveInterface;
import Modelo.de.PL.Aula;
import Modelo.de.PL.Cronograma;
import Modelo.de.PL.IModelOutput;
import Modelo.de.PL.TerminalOutput;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class StrategyProgramacaoLinear implements IStrategy{
    
    Aula _aula;
    LPSolveInterface _lpsolve;
    String path = "files" + File.separator + "model_LP.txt";
    
    public StrategyProgramacaoLinear(Aula aula){
        
        _aula = aula;
        
        
       
        File f = new File(path);
        boolean arquivoNaoExiste = !f.exists();
        if(arquivoNaoExiste){
            
            try {
                f.getParentFile().mkdirs();
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(StrategyProgramacaoLinear.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("ERRO DE IO: SEM PERMIÇÃO DE ESCRITA");
            }
        }
       
        
       
    }
    
    @Override
    public void carregarSolucao() {
        IModelOutput outputManager = new FileManager(path);
        //Cronograma teste = new Cronograma(_aula, new TerminalOutput());
        //teste.gerarModelo();
        Cronograma _crono = new Cronograma(_aula, outputManager);
        _crono.gerarModelo();
        _lpsolve = new LPSolveInterface(path);
    }
    
    @Override
    public String obterSolucao() {
        
        return _lpsolve.solveModel();
    }

    
    
}
