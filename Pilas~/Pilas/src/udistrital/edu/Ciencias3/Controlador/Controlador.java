package udistrital.edu.Ciencias3.Controlador;

import udistrital.edu.Ciencias3.Pilas.Pila;

public class Controlador {
	private Pila pila;
	
	public Controlador() {
		pila = new Pila();
	}
	
	public void AdicionarEntero(int valor) {
		pila.push(valor);
	}
	public int TamanoPila() {
		return pila.getTamano();
	}
	
	public int CantidadRepetidos() {
		return pila.Repetidos();
	}
	public double Promedio() {
		return pila.promedio();
	}
	public int RepeticionesValor(int valor) {
		return pila.buscar(valor);
	}
	public boolean PilaVacia() {
		return pila.esVacia();
	}
	public boolean isInteger(String numero){
	    try{
	        Integer.parseInt(numero);
	        return true;
	    }catch(NumberFormatException e){
	        return false;
	    }
	}
}
