package colas;
import javax.swing.JOptionPane;
/**
 * @author Ricardo Perez 1255
 * programa que controla una cola con lista enlazadas
 */
public class Menu {
     public static void main(String[]args){
         String stOp="",stAuto,stTitulo,stIsbn; int itOp=0,itDato;//variables auxiliar que reciben y envian datos
         //declaracion de los modulos           
           lista ls=new lista(); 
         do{//menu, se tienen todas las opcions
        stOp=JOptionPane.showInputDialog("Seleccione una opcion:\n"+"1) Insertar en la cola(QUEUE)"+
         "\n2)Eliminar de la cola(DEQUEUE)\n3) Cantidad de elementos en la cola\n4)¿Está vacia?"+
          "\n5) visualizar\n6) vaciar\n0) Para salir ingrese 0");
        itOp=Integer.parseInt(stOp);//obtencion de menu a int
        switch(itOp){//cada uno de los casos propuestos en el menu
                case 1:     
                    stAuto=(JOptionPane.showInputDialog("ingrese el autor"));stTitulo=(JOptionPane.showInputDialog("ingrese el titulo"));//se obtienen los datos en variables
                        stIsbn=(JOptionPane.showInputDialog("ingrese el isbn"));
                     ls.insertarFinal(new libro(stTitulo,stAuto,stIsbn));             //se envia a listas con los datos para guardarlos         
                break;
                case 2:
                     ls.eliminaPrincipio();
                    JOptionPane.showMessageDialog(null,"Dato eliminado");// elimina el primero, con el metodo
                break;
                case 3: 
                    JOptionPane.showMessageDialog(null,"La cantidad en la lista es: "+ls.contar());//se pide que regrese la cantidad
                break;
                case 4:                     
                    JOptionPane.showMessageDialog(null,"(false= con datos) (true= sin datos)\n estado: "+ls.estaVacia());//ejecuta el void, para eliminar todos
                break;
                case 5:    
                    ls.visualizar();//se llama al metodo para mostrar
                break;
                case 6:  
                     ls.Vaciar();//se llama para vaciar
                    JOptionPane.showMessageDialog(null,"Datos eliminados");
                break;               
                 case 0://se cambio la variable itOp a 0, eso hara que se salga
                break;
                default: break;
        }       
        System.out.println(ls.visualizar());//se muestra al finalizar siempre
         }while(itOp!=0);
    }
    
}
