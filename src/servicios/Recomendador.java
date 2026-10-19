package servicios;

import cursos.*;
import java.util.ArrayList;
import java.util.List;

public class Recomendador {

    public List<Curso> recomendar(HistorialAcademico h) {
        List<Curso> resultado = new ArrayList<>();
        boolean buenPromedio = h.promedio() >= 4.0;

        for (Curso c : h.getEstudiante().getInscritos()) {
            if (buenPromedio && c instanceof CursoElectivo) {
                resultado.add(c);
            } else if (!buenPromedio && c instanceof CursoNivelatorio) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
