import java.util.Random;

public class Recolector implements Runnable {

    private Senal senal;
    Random random = new Random();
    int randomSleep;

    public Recolector(Senal senal)
    {
        this.senal = senal;
    }

    @Override
    public void run() {
        while(1 == 1)
        {
            if(Cola.estaVacio()) {
                senal.doWait();
            }

            try {
                randomSleep = random.nextInt(2000)+500;
                //System.out.println("El recolector está esperando "+randomSleep+"ms");
                Thread.sleep(randomSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("El número siguiente es: "+Cola.cogerNumero());
            senal.doNotify();
        }
    }
}
