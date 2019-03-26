package ListasEnlazadas;
public class ListasEnlazadas
{
    	Nodo Primero;
	public ListasEnlazadas()
	{
		Primero=null;
	}
	public boolean vacia()
	{
		if (Primero==null)
		{
			return(true);
		} else
		{
			return(false);
		}
	}
	public void InsertarEnPrimero(int Dato)
	{
		Nodo Temporal=new Nodo(Dato); //Crea el nodo temporal
		Temporal.Siguiente=Primero; //corre al primero
		Primero=Temporal;   //lo coloca de primero
	}
	public void borrarPrimero()
	{
		Primero=Primero.Siguiente;
	}
	public String Listar()
	{
		String Dato=" ";
		Nodo aux=Primero;
		while (aux!=null)
		{
			Dato+="{" + aux.info + "}";
			aux=aux.Siguiente;
		}
		return(Dato);
	}
	public void borrarUltimo()
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
		while (actual.Siguiente!=null)
		{
			anterior=actual;
			actual=actual.Siguiente;
		}
		anterior.Siguiente=null;
	}
	public void borrarPosicion(int pos)
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
		int k=0;
		if (pos>0)
		{
			while (k!=pos && actual.Siguiente != null)
			{
				anterior=actual;
				actual=actual.Siguiente;
				k++;
				System.out.println("K       "+k);
			}
			anterior.Siguiente=actual.Siguiente;
		}
	}
        public String localizarPosicion(int dato)//enseña la posicion en la que se encuentra tal dato
	{
		int Dato=0, Error=0;
                String Dat="";
		Nodo aux=Primero;
		while (aux!=null)
		{
                    if(dato==aux.info){
                    aux=null;
                    Dat=String.valueOf(Dato);
                    Error=5;
                    }else{
                    Dato++;
                    aux=aux.Siguiente;
                    } 
                    if((aux==null)&&(Error==0)){// si no llegara a existir tal dato
                    Dat="No esta en la lista";
                    }
		}
		return(Dat);
	}
        public String borrarDato(int dato)//borra de la lista el dato que se ingreso
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
                int Error=0;
                String dat="Dato eliminado con exito";
			while (actual.Siguiente != null)
			{
                            if(actual.info==dato){
                                Error=2;
                           break;
                            }else{
				anterior=actual;
				actual=actual.Siguiente; 
                            }
			}			
                        if(Error==0){//si no llegara a existir tal dato a eliminar
                        dat="Dato no existente";
                        }else{anterior.Siguiente=actual.Siguiente;}
                  return(dat);
	}
        

}
