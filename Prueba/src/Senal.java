public class Senal {
    public synchronized void doWait()
    {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doNotify()
    {
        this.notify();
    }
}
