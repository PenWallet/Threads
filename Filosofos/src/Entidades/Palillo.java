package Entidades;

public class Palillo {
    private boolean enUso;

    public Palillo()
    {
        this.enUso = false;
    }

    public synchronized void setEnUso(boolean enUso)
    {
        this.enUso = enUso;
    }

    public boolean isEnUso() {
        return enUso;
    }
}
