package AlgoritmoGenetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jenetics.EnumGene;
import org.jenetics.Genotype;
import org.jenetics.util.Function;
import Modelo.de.PL.Materia;



public class Avaliador implements Function<Genotype<EnumGene<Integer>>, Integer> {
    private DTOUniversidade _dados;
    private Map<Integer, Materia> _materias;
    private int _valorPenalidade = Integer.MAX_VALUE;
    private int _quantidadeAulasAlocadas = 0;
    private QuadroHorarios _quadroHorarios;
    

    public Avaliador(DTOUniversidade dados, Map<Integer, Materia> materias) {
        _dados = dados;
        _materias = materias;
    }


    @Override
    public Integer apply(Genotype<EnumGene<Integer>> value) {
        List<EnumGene<Integer>> chromossomo = value.getChromosome().toSeq().asList();
        List<Materia> chromossomoDecodificado = decodificarChromossomo(chromossomo);
        QuadroHorarios quadroHorarios = new QuadroHorarios(_dados);
        
        for(Materia materia : chromossomoDecodificado){
            quadroHorarios.alocar(materia);
        }
        
        if(quadroHorarios.obterValorPenalidade() < _valorPenalidade && quadroHorarios.obterQuantidadeDeAulasAlocadas() > _quantidadeAulasAlocadas ){
            _quadroHorarios = quadroHorarios;
            _quantidadeAulasAlocadas = quadroHorarios.obterQuantidadeDeAulasAlocadas();
        }
        

        return quadroHorarios.obterValorPenalidade();
    }
    
    private List<Materia> decodificarChromossomo(List<EnumGene<Integer>> chromossomo){
        List<Materia> chromossomoDecodificado = new ArrayList<Materia>();
        
        for(EnumGene<Integer> gene : chromossomo){
            chromossomoDecodificado.add(_materias.get(gene.getAllele()));
        }
        
        return chromossomoDecodificado;
    }
    
    public QuadroHorarios obterQuadroHorarios(){
        return _quadroHorarios;
    }


}
