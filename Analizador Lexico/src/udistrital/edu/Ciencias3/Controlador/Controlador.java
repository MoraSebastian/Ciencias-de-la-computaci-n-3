package udistrital.edu.Ciencias3.Controlador;

import udistrital.edu.Ciencias3.Logica.Logica;

public class Controlador {
	private Logica logica;
	
	public Controlador() {
		logica = new Logica();
	}
	
	public String Analizar(String cadena) {
		return logica.Analizar(cadena);
	}
}
