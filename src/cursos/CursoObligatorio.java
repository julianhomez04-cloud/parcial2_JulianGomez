package cursos;

public class CursoObligatorio extends Curso {

    public CursoObligatorio(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
    }

    @Override
    public double dificultadEsperada() {
        return 1.5 * getCreditos();
    }
}
