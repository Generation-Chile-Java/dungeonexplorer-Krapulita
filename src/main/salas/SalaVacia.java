package main.salas;

import main.jugador.Jugador;

public class SalaVacia extends SalaBase {
    @Override
    public void entrar(Jugador jugador) {
        System.out.println("Has encontrado una sala vacía. Acá no hay mas que máquinas");
    }

    @Override
    public Sala getOpcion1() {
        return opcion1;
    }

    @Override
    public Sala getOpcion2() {
        return opcion2;
    }
}
