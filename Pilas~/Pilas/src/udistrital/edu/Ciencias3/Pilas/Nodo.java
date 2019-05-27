package udistrital.edu.Ciencias3.Pilas;
/**
 *Clase que define los elementos de la pila
 * Fecha: 14.4.19
 * @author anfer
 *
 */
public class Nodo {

	/**
	 * Variable de tipo entero que guardará el valor del dato
	 */
	private int valor;
	
	/**
	 * Variable de tipo nodo que muestra el siguiente elemento en la lista
	 */
	private Nodo siguiente;
	
	/**
	 * Constructor del nodo
	 * @param valor valor del nodo que se crea
	 */
	public Nodo(int valor) {
		this.valor = valor;
		this.siguiente = null;
	}

	//GETTERS Y SETTERS
	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
