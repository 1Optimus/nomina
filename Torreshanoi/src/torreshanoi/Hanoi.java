package torreshanoi;
public class Hanoi {
    //se colocan todas las variables
	private int num;
	public Hanoi(int num) {
            //se obtienen las variables en variables locales
		this.num=num;		           
	}
	public int getnum() {//se envia el dato pedido
		return num;
	}
	public void setnum(int num) {//el dato se recibe y se guarda en una variable local
		this.num=num;  
        }
}
