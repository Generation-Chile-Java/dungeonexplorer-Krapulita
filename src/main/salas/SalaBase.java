package main.salas;
import java.util.Random;

public abstract class SalaBase implements Sala {
    protected Sala opcion1;
    protected Sala opcion2;

    public void setOpciones (Sala opcion1, Sala opcion2){
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
    }

    @Override
    public Sala getOpcion1(){
        return opcion1;
    }

    @Override
    public Sala getOpcion2() {
        return opcion2;
    }
}
