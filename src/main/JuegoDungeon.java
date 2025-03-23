package main;
import main.jugador.Jugador;
import main.salas.*;
import java.util.Scanner;

public class JuegoDungeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuál es tu nombre?");
        String nombreJugador = sc.nextLine();
        System.out.println("Hola " + nombreJugador + ", acabas de despertar en un lugar oscuro, lo último que recuerdas es que tu nave estrelló contra una cueva extraña. Hay un contador que marca 10 pero no sabes que significa, solo quieres salir de acá lo más pronto posible.");


        SalaFinal salaFinal = new SalaFinal();
        SalaTesoro salaTesoro = new SalaTesoro();
        SalaEnemigo salaEnemigo = new SalaEnemigo();
        SalaTrampa salaTrampa = new SalaTrampa();
        SalaVacia salaVacia = new SalaVacia();


        salaVacia.setOpciones(salaTesoro, salaEnemigo);
        salaTesoro.setOpciones(salaVacia, salaTrampa);
        salaEnemigo.setOpciones(salaVacia, salaFinal);
        salaTrampa.setOpciones(salaTesoro, salaFinal);


        Jugador jugador = new Jugador(nombreJugador, 100, salaVacia);

        boolean jugando = true;
        while (jugando) {
            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Ver estado");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Usar un objeto");
            System.out.println("4. Avanzar a otra sala");
            System.out.println("5. Salir del juego");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    jugador.estado();
                    break;
                case 2:
                    jugador.mostrarInventario();
                    break;
                case 3:
                    jugador.usarObjeto();
                    break;
                case 4:
                    System.out.println("¿A qué sala quieres ir?");
                    System.out.println("1. Sala Izquierda");
                    System.out.println("2. Sala Derecha");
                    int eleccion = sc.nextInt();
                    sc.nextLine();
                    if (eleccion == 1) {
                        jugador.setSalaActual(jugador.getSalaActual().getOpcion1());
                    } else {
                        jugador.setSalaActual(jugador.getSalaActual().getOpcion2());
                    }
                    jugador.getSalaActual().entrar(jugador);


                    if (jugador.getSalaActual() instanceof SalaFinal) {
                        System.out.println("¡Felicidades, has logrado salir de esta mazmorra alenígena!");
                        jugando = false;
                    } else if (jugador.haRecorridoTodasLasSalas(10)) {
                        System.out.println("Exploraste todas las salas, pero no lograte encontrar la salida... Fin del juego.");
                        jugando = false;
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del juego...");
                    jugando = false;
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
        sc.close();
    }
}
