package cinemajava;

public class Pelicula {
    private String titulo;
    private String director;
    private int duracion;
    private int edad_requerida;
    private double precio_entrada;

    public Pelicula(String titulo, int duracion, int edad_requerida, String director, double precio_entrada) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edad_requerida = edad_requerida;
        this.director = director;
        this.precio_entrada = precio_entrada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getEdad_requerida() {
        return edad_requerida;
    }

    public double getPrecio_entrada() {
        return precio_entrada;
    }
}
