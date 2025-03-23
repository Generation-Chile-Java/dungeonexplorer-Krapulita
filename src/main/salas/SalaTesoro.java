package main.salas;
import main.jugador.Jugador;
import main.objetos.Bebida;
import main.objetos.PistolaLaser;

public class SalaTesoro extends SalaBase {
    @Override
    public void entrar(Jugador jugador) {
        System.out.println("En esta sala hay algo que brilla...");

        if (!jugador.tienePistola()) {
            PistolaLaser pistola = new PistolaLaser();
            jugador.tomarObjeto(pistola);
            System.out.println("¡Has encontrado una Pistola Láser! Ahora podrás defenderte.");
        } else {
            Bebida bebida = new Bebida();
            jugador.tomarObjeto(bebida);
            System.out.println("Has encontrado una Bebida Energética, está tibia.");
        }
    }
}


