package AlgoritmoGenetico;

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
@Deprecated
public class DTOUniversidade {

    private Map<Materia, Semestre> _materiaSemestre;
    private Map<Materia, Professor> _professorLeciona;
    private Set<Horario> _horarios;
    private Set<Semestre> _semestres;
    private Set<Materia> _materias;

    public DTOUniversidade(Modelo.de.PL.Aula aula) {
        _professorLeciona = new HashMap<Materia, Professor>();
        _materiaSemestre = new HashMap<Materia, Semestre>();

        Set<Professor> professores = aula.getProfessores();
        Set<Materia> materias = aula.getMaterias();
        Set<Semestre> semestres = aula.getSemestres();
        Set<Materia> materiasLecionadas;

        _semestres = semestres;
        _materias = materias;

        _horarios = aula.getHorarios();

        for (Professor professor : professores) {
            materiasLecionadas = professor.getMateriasLecionadas();
            for (Materia materia : materiasLecionadas) {
                _professorLeciona.put(materia, professor);
            }
        }

        for (Materia m : materias) {
            Semestre lecionada = null;
            for (Semestre s : semestres) {
                if (s.materiaLecionada(m)) {
                    lecionada = s;
                }
            }
            if (lecionada != null) {
                _materiaSemestre.put(m, lecionada);
            }
        }

    }

    @Deprecated
    public Professor obterProfessor(Materia materia) {
        return _professorLeciona.get(materia);
    }

    @Deprecated
    public Semestre obterSemestreLecionada(Materia materia) {
        return _materiaSemestre.get(materia);
    }

    @Deprecated
    public Set<Horario> obterHorarios() {
        return _horarios;
    }

    @Deprecated
    public Set<Materia> obterMaterias() {
        return _materias;
    }

    @Deprecated
    public Set<Semestre> obterSemestres() {
        return _semestres;
    }

}

