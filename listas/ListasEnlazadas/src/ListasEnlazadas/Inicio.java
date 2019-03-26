package ListasEnlazadas;
import javax.swing.JOptionPane;
/**
 *  Ricardo Perez   1255
 */
public class Inicio {
    public static void main(String[] args) {
        ListasEnlazadas miLista=new ListasEnlazadas();
	miLista.InsertarEnPrimero(10);
	miLista.InsertarEnPrimero(15);
	miLista.InsertarEnPrimero(30);
	miLista.InsertarEnPrimero(50);
	miLista.InsertarEnPrimero(40);
	miLista.InsertarEnPrimero(60);
	System.out.println(miLista.Listar());
	System.out.println("---------------------------------------------------");
        System.out.println("La posicion de 10 es: "+miLista.localizarPosicion(10));//muestra en que posicion se encuntra el dato 10
        miLista.borrarPosicion(3);//borra el dato de la posicion 3
        System.out.println("Resultado:  "+miLista.borrarDato(40));//borra el dato que es iguala 40        
	System.out.println(miLista.Listar());//muestra la lista ya modificada
// TODO code application logic here
    }
    
}
