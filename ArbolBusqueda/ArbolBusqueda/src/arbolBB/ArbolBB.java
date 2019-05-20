/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author .
 */

public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;

    public ArbolBB() {
        raiz = null;
    }
    public int obtenerqe(Nodo r){
        if(r==null){
        return -1;
        }else{
        return r.qe;
        } 
    }
    public Nodo rotaizq(Nodo r){
    Nodo aux= r.izq;
    r.izq=aux.der;
    aux.der=r;
    r.qe=Math.max(obtenerqe(r.izq), obtenerqe(r.der))+1;
    aux.qe=Math.max(obtenerqe(aux.izq),obtenerqe(aux.der))+1;
    return aux;
    }
        public Nodo rotader(Nodo r){
    Nodo aux= r.der;
    r.der=aux.izq;
    aux.izq=r;
    r.qe=Math.max(obtenerqe(r.izq), obtenerqe(r.der))+1;
    aux.qe=Math.max(obtenerqe(aux.izq),obtenerqe(aux.der))+1;
    return aux;
    }
        public Nodo rotadobleizq(Nodo r){
        Nodo aux;
        r.izq=rotader(r.izq);
        aux=rotaizq(r);
        return aux;
        }
        public Nodo rotadobleder(Nodo r){
        Nodo aux;
        r.der=rotaizq(r.der);
        aux=rotader(r);
        return aux;
        }
        public Nodo insertaravl(Nodo nuevo, Nodo sub){
        Nodo nuevop=sub;
         if(nuevo.dato<sub.dato){
             if(sub.izq==null){
             sub.izq=nuevo;
             }else{
             sub.izq=insertaravl(nuevo, sub.izq);
            if(obtenerqe(sub.izq)-obtenerqe(sub.der)==2){
            if(nuevo.dato<sub.izq.dato){
                nuevop=rotaizq(sub);
            }else{
            nuevop=rotadobleizq(sub);
            }
            }
             }
         }else if(nuevo.dato>sub.dato){
         if(sub.der==null){
         sub.der=nuevo;
         }else{
         sub.der=insertaravl(nuevo,sub.der);
         if(obtenerqe(sub.der)-obtenerqe(sub.izq)==2){
             if(nuevo.dato>sub.der.dato){
             nuevop=rotader(sub);
             }else{
             nuevop=rotadobleder(sub);
             
             }
         }
         }
         }else{
         System.out.println("Nodo duplicado, no se puede colocar nodos duplicados");
         }
         //actualizando altura
         if((sub.izq==null)&&(sub.der!=null)){
         sub.qe=sub.der.qe+1;
         }else if((sub.der==null)&&(sub.izq!=null)){
            sub.qe=sub.izq.qe+1;         
         }else{
         sub.qe=Math.max(obtenerqe(sub.izq),obtenerqe(sub.der))+1;         
         }
         return nuevop;
        }
        public boolean insertar(int d){
          Nodo nuevo= new Nodo(d,null,null);
        if(raiz==null){
        raiz=nuevo;
        }else{
        raiz=insertaravl(nuevo,raiz);
        }
        return true;
        }
    public Nodo getRaiz() {
        return raiz;
    } 

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
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
