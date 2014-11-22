package AlgoritmoGenetico;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jenetics.EnumGene;
import org.jenetics.GeneticAlgorithm;
import org.jenetics.Genotype;
import org.jenetics.NumberStatistics;
import org.jenetics.Optimize;
import org.jenetics.PartiallyMatchedCrossover;
import org.jenetics.PermutationChromosome;
import org.jenetics.SwapMutator;
import org.jenetics.util.Factory;
import org.jenetics.util.Function;
import Modelo.de.PL.Materia;

/**
 *
 * @author felipe
 */
public class AlgoritmoGenetico {

    private DTOUniversidade _dtoUniversidade;
    private QuadroHorarios _quadroHorarios;

    public AlgoritmoGenetico(Modelo.de.PL.Aula aula) {
        _dtoUniversidade = new DTOUniversidade(aula);

        Map<Integer, Materia> genes = inicializarGenes(_dtoUniversidade);
        alocarHorarios(genes);
    }

    public QuadroHorarios obterHorarios() {
        return _quadroHorarios;
    }

    private void alocarHorarios(Map<Integer, Materia> genes) {

        Function<Genotype<EnumGene<Integer>>, Integer> funcaoDeAvaliacao;
        Avaliador avaliador = new Avaliador(_dtoUniversidade, genes);
        funcaoDeAvaliacao = avaliador;
        Factory<Genotype<EnumGene<Integer>>> genotipo;
        genotipo = Genotype.of(PermutationChromosome.ofInteger(0, (genes.size())));

        GeneticAlgorithm<EnumGene<Integer>, Integer> algoritmoGenetico;
        algoritmoGenetico = new GeneticAlgorithm<>(genotipo, funcaoDeAvaliacao, Optimize.MINIMUM);

        algoritmoGenetico.setStatisticsCalculator(new NumberStatistics.Calculator<EnumGene<Integer>, Integer>());

        algoritmoGenetico.setPopulationSize(500);
        algoritmoGenetico.setAlterers(
                new SwapMutator<EnumGene<Integer>>(0.5),
                new PartiallyMatchedCrossover<Integer>(0.3)
        );

        algoritmoGenetico.setup();
        algoritmoGenetico.evolve(300);
        System.out.println(algoritmoGenetico.getBestStatistics());
        System.out.println(algoritmoGenetico.getBestPhenotype());
        
        _quadroHorarios = avaliador.obterQuadroHorarios();
    }

    @Deprecated
    public Map<Integer, Materia> inicializarGenes(DTOUniversidade universidade) {
        Map<Integer, Materia> genes = new HashMap<Integer, Materia>();
        Set<Materia> materias = universidade.obterMaterias();

        int i = 0;

        for (Materia materia : materias) {
            genes.put(i, materia);
            i++;
        }

        return genes;
    }

    public Map<Integer, Materia> inicializarGenes(Set<Materia> materias) {
        throw new RuntimeException("AlgoritmoGenetico.inicializarGenes não implementado");
    }

}
