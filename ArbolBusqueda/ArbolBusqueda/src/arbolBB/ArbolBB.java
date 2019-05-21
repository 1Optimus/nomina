package arbolBB;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @ricardo perez 1255
 */

public class ArbolBB {

    private Nodo ndRaiz;
    int num_nodos;
    int itAltu;

    public ArbolBB() {
        ndRaiz = null;
    }
    public int obtenerqe(Nodo ndRaiz){//metodo recursivo para obtener el valor de fe
        if(ndRaiz==null){//si raiz es null, le quita uno
        return -1;
        }else{
        return ndRaiz.itFactroE;//de lo contraio envia el valor de factor de equilibiro
        } 
    }
    //rotacion izquierda
    public Nodo rotaizq(Nodo ndRaiz){
    Nodo aux= ndRaiz.ndIzq;//nuevo nodo apuntando a la rama izquierda
    ndRaiz.ndIzq=aux.itDer;
    aux.itDer=ndRaiz;
    ndRaiz.itFactroE=Math.max(obtenerqe(ndRaiz.ndIzq), obtenerqe(ndRaiz.itDer))+1;
    aux.itFactroE=Math.max(obtenerqe(aux.ndIzq),obtenerqe(aux.itDer))+1;
    return aux;
    }
    //rotacion hacia la derecha
        public Nodo rotader(Nodo ndRiaz){
    Nodo aux= ndRiaz.itDer;
    ndRiaz.itDer=aux.ndIzq;
    aux.ndIzq=ndRiaz;
    ndRiaz.itFactroE=Math.max(obtenerqe(ndRiaz.ndIzq), obtenerqe(ndRiaz.itDer))+1;
    aux.itFactroE=Math.max(obtenerqe(aux.ndIzq),obtenerqe(aux.itDer))+1;
    return aux;
    }
        //rotacion doble hacia la izquierda, que consta en hacer derecha y luego izq
        public Nodo rotadobleizq(Nodo ndRiaz){
        Nodo aux;
        ndRiaz.ndIzq=rotader(ndRiaz.ndIzq);
        aux=rotaizq(ndRiaz);
        return aux;
        }
        //rotar doble hacia la derecha
        public Nodo rotadobleder(Nodo ndRaiz){
        Nodo aux;//que consta de hacer izquierda y luego derechga
        ndRaiz.itDer=rotaizq(ndRaiz.itDer);
        aux=rotader(ndRaiz);
        return aux;
        }
        //metodo para insertar nuevo, y equilibra el arbol
        public Nodo insertaravl(Nodo nsNuevo, Nodo ndpivot){
        Nodo nuevop=ndpivot;
         if(nsNuevo.itDato<ndpivot.itDato){//si el dato es menor al de raiz
             if(ndpivot.ndIzq==null){//si el de liquierda es null, lo mete alli
             ndpivot.ndIzq=nsNuevo;
             }else{//como no es null, se manda a llamar el metodo otra vez con la nueva raiz 
             ndpivot.ndIzq=insertaravl(nsNuevo, ndpivot.ndIzq);//la nueva raiz, es el padre de izquierda
            if(obtenerqe(ndpivot.ndIzq)-obtenerqe(ndpivot.itDer)==2){//para ver si tiene que hacer movimientos dobles
            if(nsNuevo.itDato<ndpivot.ndIzq.itDato){//si el nuevo dato fuera menor al de raiz
                nuevop=rotaizq(ndpivot);
            }else{//si no es menor al de la raiz
            nuevop=rotadobleizq(ndpivot);
            }
            }
             }
         }else if(nsNuevo.itDato>ndpivot.itDato){//si el dato es mayor de raiz
         if(ndpivot.itDer==null){//si el de derecha es null, lo mete alli
         ndpivot.itDer=nsNuevo;
         }else{//como no es null, se manda a llamar el metodo otra vez con la nueva raiz 
         ndpivot.itDer=insertaravl(nsNuevo,ndpivot.itDer);//ahora envia el dato con nueva raiz, padre derecho
         if(obtenerqe(ndpivot.itDer)-obtenerqe(ndpivot.ndIzq)==2){//si fuera mayor a 1
            //se mira que movimiento debe de hacerce
             if(nsNuevo.itDato>ndpivot.itDer.itDato){
             nuevop=rotader(ndpivot);//movimiento derecha
             }else{//movimiento doble derecha
             nuevop=rotadobleder(ndpivot);
             
             }
         }
         }
         }else{//si no es mayor ni menor es igual, entonces no se puede ingresar
         JOptionPane.showMessageDialog(null,"Nodo duplicado, no se puede colocar nodos duplicados");
         }
         //actualizando altura, aca se actializan los tamaños de altura de cada rama
         if((ndpivot.ndIzq==null)&&(ndpivot.itDer!=null)){
         ndpivot.itFactroE=ndpivot.itDer.itFactroE+1;
         }else if((ndpivot.itDer==null)&&(ndpivot.ndIzq!=null)){
            ndpivot.itFactroE=ndpivot.ndIzq.itFactroE+1;         
         }else{
         ndpivot.itFactroE=Math.max(obtenerqe(ndpivot.ndIzq),obtenerqe(ndpivot.itDer))+1;         
         }
         return nuevop;
        }
        public boolean insertar(int itDato){//metodo inicial para ingresar
          Nodo nuevo= new Nodo(itDato,null,null);
        if(ndRaiz==null){//si no tiene nada, automaticamente se vuelve raiz
        ndRaiz=nuevo;
        }else{//de lo contrario se llama al metodo de ingreso que lo va a equilibrar tambien
        ndRaiz=insertaravl(nuevo,ndRaiz);
        }
        return true;
        }
    public Nodo getRaiz() {//se devuelve el valor de la raiz
        return ndRaiz;
    } 

    public void setRaiz(Nodo raiz) {//se cambia el valor de raiz
        this.ndRaiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(ndRaiz, rec);
        return rec;
    }
    //metodo para obtener los datos, en preorden
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            //hasta que se acaben los datos,
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(ndRaiz, rec);
        return rec;
    }
    //metodo de inorden
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            //hasta que se acaben los datos,
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(ndRaiz, rec);
        return rec;
    }
    //metodo para obtencion de post orden
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            //hasta que se acaben los datos, va a obtener primero, der y luego izq
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int irDato) {
        Nodo aux = ndRaiz;
        while (aux != null) {
            if (irDato == aux.getDato()) {
                return true;
            } else if (irDato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
