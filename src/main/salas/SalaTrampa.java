package main.salas;
import main.jugador.Jugador;

public class SalaTrampa extends SalaBase {
    @Override
    public void entrar(Jugador jugador) {
        System.out.println("Esta sala esta cubierta de una sustancia ácida. Recibes 15 puntos de daño.");
        jugador.recibirGolpe(15);
    }
}