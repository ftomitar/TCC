package AlgoritmoGenetico;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import Modelo.de.PL.Horario;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;

/**
 *
 * @author felipe
 */
public class HorarioSemestre {

    private String _semestre = "";
    private Map<Horario, Disponibilidade> _disponibilidade;
    private Map<Horario, Aula> _horarioSemestre;

    public HorarioSemestre(String semestre, Set<Horario> horarios) {
        _semestre = semestre;
        _horarioSemestre = new HashMap<Horario, Aula>();
        _disponibilidade = new HashMap<Horario, Disponibilidade>();
        inicializarHorario(horarios);
    }

    public void inicializarHorario(Set<Horario> horarios) {
        for (Horario h : horarios) {
            _horarioSemestre.put(h, null);
            _disponibilidade.put(h, new Disponibilidade(Alocacao.DISPONIVEL));
        }
    }

    public void marcarAula(Horario horario, Materia materia, Professor professor) {
        Disponibilidade d = _disponibilidade.get(horario);
        _horarioSemestre.put(horario, new Aula(materia, professor));
        d.defineEstadoAlocacao(Alocacao.INDISPONIVEL);

    }

    public boolean horarioDisponivel(Horario horario) {
        boolean disponivel = false;

        if (_disponibilidade.get(horario).obterEstadoAlocacao() == Alocacao.DISPONIVEL) {
            disponivel = true;
        }
        return disponivel;
    }

    public Horario obterProximoHorarioDisponivel() {
        Set<Horario> horarios = _horarioSemestre.keySet();
        Horario horarioDisponivel = null;

        for (Horario h : horarios) {

            if (_disponibilidade.get(h).obterEstadoAlocacao() == Alocacao.DISPONIVEL) {
                horarioDisponivel = h;
                break;
            }
        }

        return horarioDisponivel;
    }

    public boolean jaEMinistradoPorEsteProfessor(Professor professorCandidato, Horario horario) {
        boolean alocado;

        if (_disponibilidade.get(horario).obterEstadoAlocacao() == Alocacao.DISPONIVEL) {
            alocado = false;

        } else {
            Professor professorAlocado;
            professorAlocado = _horarioSemestre.get(horario).getProfessor();
            alocado = (professorAlocado == professorCandidato);
        }

        return alocado;
    }

    public String obterHorarioSemestre() {
        Set<Horario> horarios = _horarioSemestre.keySet();
        Aula aula;
        String dados = "";

        for (Horario h : horarios) {

            aula = _horarioSemestre.get(h);

            if (aula != null) {
                dados = dados + "\n" + _semestre + "&"
                        + h.getNome() + "&"
                        + aula.getProfessor().getNome() + "&"
                        + aula.getMateria().getNome() + ";1;1";
            }
        }
        return dados;
    }
}
