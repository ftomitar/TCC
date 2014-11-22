package AlgoritmoGenetico;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import Modelo.de.PL.Horario;
import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;
import Modelo.de.PL.Semestre;

/**
 *
 * @author felipe
 */
public class QuadroHorarios {

    private Map<Semestre, HorarioSemestre> _quadroHorarios;
    private Set<Semestre> _semestres;

    private int penalidadeColisao = 0;
    private int penalidadeNaoAlocado = 0;

    private DTOUniversidade _dados;
    private int qtdAulasAlocada = 0;
    
    public QuadroHorarios(Set<Semestre> semestres, Set<Horario> horarios) {
        _quadroHorarios = new HashMap<Semestre, HorarioSemestre>();
        definirBlackboard(semestres, horarios);
    }

    @Deprecated
    public QuadroHorarios(DTOUniversidade dados) {
        _dados = dados;
        _semestres = dados.obterSemestres();
        _quadroHorarios = new HashMap<Semestre, HorarioSemestre>();
        definirBlackboard(dados.obterSemestres(), dados.obterHorarios());
    }

    private void definirBlackboard(Set<Semestre> semestres, Set<Horario> horarios) {
        for (Semestre semestre : semestres) {
            _quadroHorarios.put(semestre, new HorarioSemestre(semestre.getNome(), horarios));
        }

    }

    public void alocar(Materia materia) {

        String semestreMateriaLecionada = materia.getSemestre();
        Semestre semestre = _dados.obterSemestre(semestreMateriaLecionada);
        Professor professor = _dados.obterProfessor(materia);

        HorarioSemestre horarioSemestre = _quadroHorarios.get(semestre);
        Set<Horario> horarioProfessorLivre = professor.getPeriodoLivre();
        Horario horarioDisponivel;

        int quantidadeAulas = materia.numeroAulas();
        boolean encontrouAulaLivre = false;
        boolean haColisao = false;

        for (int i = 0; i < quantidadeAulas; i++) {
            horarioDisponivel = null;
            
            for (Horario h : horarioProfessorLivre) {
                encontrouAulaLivre = horarioSemestre.horarioDisponivel(h);
                if (encontrouAulaLivre) {
                    horarioDisponivel = h;
                    break;
                }
            }

            if (encontrouAulaLivre) {
                haColisao = this.haColisao(horarioDisponivel, professor);

                if (!haColisao) {
                    horarioSemestre.marcarAula(horarioDisponivel, materia, professor);
                    qtdAulasAlocada ++;
                    
                } else {
                    penalidadeColisao++;
                }

            } else {
                penalidadeNaoAlocado++;
            }
        }
    }

    private boolean haColisao(Horario horario, Professor professor) {
        boolean colisao = false;

        for (Semestre s : _semestres) {
            HorarioSemestre horarioSemestre = _quadroHorarios.get(s);
            boolean jaEMinistrado = horarioSemestre.jaEMinistradoPorEsteProfessor(professor, horario);

            if (jaEMinistrado) {
                colisao = true;
            }
        }
        return colisao;
    }
    
    public int obterValorPenalidade(){
        return penalidadeColisao + penalidadeNaoAlocado;
    }
    
    public String obterHorarios(){
        String horarios = "";
        Collection<HorarioSemestre> horariosPorSemestre = _quadroHorarios.values();
        
        for(HorarioSemestre h : horariosPorSemestre){
            horarios = horarios + h.obterHorarioSemestre();
        }
        
        return horarios;
    }
    
    public int obterQuantidadeDeAulasAlocadas(){
        return qtdAulasAlocada;
    }
}
