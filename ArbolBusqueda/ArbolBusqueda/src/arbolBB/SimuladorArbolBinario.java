
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
* @ricardo perez 1255
 */
public class SimuladorArbolBinario {

    ArbolBB miArbol = new ArbolBB();

    public SimuladorArbolBinario() {
    }
    //metodo donde se inserta el nuevo dato ingresado
    public boolean insertar(Integer dato) {
        return (this.miArbol.insertar(dato));
    }
    //metodo para mostrar los recorridos del arbol
    public String preOrden() {
        LinkedList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        LinkedList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

    public String postOrden() {
        LinkedList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }
    
    //metodo para poder mostrar los tipos d recorrido
    private String recorrido(LinkedList it, String msg) {
        int itI = 0;
        String r = msg + "\n";
        while (itI < it.size()) {
            r += "\t" + it.get(itI).toString() + "";
            itI++;
        }
        return (r);
    }
    
    
    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.miArbol.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
