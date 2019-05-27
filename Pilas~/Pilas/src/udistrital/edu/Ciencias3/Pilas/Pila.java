package udistrital.edu.Ciencias3.Pilas;

import java.util.ArrayList;



/**
 *Clase que define la pila
 * Fecha: 14.4.19
 * @author anfer
 *
 */
public class Pila {

	/**
	 * Atributo que representa el inicio de la pila
	 */
	private Nodo inicio;
	
	/**
	 * Atributo que representa el total de elementos que hay en la pila
	 */
	private int tamano;
	
	/**
	 * Constructor por defecto
	 */
	public Pila() {
		this.inicio = null;
		this.tamano = 0;
	}
	
	/**
	 * Método que se asegura si la lista está vacia
	 * @return true si está vacia, false si no lo está
	 */
	public boolean esVacia() {
		return inicio == null;
	}

	/**
	 * Método que permite agregar un nuevo elemento a la pila
	 * @param valor Valor del elemento que se va a agregar.
	 */
	public void push(int valor) {
		Nodo nuevo = new Nodo(valor);
		
		if(esVacia()) {
			inicio = nuevo;
		}else {
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
		}
		tamano++;
	}
	
	/**
	 * Método que permite retirar un elemento de la pila
	 * @return Nodo que sale de la pila.
	 */
	public Nodo pop() {
		Nodo sale = null;
		if(!esVacia()) {
			sale = inicio;
			inicio = inicio.getSiguiente();
			tamano--;
		}
		return sale;
	}
	
	/**
	 * Método que muestra el elemento que se encuentra en el tope de la pila
	 * @return El valor del tope de la pila
	 * @throws Exception Si la pila está vacía
	 */
	public int tope() throws Exception {
		if(!esVacia()) {
			return inicio.getValor();
		}else throw new Exception("La pila se encuentra Vacia");
	}
	
	/**
	 * Método que permite saber cuántas veces está repetido un elemento
	 * @param valor Valor a buscar
	 * @return Cantidad de veces que está repetiodo
	 */
	public int buscar(int valor) {
		int esta = 0;
		
		// copia de la pila
		Nodo aux = inicio;
	
		//Buscamos el valor
		while(aux != null) {
			if(valor == aux.getValor()) {
			esta++;
			}
			aux = aux.getSiguiente();
		}
		return esta;
	}
	
	public int Repetidos() {				
		Nodo aux = inicio;
		int [] array = new int[getTamano()];
		int i;
		for (i = 0; i < getTamano(); i++) {
			array[i] = aux.getValor();
			aux = aux.getSiguiente();
		}
		array = OrdenamientoSeleccion(array);				
		int repunvalor = 0;		
		ArrayList<Integer> arrayL = new ArrayList<Integer>();		
		for (i = 1; i < array.length-1; i++) {
			if(array[i-1] != array[i]) {		
				if(repunvalor > 0) {
					arrayL.add(repunvalor);
					repunvalor = 0;
				}
				
			}else {
				System.out.println("repunvalor: "+repunvalor);
				repunvalor++;
			}			
		}		
		return arrayL.size();	
	}
	public double promedio() {
		double suma = 0;
		//Copia de la pila
		Nodo aux = inicio;
		while(aux != null) {
			suma += aux.getValor();
			aux = aux.getSiguiente();
		}
		return (double)(suma/tamano);
	}
	//GETTERS Y SETTERS
	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public int getTamano() {
		return tamano;
	}
	
	public int[] OrdenamientoSeleccion(int [] array) {
		int temp;
		int  i, j;		
		for(i = 1; i < array.length; i++) {
			j = i;
			temp = array[j];			
			while((j > 0) && (array[j-1] > temp)  ) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;			
		}	
		return array;
	}
	
}
