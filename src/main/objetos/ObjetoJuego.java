package main.objetos;

import main.jugador.Jugador;

public interface ObjetoJuego {
    String getNombre();

    void usar(Jugador jugador);
}
