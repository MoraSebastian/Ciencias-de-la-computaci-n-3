package udistrital.edu.Ciencias3.Controlador;

import udistrital.edu.Ciencias3.Interfaz.Interfaz;

public class Principal {
	Controlador micontrolador;
	Interfaz miInterfaz;
	
	public static void main(String[] args) {
		Principal miPrincipal = new Principal();
		miPrincipal.Iniciar();
	}
	
	private void Iniciar() {
		miInterfaz = new Interfaz();
		micontrolador = new Controlador();
		
		miInterfaz.PonerControladorEnPanel(micontrolador);
		miInterfaz.setVisible(true);
	}
}
