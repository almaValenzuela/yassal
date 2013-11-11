package yassal.ordenamiento.utilerias;

public class Nodo {

	private Integer elemento;	
	private Nodo siguiente;
	private Nodo anterior;
	private int posicion;
	
	public Nodo(Integer elemento, Nodo siguiente, int posicion) {
		this.elemento=elemento;
		this.siguiente=siguiente;
		this.posicion=posicion;
		this.anterior=null;
	}
	
	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	
	public Integer getElemento() {
		return elemento;
	}

	public void setElemento(Integer elemento) {
		this.elemento = elemento;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	

	
	
}
