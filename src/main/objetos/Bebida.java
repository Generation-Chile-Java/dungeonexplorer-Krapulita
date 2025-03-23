package main.objetos;
import main.jugador.Jugador;

public class Bebida implements ObjetoJuego {
    private String nombre;
    final private int puntosSanacion = 20;
    public Bebida(){
        this.nombre = "Bebida Energética";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.sanar(puntosSanacion);
        System.out.println("Has consumido una " + nombre + ", estaba tibia pero te hizo sentir mejor.");
        System.out.println("Recuperaste " + puntosSanacion + " puntos de vida.");

    }
}
