package main.objetos;
import main.jugador.Jugador;
import main.salas.SalaEnemigo;

public class PistolaLaser implements ObjetoJuego {
    private String nombre;
    public PistolaLaser(){
        this.nombre = "Pistola Láser";
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void usar(Jugador jugador) {
        if (jugador.getSalaActual() instanceof SalaEnemigo) {
            ((SalaEnemigo) jugador.getSalaActual()).matarEnemigo();
            System.out.println("¡Disparaste la pistola láser! El xenomorfo ha sido eliminado.");
        } else {
            System.out.println("No hay enemigos aquí. Guardas la pistola.");
        }
    }
}
