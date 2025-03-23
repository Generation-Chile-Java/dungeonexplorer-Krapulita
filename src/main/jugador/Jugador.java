package main.jugador;

import main.objetos.Bebida;
import main.objetos.ObjetoJuego;
import main.objetos.PistolaLaser;
import main.salas.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int vida;
    private ArrayList<ObjetoJuego> inventario;
    private Sala salaActual;
    private boolean tienePistola;
    private int salasVisitadas;
    private boolean pasoPorObjeto;
    private boolean pasoPorEnemigo;
    private boolean pasoPorTrampa;

    //Getters
    public boolean tienePistola() {
        return tienePistola;
    }

    //Constructor
    public Jugador(String nombre, int vida, Sala salaInicial) {
        this.nombre = nombre;
        this.vida = vida;
        this.inventario = new ArrayList<>();
        this.salaActual = salaInicial;
        this.tienePistola = false;
        this.salasVisitadas = 0;
        this.pasoPorObjeto = false;
        this.pasoPorEnemigo = false;
        this.pasoPorTrampa = false;
    }

    //Métodos de estado
    public void estado() {
        System.out.println("Jugador: " + nombre + " | Salud: " + vida + " | Inventario: " + inventario.size() + " objetos");
    }

    public boolean puedeEntrar() {
        return pasoPorObjeto && pasoPorEnemigo && pasoPorTrampa;
    }
    public boolean haRecorridoTodasLasSalas(int totalSalas) {
        return salasVisitadas >= totalSalas;
    }


    //Métodos de interacción
    public void tomarObjeto(ObjetoJuego objeto) {
        if (objeto instanceof PistolaLaser) {
            if (tienePistola) {
                System.out.println("Ya tienes una pistola láser. No puedes llevar más de una.");
                return;
            }
            tienePistola = true;
        }
        inventario.add(objeto);
    }
    public void usarObjeto() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío");
            return;
        }
        System.out.println("Selecciona un objeto para usar:");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i).getClass().getSimpleName());
        }
        Scanner sc = new Scanner(System.in);
        int opcion;
        try {
            System.out.print("Ingresa el número del objeto: ");
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > inventario.size()) {
                System.out.println("Intenta de nuevo.");
                return;
            }
            ObjetoJuego objetoSeleccionado = inventario.get(opcion - 1);
            objetoSeleccionado.usar(this);
            if (objetoSeleccionado instanceof Bebida) {
                inventario.remove(objetoSeleccionado);
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Debes ingresar un número.");
        }
    }
    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío");
        } else {
            System.out.println("Inventario:");
            for (ObjetoJuego obj : inventario) {
                System.out.println("- " + obj.getNombre());
            }
        }
    }

    //Métodos de combate y curación
    public void recibirGolpe(int golpe) {
        this.vida -= golpe;
        System.out.println(nombre + " recibe " + golpe + " de daño. Salud restante: " + vida);
    }
    public void sanar(int puntosSanacion) {
        this.vida += puntosSanacion;
    }


    //Métodos de movimiento
    public Sala getSalaActual() {
        return salaActual;
    }
    public void setSalaActual(Sala nuevaSala) {
        if (nuevaSala instanceof SalaFinal && !puedeEntrar()) {
            System.out.println("Esta puerta parece estar bloqueada...");
            System.out.println("Te devuelves a la sala anterior.");
            return;
        }
        this.salaActual = nuevaSala;
        salasVisitadas++;

        if (nuevaSala instanceof SalaTesoro) {
            pasoPorObjeto = true;
        }
        if (nuevaSala instanceof SalaEnemigo) {
            pasoPorEnemigo = true;
        }
        if (nuevaSala instanceof SalaTrampa) {
            pasoPorTrampa = true;
        }
    }
}