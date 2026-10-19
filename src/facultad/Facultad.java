package facultad;

import plan.PlanEstudios;
import java.util.ArrayList;

public class Facultad {
    private String nombre;
    private ArrayList<PlanEstudios> planes;

    public Facultad(String nombre) {
        this.nombre = nombre;
        this.planes = new ArrayList<>();
    }

    public void agregarPlan(PlanEstudios p) {
        planes.add(p);
    }

    public int totalCursos() {
        int total = 0;
        for (PlanEstudios p : planes) {
            total += p.getCursos().size();
        }
        return total;
    }

    public String getNombre() { return nombre; }
    public ArrayList<PlanEstudios> getPlanes() { return planes; }
}
