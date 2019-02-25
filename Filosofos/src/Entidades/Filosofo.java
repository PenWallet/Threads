package Entidades;

import java.util.Random;

public class Filosofo implements Runnable {

    private static int idGenerator = 0;
    public int id;
    private String nombre;
    private boolean satisfecho;
    private Mesa mesa;

    public Filosofo(String nombre, Mesa mesa)
    {
        this.id = idGenerator++;
        this.nombre = nombre;
        this.mesa = mesa;
        this.satisfecho = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        int tiempoPensamiento, tiempoEspera;
        Palillo[] palillos;

        while(1 == 1)
        {
            satisfecho = false;

            tiempoPensamiento = random.nextInt(2000)+1000;
            System.out.println("El filósofo "+nombre+" se ha puesto a pensar");
            try {
                Thread.sleep(tiempoPensamiento);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while(!satisfecho)
            {
                palillos = mesa.obtenerPalillosFilosofo(id);
                if(palillos[0].isEnUso() || palillos[1].isEnUso())
                {
                    tiempoEspera = random.nextInt(1000)+1000;
                    System.out.println(nombre+" no puede usar todos los palillos, va a esperar");
                    try {
                        Thread.sleep(tiempoEspera);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
                else
                {
                    palillos[0].setEnUso(true);
                    palillos[1].setEnUso(true);

                    tiempoEspera = random.nextInt(4000)+500;
                    System.out.println(nombre+" va a comer");
                    try {
                        Thread.sleep(tiempoEspera);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    palillos[0].setEnUso(false);
                    palillos[1].setEnUso(false);

                    satisfecho = true;
                }
            }
        }
    }
}
