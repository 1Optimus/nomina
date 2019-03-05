package examen;
import javax.swing.JOptionPane;
/**
 * Ricardo Alejandro Perez Rodriguez 
 * Carnet 17-1255
 * Variante B
 */
public class Examen {
    //declaracion de las variables, la del promedio y la matriz
   static String vectNotas[][]=new String[3][10]; 
   static Double dbPromedio;
    //aca esta el metodo principal
    public static void main(String[] args) {
        //se declara la variable de opcion del while
       int itOpcion=1;
      do{
          //se llaman todos los metodos necesario, los metodos estan hasta abajo
      ingreso(vectNotas);
      sigano(vectNotas);
      dbPromedio= promedio(vectNotas);
      mostrar(vectNotas,dbPromedio);
      itOpcion=Integer.parseInt(JOptionPane.showInputDialog("ingrese 1 para volver a ingresar, 2 para salirse"));
      }while(itOpcion==1);
      //finalizacion del while y metodo principal
    }
    public static void ingreso(String[][] vectNotas){
        //metodo de ingreso y por medio de un for se llena la matriz, se esta pidiendo nota y nombre
    for(int i=0;i<=9;i++){
    vectNotas[0][i]=JOptionPane.showInputDialog(null,"ingrese nombre del alumno #"+(1+i));
    vectNotas[1][i]=JOptionPane.showInputDialog(null,"ingrese la nota del alumno #"+(1+i));
        }
    }
    public static Double promedio(String[][] vectNotas){
        //metodo de promedio, con un for se suma todo y en otra variable se divide y devuelve el valor
    Double dbPromedio,dbSuma=0.0;
    for(int i=0;i<=9;i++){    
        dbSuma=Double.parseDouble(vectNotas[1][i]);
        }
    dbPromedio=dbSuma/10;
    return dbPromedio;
    }
    public static void sigano(String[][] vectNotas){   
        //por medio de un for se verifican todas las notas, y se almacena si gano o no en una columna de la matriz
      Double dbDato;
    for(int i=0;i<=9;i++){    
       dbDato=Double.parseDouble(vectNotas[1][i]);
       //el condicional para guardar si gano o no
       if((dbDato>=61)&&(dbDato<=100)){
           vectNotas[2][i]="Gano";
       }else if((dbDato<=60)&&(dbDato>=0)){
       vectNotas[2][i]="Perdio";
       }else{ vectNotas[2][i]="nota no en rangos";}
     }
    }
    public static void mostrar(String[][] vectNotas, Double dbPromedio){
        //metodo para mostrar, se almacena todo en una variable y se muestra
        //tambien con paso de parametros se trae promedio y se muestra
    String stMostrar="";
    for(int i=0;i<=9;i++){
    stMostrar=stMostrar+vectNotas[0][i]+"\t"+vectNotas[1][i]+"\t"+vectNotas[2][i]+"\n";
        }
    System.out.println(stMostrar);
    System.out.println("el promedio es de:"+dbPromedio);
    }
}

