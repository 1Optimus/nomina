package pilas;
public class Libro {
    //se colocan todas las variables
	private String titulo;
	private String autor;
	private String isbn;
	public Libro(String titulo, String autor, String isbn) {
            //se obtienen las variables en variables locales
		this.titulo=titulo;
		this.autor=autor;
		this.isbn=isbn;               
	}
	public String getTitulo() {//se envia el dato pedido
		return titulo;
	}
	public void setTitulo(String titulo) {//el dato enviadose guarda en la variable local
		this.titulo=titulo;  
	}
	public String getAutor() {//se envia el dato pedido
		return autor;	
	}
	public void setAutor(String autor) {//el dato enviadose guarda en la variable local
		this.autor=autor;
	}
	public String getIsbn() {//se envia el dato pedido
		return isbn;
	}
	public void setIsbn(String isbn) {//el dato enviadose guarda en la variable local
		this.isbn=isbn;
	}
}
