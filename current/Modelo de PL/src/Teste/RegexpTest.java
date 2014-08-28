/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Teste;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author aaratame
 */
public class RegexpTest {
    
    
    public static void main(String args[]){
        String teste =  "algumacoisa;1;1";
        //String modelo = "Variables;MILP Feasible;result\n ;15;15\nTerceiraWladmirEST;1;1\nSextaItaloOrientacaoObjetos;1;1\nTerceiraItaloEngenhariaDeSoftware;0;0\nDecimaTerSatoshiBancoDeDados;1;1";
        String modelo = "Variables;MILP Feasible;result\n;15;15\nSexta&Milton&Redes;0;0\nDecima1&Carlos&ESP;1;1\nDecima&Lisbete&EstruturaDeDados;0;0\nQuinta&Italo&EngenhariaDeSoftware;1;1";
        
        //Pattern pattern = Pattern.compile("([a-zA-Z0-9&]+);(1)");
        Pattern pattern = Pattern.compile("(\\w+&[a-zA-Z&]+);1");
        
        Matcher matcher = pattern.matcher(modelo);
        while (matcher.find()) {
           
            System.out.println(matcher.group(1));
        }
        
        
        /*
        
       
        
        //Pattern pattern = Pattern.compile("(w+);(1);(1)");
        
        String pattern = "([a-zA-Z]+;1;)\\d";
            
      
        String result = modelo.replaceAll(pattern, "$1");
        System.out.println(result);
        /*
        String [] lista = result.split("\n");


      
        List <String> gList = new ArrayList(Arrays.asList(lista));
        gList.subList(0, 2).clear();
        
        int cont = 0;
        
        for(String s : gList){
            cont ++;
            System.out.println(cont);
            System.out.println(s);
        }
        
        */
        
    }
}
