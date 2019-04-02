package estructuralibros;
import javax.swing.JOptionPane;
/**
 * @author Ricardo Perez 1255
 */
public class menu {
     public static void main(String[]args){
         String stOp="",stAuto,stTitulo,stIsbn; int itOp=0,itDato;//variables auxiliar que reciben y envian datos
         //declaracion de los modulos
           Libro ld=new Libro("","","");
           Lista ls=new Lista(); 
         do{//menu
        stOp=JOptionPane.showInputDialog("Seleccione una opcion:\n"+"1) insertar al principio\n2) insertar al final"+
         "\n3) insertar despues de n\n4) obtener informacion"+"\n5) cantidad de datos en la lista\n6) vaciar"+"\n7) Eliminar el primero \n8) elimminar ultimo"+
          "\n9) Eliminar el n numero \n10) visualizar\n0) para salir ingrese 0");
        itOp=Integer.parseInt(stOp);//obtencion de menu a int
        switch(itOp){//cada uno de los casos propuestos en el menu
                case 1:
                     stAuto=(JOptionPane.showInputDialog("ingrese el autor"));stTitulo=(JOptionPane.showInputDialog("ingrese el titulo"));//se obtienen los datos en variables
                        stIsbn=(JOptionPane.showInputDialog("ingrese el isbn"));
                     ls.insertarPrincipio(new Libro(stTitulo,stAuto,stIsbn));        //se envia a listas con los datos para guardarlos                                                                 
                break;
                case 2:
                  stAuto=(JOptionPane.showInputDialog("ingrese el autor"));stTitulo=(JOptionPane.showInputDialog("ingrese el titulo"));//se obtienen los datos en variables
                        stIsbn=(JOptionPane.showInputDialog("ingrese el isbn"));
                     ls.insertarFinal(new Libro(stTitulo,stAuto,stIsbn));             //se envia a listas con los datos para guardarlos         
                break;
                case 3:   
                    stAuto=(JOptionPane.showInputDialog("ingrese el autor"));stTitulo=(JOptionPane.showInputDialog("ingrese el titulo"));//se obtienen los datos en variables
                        stIsbn=(JOptionPane.showInputDialog("ingrese el isbn"));
                      itDato=Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero del cual despues ingresar"));
                      ls.insertarDespues(itDato,new Libro(stTitulo,stAuto,stIsbn));   //se envia a listas con los datos para guardarlos
                break;
                case 4:
                     itDato=Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero del dato a obtener"));
                      JOptionPane.showMessageDialog(null,"EL dato es: "+ls.obtener(itDato));//se utiliza el metodo para obtener el dato
                break;
                case 5:
                    JOptionPane.showMessageDialog(null,"La cantidad en la lista es: "+ls.contar());//se pide que regrese la cantidad
                break;
                case 6:
                    ls.estaVacia();
                    JOptionPane.showMessageDialog(null,"lista vaciada");//ejecuta el void, para eliminar todos
                break;
                case 7:
                      ls.eliminaPrincipio();
                    JOptionPane.showMessageDialog(null,"Primero eliminado");// elimina el primero, con el metodo
                break;
                case 8:
                     ls.eliminarUltimo();
                    JOptionPane.showMessageDialog(null,"Ultimo eliminado");//elimina el utlimo con el metodo
                break;
                case 9:
                     itDato=Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero del dato a eliminar"));////se ingresa el n a eliminar
                     ls.eliminarLibro(itDato);//se envia el dato para que se eliminado
                      JOptionPane.showMessageDialog(null,"EL dato ah sido eliminado ");
                break;
                case 10:
                    ls.visualizar();//se llama al metodo para mostrar
                break;
                 case 0:
                break;
                default: break;
        }       
        System.out.println(ls.visualizar());//se muestra al finalizar siempre
         }while(itOp!=0);
    }
    
}
