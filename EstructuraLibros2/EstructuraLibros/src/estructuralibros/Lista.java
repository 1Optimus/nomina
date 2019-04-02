package estructuralibros;

import javax.swing.JOptionPane;

/**
 * @author Ricardo Perez 1255
 */
public class Lista {
    //se inicia los nodos y variables
	private Nodo cabeza=null;
	private int longitud=0;
	private class Nodo {
            //se declaran variables locales y un puntador
		public Libro libro;
		public Nodo siguiente=null;
		public Nodo(Libro libro) {//se obtiene el dato enviado en variable local
			this.libro=libro;
		}
	}
	public void insertarPrincipio(Libro libro) {//incerta un dato al principio de la lista, que ahora el es la cabeza
		Nodo nodo=new Nodo(libro);
		nodo.siguiente=cabeza;//el nuevo nodo apunta al nodo anterior
		cabeza=nodo;//toma el nuevo nodo valor de cabeza
		longitud++;	//se aumenta tamano para saber cantidad
	}
	public void insertarFinal(Libro libro) {
		Nodo nodo=new Nodo(libro);//nuevo nodo obtiene los datos enviados de libro
		if (cabeza==null) {//si no esta inicializada la lista ahora se hace
			cabeza=nodo;
		} else {
			Nodo puntero=cabeza;//un puntero que apunta a la cabeza
			while (puntero.siguiente!=null) {
				puntero=puntero.siguiente;//hasta que encuentre el ultimo
			}
			puntero.siguiente=nodo;//ahora el punto del ultimo apunta al nuevo nodo
		}
		longitud++;//se aumenta tamanio
	}
	public void insertarDespues(int n, Libro libro) {
		Nodo nodo=new Nodo(libro);//nuevo nodo con los datos enviados aca
		if (cabeza==null) {//si no esta inicializada la lista ahora se hace
			cabeza=nodo;
		} else {
			Nodo puntero=cabeza;//un puntero que apunta a la cabeza
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;//hasta que encuentre el numero enviado n
				contador++;
			}
			nodo.siguiente=puntero.siguiente;//el nodo n apunta al nodo siguiente
			puntero.siguiente=nodo;//el nodo nuevo apunta al n
		}
		longitud++;//aumenta tamanio
	}
	public Libro obtener(int n) {
		if (cabeza==null) {//regresa nulo si no existe el nodo
			return null;
		} else {
			Nodo puntero=cabeza;
			int contador=0;
                        //encuentra el nodo con n, y lo envia
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;
				contador++;//un contador para que se salga del while cuando lo encuentre
			}
			if (contador!=n) {//si llego y no estaba que regrese nulo
				return null;
			} else {
				return puntero.libro;//regresa el puntero si lo encontro
			}
		}
	}
	public int contar() {
		return longitud;//envia la variable longitud, que contiene la cantidad
	}
        public boolean estaVacia() {
            return cabeza==null;//regresa datos si no regresa es por que esta vacia
        }
        public void eliminaPrincipio() {
            if (cabeza!=null){
                //el nodo primero obtiene la direccion de cabeza, para luego darsela al del siguiente
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente;
                longitud--;//se elimina uno del tamanio total
            }
        }
        public void eliminarUltimo() {
            if (cabeza!= null) {//si no es null
                //si este nodo no es el ultimo
                if (cabeza.siguiente==null) {
                    //regresa que ya lo hizo y hace null este nodo
                    cabeza=null;  
                    longitud--;
                } else {
                    Nodo puntero=cabeza;
                    while (puntero.siguiente.siguiente!=null) {                    
                        puntero=puntero.siguiente;//encuentra el ultimo nodo y hace que el anterior apunto a null
                    }
                    puntero.siguiente=null;
                    longitud--;//se elimina uno del tamanio total
                }
            }
        }
        public void eliminarLibro(int n) {
            if (cabeza!=null){//que no este vacia la lista
                if (n==0){//si es el primero, hace que el segundo apunte al tarecer y que cabeza apunte al segundo
                    Nodo primer=cabeza;
                    cabeza=cabeza.siguiente;
                    primer.siguiente=null;
                    longitud--;
                } else if (n<longitud) {//si esta entre el rango existente, va recorrer todo hasta que encuentre el n al buscar
                    Nodo puntero=cabeza;
                    int contador=0;
                    while (contador<(n-1)){
                        puntero=puntero.siguiente;
                        contador++;
                    }
                    Nodo temp=puntero.siguiente;//hace que el anterior apunte al siguiente del nodo a eliminar
                    puntero.siguiente=temp.siguiente;
                    temp.siguiente=null;//el nodo a eliminar lo apunta null
                    longitud--;//elimina uno del total en la lista
                }
            }
        }
        	public String visualizar() {//se inicializa las variables a necesitar
		String Dato="";                
		Nodo aux=cabeza;                
		while (aux!=null)
		{                       //hasta que encuentre null no va a parar y guardar los datos en esa variable          
			Dato+="Autor: " + aux.libro.getAutor()+"\t\tTitulo: "+ aux.libro.getTitulo()+"\t\tISBN: "+ aux.libro.getIsbn()+"\n";
			aux=aux.siguiente;
		}
		return(Dato);//regresa lo que tiene la variabel
	}
                 public void Vaciar() {
             cabeza.siguiente=null;//regresa datos si no regresa es por que esta vacia
             cabeza=null;
        }
        
}
