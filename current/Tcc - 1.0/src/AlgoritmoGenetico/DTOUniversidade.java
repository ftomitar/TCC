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

    private Map<String, Semestre> _semestres;
    private Map<String, Materia> _materias;
    private Map<Materia, Professor> _professorLeciona;
    private Set<Horario> _horarios;
    private Set<Semestre> _semestresUniversidade;
    private Set<Materia> _materiasUniversidade;

    public DTOUniversidade(Modelo.de.PL.Aula aula) {
        _semestres = new HashMap<String, Semestre>();
        _materias = new HashMap<String, Materia>();
        _professorLeciona = new HashMap<Materia, Professor>();

        Set<Professor> professores = aula.getProfessores();
        Set<Materia> materias = aula.getMaterias();
        Set<Semestre> semestres = aula.getSemestres();
        Set<Materia> materiasLecionadas;

        _horarios = aula.getHorarios();
        _semestresUniversidade = semestres;
        _materiasUniversidade = materias;

        for (Semestre semestre : semestres) {
            _semestres.put(semestre.getNome(), semestre);
        }

        for (Materia materia : materias) {
            _materias.put(materia.getNome(), materia);
        }

        for (Professor professor : professores) {
            materiasLecionadas = professor.getMateriasLecionadas();
            for (Materia materia : materiasLecionadas) {
                _professorLeciona.put(materia, professor);
            }
        }

    }

    @Deprecated
    public Materia obterMateria(String idMateria) {
        return _materias.get(idMateria);
    }

    @Deprecated
    public Semestre obterSemestre(String idSemestre) {
        return _semestres.get(idSemestre);
    }

    @Deprecated
    public Professor obterProfessor(Materia materia) {
        return _professorLeciona.get(materia);
    }

    @Deprecated
    public Set<Horario> obterHorarios() {
        return _horarios;
    }

    @Deprecated
    public Set<Semestre> obterSemestres() {
        return _semestresUniversidade;
    }

    @Deprecated
    public Set<Materia> obterMaterias() {
        return _materiasUniversidade;
    }

}
