package cursos;

public abstract class Curso {
    private String codigo;
    private String nombre;
    private int creditos;

    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public abstract double dificultadEsperada();

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
}
