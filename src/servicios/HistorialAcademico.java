package servicios;

import personas.Estudiante;

public class HistorialAcademico {
    private Estudiante estudiante;

    public HistorialAcademico(Estudiante e) {
        this.estudiante = e;
    }

    public double promedio() {
        return estudiante.promedio();
    }

    public int cantidadCursos() {
        return estudiante.getInscritos().size();
    }

    public Estudiante getEstudiante() { return estudiante; }
}
