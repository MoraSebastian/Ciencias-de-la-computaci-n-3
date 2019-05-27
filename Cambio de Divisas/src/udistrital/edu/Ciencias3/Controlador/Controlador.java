package udistrital.edu.Ciencias3.Controlador;

import udistrital.edu.Ciencias3.Logica.Logica;

public class Controlador {
	private Logica logica;
	
	public Controlador() {
		logica = new Logica();
	}
	
	public double Convertir(double dolares) {
		return logica.Convertir(dolares);
	}
	public double Convertir(double dolares, double divisa) {
		return logica.Convertir(dolares, divisa);
	}
}
