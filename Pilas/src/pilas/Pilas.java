package pilas;
//Ricardo Perez 1255       programa que gestiona una pila
import javax.swing.JOptionPane;
public class Pilas {
    public static void main(String[] args) {
        String stOp="",stAuto,stTitulo,stIsbn; int itOp=0,itDato;//variables auxiliar que reciben y envian datos
         //declaracion de los modulos
           Libro ld=new Libro("","","");
           Nodo ls=new Nodo(); 
         do{//menu
        stOp=JOptionPane.showInputDialog("Seleccione una opcion:\n"+"1)PUSH\n2) POP"+
         "\n3) TOP\n4) ¿Esta vacia?"+"\n5) Visualizar datos\n6) Eliminar pila \n0) Salir");
        itOp=Integer.parseInt(stOp);//obtencion de menu a int
        switch(itOp){//cada uno de los casos propuestos en el menu en switch                                   
                case 1:
                    stAuto=(JOptionPane.showInputDialog("ingrese el autor"));stTitulo=(JOptionPane.showInputDialog("ingrese el titulo"));//se obtienen los datos en variables
                        stIsbn=(JOptionPane.showInputDialog("ingrese el isbn"));
                     ls.PUSH(new Libro(stTitulo,stAuto,stIsbn));   //se envian los datos para que sean guardados  
                    break;
                case 2:
                     ls.POP();//llama el metodo pop para eliminar el ultimo ingresado
                    JOptionPane.showMessageDialog(null,"Ultimo eliminado");//elimina el utlimo con el metodo
                break;                         
                case 3:      
                     System.out.println("El libro que esta en TOP es "+ls.TOP());  //muestra un mensaje con el metodo de mostrar el primero en la pial                    
                break;
                 case 4:
                    JOptionPane.showMessageDialog(null,""+ls.estaVacia());//manda a llamar el metodo en donde le dice si esta vacia o no
                break;
                 case 5:// como siempre muestra los datos no tiene que hacer nada esta opcion                     
                break;
                case 6:
                     ls.Vaciar();//se llama metodo para vaciar y se muestra un mensaje
                    JOptionPane.showMessageDialog(null,"Datos eliminados");
                break;               
                case 0:
                     itOp=0;//cero para que se salga del while
                break;
                default: JOptionPane.showMessageDialog(null,"Opcion no valida"); break;
        }       
        System.out.println(ls.visualizar());//se muestra al finalizar siempre
         }while(itOp!=0);
    }
    
}
