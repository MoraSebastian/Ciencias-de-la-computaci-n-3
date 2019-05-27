package udistrital.edu.Ciencias3.Colas;
/**
 * Clase que define la Cola
 * Fecha: 15.04.19
 * @author Sebastián
 *
 */
public class Cola {
	/**
	 * Atributo que representa el comienzo de la cola
	 */
	private Nodo inicio;
	/**
	 * Atributo que representa el final de la cola
	 */
	private Nodo fin;
	/**
	 * Atributo que guarda el tamaño actual de la cola
	 */
	private int tamano;
	/**
	 * Atributo que determina si la cola esta abierta para ingresar datos en ella o no
	 */
	private boolean estado;
	/**
	 * Atributo que permite identificar la cola a la hora de hacer las operaciones de ordenación y eliminación
	 */
	private int id;
	/**
	 * Constructor	 
	 */	
	public Cola (){
		this.inicio = null;
		this.fin = null;
		this.tamano = 0;
		this.estado = true;
		
	}
	
	/**
	 * Método que se encarga de insertar elementos en la cola
	 */
	public void InsCola(int valor) {
		Nodo nuevo = new Nodo(valor);
		nuevo.setValor(valor);
		if(inicio == null) {
			inicio = nuevo;
		}else {
			fin.setSiguiente(nuevo);
		}
		this.tamano++;
		fin = nuevo;
	}
	/**
	 * Método que se encarga de sacar elementos de la cola
	 * @return Nodo que sale de la cola
	 */
	public Nodo AtenderCola() {	
		Nodo aux = null;		
		if(!ColaVacia()) {
			aux = inicio;
			inicio = aux.getSiguiente();
		}
		this.tamano--;
		return aux;		
	}
	/**
	 * Método que verifica si la cola esta vacia
	 * @return true si esta vacia, false si no lo esta
	 */
	public boolean ColaVacia() {
		return inicio == null;
	}
	/**
	 * Método que se encarga de eliminar la Cola 
	 */
	public void EliminarCola(){
		while(!ColaVacia()) {
			AtenderCola();
		}
	}
	//--------------------Getters y Setters--------------------------
	public Nodo getInicio() {
		return inicio;
	}	
	public Nodo getFin() {
		return fin;
	}	
	public int getTamano() {
		return tamano;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean nestado) {
		estado = nestado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}	
