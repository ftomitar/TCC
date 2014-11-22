/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LPSolveComunication;

import java.util.ArrayList;
import java.util.List;
import lpsolve.*;

/**
 *
 * @author alexandre
 */
public class LPSolveInterface {
    String file;
    LpSolve _solver;
    public LPSolveInterface(String file){
        this.file = file;
        try{
            _solver = LpSolve.readXLI("xli_lindo", file, null, null, 6);
            _solver.setOutputfile("");
        }
       catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String solveModel(){
        String solution = "";
        try{
            
            
           
            //solver.setOutputfile("C:\\Users\\alexandre\\Downloads\\lp_solve_5.5.2.0_exe_win32\\solution.txt");
           
            //solver.writeXLI("C:\\Users\\alexandre\\Downloads\\lp_solve_5.5.2.0_exe_win32\\solution.txt", null, false
            _solver.solve();
            
            
            double [] lista = _solver.getPtrVariables();
            List <String> nomes = new ArrayList<>();
            for(int k = 1; k<lista.length +1; k++){
                nomes.add(_solver.getColName(k));
            }
            for (int i = 0; i< lista.length; i++){
                double valor = lista[i];
                String data = nomes.get(i) + ";" + valor +"\n";
                solution = solution + data;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return solution;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            LpSolve solver;
            solver = LpSolve.readXLI("xli_lindo", "C:\\Users\\alexandre\\Downloads\\lp_solve_5.5.2.0_exe_win32\\teste.txt", null, null, 6);
            //solver.setOutputfile("C:\\Users\\alexandre\\Downloads\\lp_solve_5.5.2.0_exe_win32\\solution.txt");
            solver.setOutputfile("");
            //solver.writeXLI("C:\\Users\\alexandre\\Downloads\\lp_solve_5.5.2.0_exe_win32\\solution.txt", null, false
            solver.solve();
            
            
            double [] lista = solver.getPtrVariables();
            List <String> nomes = new ArrayList<>();
            
            
            for(int k = 1; k<lista.length +1; k++){
                nomes.add(solver.getColName(k));
            }
            for (int i = 0; i< lista.length; i++){
                double valor = lista[i];
                System.out.println(nomes.get(i) + ";" + valor);
            }
            System.out.println(lista.length);
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
}
