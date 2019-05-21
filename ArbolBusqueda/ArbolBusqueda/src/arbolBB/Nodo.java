package arbolBB;

/**
* @ricardo perez 1255
 */
public class Nodo {
    public int itDato, itFactroE;
    public Nodo ndIzq,itDer;

    public Nodo(int dato, Nodo izq, Nodo der) {
        this.itDato = dato;
        this.ndIzq = izq;
        this.itDer = der;
        this.itFactroE=0;
    }
// aca se encuentran todo los constructores, los cambios y obtencion de datos
    public int getDato() {
        return itDato;
    }

    public void setDato(int dato) {
        this.itDato = dato;
    }

    public Nodo getIzq() {
        return ndIzq;
    }

    public void setIzq(Nodo izq) {
        this.ndIzq = izq;
    }

    public Nodo getDer() {
        return itDer;
    }

    public void setDer(Nodo der) {
        this.itDer = der;
    }
 
}
