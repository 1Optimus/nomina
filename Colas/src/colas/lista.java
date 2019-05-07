package colas;

import javax.swing.JOptionPane;

/**
 * @author Ricardo Perez 1255
 * manejo de los metodos de la cola
 */
public class lista {
    //se inicia los nodos y variables
	private Nodo ndcabeza=null;
	private int itlongitud=0;
	private class Nodo {
            //se declaran variables locales y un puntador
		public libro libro;
		public Nodo ndsiguiente=null;
		public Nodo(libro libro) {//se obtiene el dato enviado en variable local
			this.libro=libro;
		}
	}	
	public void insertarFinal(libro libro) {
		Nodo nodo=new Nodo(libro);//nuevo nodo obtiene los datos enviados de libro
		if (ndcabeza==null) {//si no esta inicializada la lista ahora se hace
			ndcabeza=nodo;
		} else {
			Nodo puntero=ndcabeza;//un puntero que apunta a la cabeza
			while (puntero.ndsiguiente!=null) {
				puntero=puntero.ndsiguiente;//hasta que encuentre el ultimo
			}
			puntero.ndsiguiente=nodo;//ahora el punto del ultimo apunta al nuevo nodo
		}
		itlongitud++;//se aumenta tamanio
	}
	public int contar() {
		return itlongitud;//envia la variable longitud, que contiene la cantidad
	}
        public boolean estaVacia() {
            return ndcabeza==null;//regresa datos si no regresa es por que esta vacia
        }
        public void eliminaPrincipio() {
            if (ndcabeza!=null){
                //el nodo primero obtiene la direccion de cabeza, para luego darsela al del siguiente
                Nodo primer = ndcabeza;
                ndcabeza=ndcabeza.ndsiguiente;
                itlongitud--;//se elimina uno del tamanio total
            }
        }       
        	public String visualizar() {//se inicializa las variables a necesitar
		String stDato="";                
		Nodo aux=ndcabeza;
                if(aux==null){
                stDato="No tiene datos la cola";
                }else{
		while (aux!=null)
		{                       //hasta que encuentre null no va a parar y guardar los datos en esa variable          
			stDato+="Autor: " + aux.libro.getAutor()+"\t\tTitulo: "+ aux.libro.getTitulo()+"\t\tISBN: "+ aux.libro.getIsbn()+"\n";
			aux=aux.ndsiguiente;
		}
                }
		return(stDato);//regresa lo que tiene la variabel
	}
                 public void Vaciar() {
                     if (ndcabeza==null) {//si no esta inicializada la lista ahora se hace
			
		} else {
                ndcabeza.ndsiguiente=null;//regresa datos si no regresa es por que esta vacia
                 ndcabeza=null;
		}
		itlongitud=0;//se aumenta tamanio
	}
        
}
