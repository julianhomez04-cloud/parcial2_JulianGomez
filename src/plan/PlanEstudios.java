package plan;

import cursos.*;
import java.util.ArrayList;

public class PlanEstudios {
    private String nombre;
    private ArrayList<Curso> cursos;

    public PlanEstudios(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
        // composición: los cursos se crean dentro del plan
        agregarCurso(new CursoObligatorio("OBL-01", "Programacion I", 4));
        agregarCurso(new CursoObligatorio("OBL-02", "Estructuras de Datos", 3));
        agregarCurso(new CursoElectivo("ELE-01", "Inteligencia Artificial", 3));
        agregarCurso(new CursoNivelatorio("NIV-01", "Matematicas Basicas", 2));
    }

    private void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public double dificultadPromedio() {
        if (cursos.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Curso c : cursos) {
            suma += c.dificultadEsperada();
        }
        return suma / cursos.size();
    }

    public String getNombre() { return nombre; }
    public ArrayList<Curso> getCursos() { return cursos; }
}
