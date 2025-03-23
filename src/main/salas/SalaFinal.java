package main.salas;
import main.jugador.Jugador;

public class SalaFinal extends SalaBase {
        @Override
    public void entrar(Jugador jugador) {
        System.out.println("¡La puerta que parecía bloqueada se abrió! ¡Lograste salir!");
    }
}