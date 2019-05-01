package torreshanoi;
import javax.swing.JOptionPane;
//aca se encuentran todos los metodos los caules son las opciones del programa
public class Nodo {
    //declaracion de nodos y variable de longitud
    private nodo cabeza=null;
	private int longitud=0;
	private class nodo {
            //se declaran variables locales y un puntador
		public Hanoi han;
		public nodo siguiente=null;
		public nodo(Hanoi han) {//se obtiene el y se guarda en variable local
			this.han=han;
		}
	}
        public String TOP(){
        String Dato="";    //declaracion de variables            
		nodo aux=cabeza;   
                //verifica si hay datos en la pila, para regresar un mensaje si no tuviera
                if(null==aux){Dato="La pila se encuentra vacia";}else{ 		     
			Dato="Autor: " +  aux.han.getnum()+"\n";	
		}
		return(Dato);//regresa lo que tiene la variabel
        }
	public void PUSH(Hanoi han) {
		nodo nodo=new nodo(han);//nuevo nodo obtiene los datos enviados de libro
		if (cabeza==null) {//si no esta inicializada la lista ahora se hace
			cabeza=nodo;
		} else {
			nodo puntero=cabeza;//un puntero que apunta a la cabeza
			while (puntero.siguiente!=null) {
				puntero=puntero.siguiente;//hasta que encuentre el ultimo
			}
			puntero.siguiente=nodo;//ahora el punto del ultimo apunta al nuevo nodo
		}
		longitud++;//se aumenta tamanio
	}
        public int PULL() {
            int itnum=0;		
                        if (cabeza!= null) {//si no es null
                //si este nodo no es el ultimo
                if (cabeza.siguiente==null) {
                    itnum=cabeza.han.getnum();
                } else {//de lo contrario busca el ultimo
                    nodo puntero=cabeza;
                    while (puntero.siguiente!=null) {                    
                        puntero=puntero.siguiente;//encuentra el ultimo nodo 
                    }
                    itnum=puntero.han.getnum();//obtiene el valor que tiene ese nodo
                }
            }
                return itnum;//regresa dicho valor
	}

	public int contar() {
		return longitud;//envia la variable longitud, que contiene la cantidad
	}
        public boolean estaVacia() {
            return cabeza==null;//regresa datos si no regresa es por que esta vacia
        }
        public void POP() {
            if (cabeza!= null) {//si no es null
                //si este nodo no es el ultimo
                if (cabeza.siguiente==null) {
                    //regresa que ya lo hizo y hace null este nodo
                    cabeza=null;  
                    longitud--;
                } else {//de lo contrario busca el ultimo
                    nodo puntero=cabeza;
                    while (puntero.siguiente.siguiente!=null) {                    
                        puntero=puntero.siguiente;//encuentra el ultimo nodo y hace que el anterior apunto a null
                    }                    
                    puntero.siguiente=null;
                    longitud--;//se elimina uno del tamanio total
                }
            }
        }

        	public String visualizar() {//se inicializa las variables a necesitar
		String Dato="";                
		nodo aux=cabeza; 
                //verifica si esta vacia, o no, para regresar un mensaje
                if(null==aux){Dato="--------";}else{ 
		while (aux!=null)
		{                 
                //hasta que encuentre null no va a parar y guardar los datos en esa variable          
			Dato=Dato+aux.han.getnum()+"---";
			aux=aux.siguiente;
		}}
		return(Dato);//regresa lo que tiene la variabel
	}
                 public void Vaciar() { //hace que cabeza apunte a null para eliminar la lista             
             cabeza=null;
        }
}
