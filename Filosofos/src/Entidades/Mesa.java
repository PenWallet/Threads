package Entidades;

import Entidades.Filosofo;
import Entidades.Palillo;

import java.util.ArrayList;

public class Mesa {
    private ArrayList<Object> mesa;

    public Mesa()
    {
        mesa = new ArrayList<>();
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Oscar", this));
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Nacho", this));
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Goruge", this));
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Samuel", this));
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Angel", this));
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Ruafa", this));
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Dylan", this));
        mesa.add(new Palillo());
        mesa.add(new Filosofo("Luis", this));

        Thread thread1 = new Thread((Filosofo)mesa.get(1));
        Thread thread2 = new Thread((Filosofo)mesa.get(3));
        Thread thread3 = new Thread((Filosofo)mesa.get(5));
        Thread thread4 = new Thread((Filosofo)mesa.get(7));
        Thread thread5 = new Thread((Filosofo)mesa.get(9));
        Thread thread6 = new Thread((Filosofo)mesa.get(11));
        Thread thread7 = new Thread((Filosofo)mesa.get(13));
        Thread thread8 = new Thread((Filosofo)mesa.get(15));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
    }

    public Filosofo obtenerFilosofoPorId(int idFilosofo)
    {
        Filosofo filosofo = null;
        for(int i = 0; i < mesa.size() && filosofo == null; i++)
        {
            if(mesa.get(i) instanceof Filosofo && ((Filosofo) mesa.get(i)).id == idFilosofo);
            filosofo = (Filosofo)mesa.get(i);
        }

        return filosofo;
    }

    public synchronized Palillo[] obtenerPalillosFilosofo(int idFilosofo)
    {
        int posicionMesa = -1;
        Palillo[] palillos = new Palillo[2];
        for(int i = 0; i < mesa.size() && posicionMesa == -1; i++)
        {
            if(mesa.get(i) instanceof Filosofo && ((Filosofo) mesa.get(i)).id == idFilosofo)
                posicionMesa = i;
        }

        if(posicionMesa != -1)
        {
            palillos[0] = (Palillo)mesa.get(posicionMesa - 1);

            if (posicionMesa == mesa.size() - 1)
                palillos[1] = (Palillo)mesa.get(0);
            else
                palillos[1] = (Palillo)mesa.get(posicionMesa+1);
        }

        return palillos;
    }

    public ArrayList<Object> getMesa() {
        return mesa;
    }

    public void setMesa(ArrayList<Object> mesa) {
        this.mesa = mesa;
    }
}
