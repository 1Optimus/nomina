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
    public int obtenerqe(Nodo r){//metodo recursivo para obtener el valor de fe
        if(r==null){//si raiz es null, le quita uno
        return -1;
        }else{
        return r.itFactroE;//de lo contraio envia el valor de factor de equilibiro
        } 
    }
    //rotacion izquierda
    public Nodo rotaizq(Nodo r){
    Nodo aux= r.ndIzq;//nuevo nodo apuntando a la rama izquierda
    r.ndIzq=aux.itDer;
    aux.itDer=r;
    r.itFactroE=Math.max(obtenerqe(r.ndIzq), obtenerqe(r.itDer))+1;
    aux.itFactroE=Math.max(obtenerqe(aux.ndIzq),obtenerqe(aux.itDer))+1;
    return aux;
    }
    //rotacion hacia la derecha
        public Nodo rotader(Nodo r){
    Nodo aux= r.itDer;
    r.itDer=aux.ndIzq;
    aux.ndIzq=r;
    r.itFactroE=Math.max(obtenerqe(r.ndIzq), obtenerqe(r.itDer))+1;
    aux.itFactroE=Math.max(obtenerqe(aux.ndIzq),obtenerqe(aux.itDer))+1;
    return aux;
    }
        //rotacion doble hacia la izquierda, que consta en hacer derecha y luego izq
        public Nodo rotadobleizq(Nodo r){
        Nodo aux;
        r.ndIzq=rotader(r.ndIzq);
        aux=rotaizq(r);
        return aux;
        }
        //rotar doble hacia la derecha
        public Nodo rotadobleder(Nodo r){
        Nodo aux;//que consta de hacer izquierda y luego derechga
        r.itDer=rotaizq(r.itDer);
        aux=rotader(r);
        return aux;
        }
        //metodo para insertar nuevo, y equilibra el arbol
        public Nodo insertaravl(Nodo nuevo, Nodo sub){
        Nodo nuevop=sub;
         if(nuevo.itDato<sub.itDato){//si el dato es menor al de raiz
             if(sub.ndIzq==null){//si el de liquierda es null, lo mete alli
             sub.ndIzq=nuevo;
             }else{//como no es null, se manda a llamar el metodo otra vez con la nueva raiz 
             sub.ndIzq=insertaravl(nuevo, sub.ndIzq);//la nueva raiz, es el padre de izquierda
            if(obtenerqe(sub.ndIzq)-obtenerqe(sub.itDer)==2){//para ver si tiene que hacer movimientos dobles
            if(nuevo.itDato<sub.ndIzq.itDato){//si el nuevo dato fuera menor al de raiz
                nuevop=rotaizq(sub);
            }else{//si no es menor al de la raiz
            nuevop=rotadobleizq(sub);
            }
            }
             }
         }else if(nuevo.itDato>sub.itDato){//si el dato es mayor de raiz
         if(sub.itDer==null){//si el de derecha es null, lo mete alli
         sub.itDer=nuevo;
         }else{//como no es null, se manda a llamar el metodo otra vez con la nueva raiz 
         sub.itDer=insertaravl(nuevo,sub.itDer);//ahora envia el dato con nueva raiz, padre derecho
         if(obtenerqe(sub.itDer)-obtenerqe(sub.ndIzq)==2){//si fuera mayor a 1
            //se mira que movimiento debe de hacerce
             if(nuevo.itDato>sub.itDer.itDato){
             nuevop=rotader(sub);//movimiento derecha
             }else{//movimiento doble derecha
             nuevop=rotadobleder(sub);
             
             }
         }
         }
         }else{//si no es mayor ni menor es igual, entonces no se puede ingresar
         JOptionPane.showMessageDialog(null,"Nodo duplicado, no se puede colocar nodos duplicados");
         }
         //actualizando altura, aca se actializan los tamaños de altura de cada rama
         if((sub.ndIzq==null)&&(sub.itDer!=null)){
         sub.itFactroE=sub.itDer.itFactroE+1;
         }else if((sub.itDer==null)&&(sub.ndIzq!=null)){
            sub.itFactroE=sub.ndIzq.itFactroE+1;         
         }else{
         sub.itFactroE=Math.max(obtenerqe(sub.ndIzq),obtenerqe(sub.itDer))+1;         
         }
         return nuevop;
        }
        public boolean insertar(int d){//metodo inicial para ingresar
          Nodo nuevo= new Nodo(d,null,null);
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
    public boolean existe(int dato) {
        Nodo aux = ndRaiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
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
