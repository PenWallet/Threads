import java.util.ArrayList;

public class Cola {
    private static ArrayList<Integer> cola = new ArrayList<>();

    public synchronized static int cogerNumero()
    {
        int numero = cola.get(0);
        int numeroAnterior;
        for(int i = 1; i < cola.size(); i++)
        {
            cola.set(i-1, cola.get(i));
        }
        cola.remove(cola.size()-1);
        return numero;
    }

    public synchronized static void meterNumero(int numero)
    {
        cola.add(numero);
    }

    public synchronized static boolean estaLleno()
    {
        return cola.size() == 5;
    }

    public synchronized static boolean estaVacio()
    {
        return cola.size() == 0;
    }
}
