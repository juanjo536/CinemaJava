
package cinemajava;

public class Asignacion {
    private Sillas sillas;

    public Asignacion(Sillas sillas) {
        this.sillas = sillas;
    }

    public boolean asignarSilla(Cliente cliente, int fila, int columna, Pelicula pelicula) {
        if (sillas.isOcupado(fila, columna)) {
            return false; // silla ocupada 
        }
        sillas.ocupar(fila, columna);
        return true; //silla ocupada
    }
}

