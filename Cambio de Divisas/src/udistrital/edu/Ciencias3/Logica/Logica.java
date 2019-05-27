package udistrital.edu.Ciencias3.Logica;

public class Logica {
	private static double divisaxdefecto = 3280.80;	
	
	public double Convertir (double dolares ) {
		return dolares*divisaxdefecto;
	}
	public double Convertir (double dolares, double divisa) {
		return dolares*divisa;
	}	
}
