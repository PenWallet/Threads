public class Main {
    public static void main(String[] args) {
        Senal senal = new Senal();
        Productor productorRunnable = new Productor(senal);
        Recolector recolectorRunnable = new Recolector(senal);

        Thread productor = new Thread(productorRunnable);
        Thread recolector = new Thread(recolectorRunnable);

        recolector.start();
        productor.start();
    }
}
