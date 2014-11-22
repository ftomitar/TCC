package AlgoritmoGenetico;

import Modelo.de.PL.Materia;
import Modelo.de.PL.Professor;

/**
 *
 * @author felipe
 */
public class Aula {

    private Materia materia;
    private Professor professor;

    public Aula(Materia materia, Professor professor) {
        this.materia = materia;
        this.professor = professor;
    }
    
    public Materia getMateria() {
        return materia;
    }

    public Professor getProfessor() {
        return professor;
    }
}
