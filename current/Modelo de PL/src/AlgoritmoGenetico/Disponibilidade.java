package AlgoritmoGenetico;

/**
 *
 * @author felipe
 */
public class Disponibilidade {

    Alocacao _alocacao;

    public Disponibilidade(Alocacao alocacao) {
        _alocacao = alocacao;
    }

    public void defineEstadoAlocacao(Alocacao alocacao) {
        _alocacao = alocacao;
    }

    public Alocacao obterEstadoAlocacao() {
        return _alocacao;
    }
}
