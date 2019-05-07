package colas;

/**
 * @author Ricardo Perez 1255
 */
public class libro {
    //se colocan todas las variables
	private String sttitulo;
	private String stautor;
	private String stisbn;
	public libro(String titulo, String autor, String isbn) {
            //se obtienen las variables en variables locales
		this.sttitulo=titulo;
		this.stautor=autor;
		this.stisbn=isbn;               
	}
	public String getTitulo() {//se envia el dato pedido
		return sttitulo;
	}
	public void setTitulo(String titulo) {//el dato enviadose guarda en la variable local
		this.sttitulo=titulo;  
	}
	public String getAutor() {//se envia el dato pedido
		return stautor;	
	}
	public void setAutor(String autor) {//el dato enviadose guarda en la variable local
		this.stautor=autor;
	}
	public String getIsbn() {//se envia el dato pedido
		return stisbn;
	}
	public void setIsbn(String isbn) {//el dato enviadose guarda en la variable local
		this.stisbn=isbn;
	}

    }
