package main.salas;
import main.jugador.Jugador;

public interface Sala {
    void entrar (Jugador jugador);
    Sala getOpcion1();
    Sala getOpcion2();
}
