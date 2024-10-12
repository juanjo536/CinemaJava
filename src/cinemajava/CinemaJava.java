package cinemajava;

import java.util.Random;
import java.util.Scanner;

public class CinemaJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //pide los datos de la pelicula 
        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese la duración de la película (en minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese la edad mínima para ver la película: ");
        int edad_requerida = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el nombre del director: ");
        String director = scanner.nextLine();

        System.out.print("Ingrese el precio de la entrada: ");
        double precio = Double.parseDouble(scanner.nextLine());

        // Crear la película
        Pelicula pelicula = new Pelicula(titulo, duracion, edad_requerida, director, precio);
        Sillas sillas = new Sillas(); // Crear la matriz de sillas
        Asignacion asignacion = new Asignacion(sillas); // Crear la asignación

        while (true) {
            // pide los datos del cliete
            System.out.print("Ingrese el nombre del espectador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la edad del espectador: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese la cantidad de dinero del espectador: ");
            double dineroEntrante = Double.parseDouble(scanner.nextLine());
            //lso datos del cliente 
            Cliente cliente = new Cliente(nombre, edad, dineroEntrante);
            System.out.println("Nuevo espectador: " + cliente.getNombre() +
                ", Edad: " + cliente.getEdad() + ", Dinero: " + cliente.getDinero());

            // Asignar un asiento aleatorio
            int filaAleatoria;
            int columnaAleatoria;

            do {
                filaAleatoria = random.nextInt(8); 
                columnaAleatoria = random.nextInt(9); 
            } while (sillas.isOcupado(filaAleatoria, columnaAleatoria)); // Repite si la silla esta ocupada 

            // Asignar el asiento
            if (asignacion.asignarSilla(cliente, filaAleatoria, columnaAleatoria, pelicula)) {
                // Mostrar la silla asignada 
                String asientoAsignado = sillas.getMatriz()[filaAleatoria][columnaAleatoria];
                double cambio = dineroEntrante - pelicula.getPrecio_entrada();
                if (cambio < 0) {
                    System.out.println("El espectador no tiene suficiente dinero para la entrada.");
                } else {
                    // Mensaje con la silla asignada
                    System.out.println("La silla asignada es: " + asientoAsignado);
                    System.out.println("Cambio a devolver: " + cambio);
                }
            } else {
                System.out.println("El asiento ya está ocupado o la entrada es inválida.");
            }

            // Mostrar si la silla esta ocupada 
            sillas.mostrarSillas();

            //para decidir si se continua agregando clientes o no
            System.out.print("¿Desea asignar otro asiento? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                System.out.println("Finalizando el programa.");
                break;
            }
        }
        scanner.close();
    }
}

