import java.util.Random;

public class Productor implements Runnable {
    Random random = new Random();
    int randomSleep, randomNumber;
    Senal senal;

    public Productor(Senal senal)
    {
        this.senal = senal;
    }

    @Override
    public void run() {
        while(1 == 1)
        {
            randomSleep = random.nextInt(500)+500;
            //System.out.println("El productor está esperando "+randomSleep+"ms");
            try {
                Thread.sleep(randomSleep);
            } catch (InterruptedException e) { e.printStackTrace(); }

            randomNumber = random.nextInt(100);

            Cola.meterNumero(randomNumber);
            System.out.println("He producido "+randomNumber);
            senal.doNotify();

            if(Cola.estaLleno()) {
                senal.doWait();
            }
        }
    }
}
