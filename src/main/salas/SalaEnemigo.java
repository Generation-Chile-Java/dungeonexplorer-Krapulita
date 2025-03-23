package main.salas;
import main.jugador.Jugador;

public class SalaEnemigo extends SalaBase {
    private boolean enemigoVivo = true;
    @Override

    public void entrar(Jugador jugador){
        if (enemigoVivo){
            System.out.println("¡Un xenomorfo salta de la nada y te ataca!");
            jugador.recibirGolpe(20);
        }else{
            System.out.println("Acá había un xenomorfo, ahora solo yace su cadáver.");
        }
    }
    public void matarEnemigo(){
        enemigoVivo = false;
    }
}
