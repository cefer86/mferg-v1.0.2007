package erg2;

/**
 *
 * Autor: Cesar Peña
 */
public class Hilo {
    
    private int longHil;
    private int val = 0;
    private String statMessage;

    public Hilo(int u) {
        longHil = u;
    }

    void Iniciar() {
        val = 0;
        final SwingWork worker = new SwingWork() {
            public Object construct() {
                return new ActualVal();
            }
        };
    }

    int getLengthOfTask() {
        return longHil;
    }

    int RetVal() {
        return val;
    }

    void parar() {
        val = longHil;
    }

    boolean hecho() {
        if (val >= longHil)
            return true;
        else
            return false;
    }

    String RetMens() {
        return statMessage;
    }

    class ActualVal {
        ActualVal () {
            while (val < longHil) {
                try {
                    Thread.sleep(1000); 
                    val += Math.random() * 100;
                    if(val>=30 && val<=70) statMessage = "Actualizando Cambios...";
                    else if(val>70 && val <=80) statMessage ="Calculando Expresiones...";
                    else if(val>80 && val <=100) statMessage = "Graficando....";
                    
                } catch (InterruptedException e) {
                }
            }
        }
    }
    
}
