package udistrital.edu.Ciencias3.Controlador;

import udistrital.edu.Ciencias3.Interfaz.Interfaz;

public class Principal {
	Controlador micontrolador;
	Interfaz miInterfaz;
	
	public static void main(String args[]) {
		Principal miprincipal = new Principal();
		miprincipal.Iniciar();
	}
	
	private void Iniciar() {
		micontrolador = new Controlador();
		miInterfaz = new Interfaz();
		
		miInterfaz.PonerControladorEnPanel(micontrolador);
		miInterfaz.setVisible(true);
	}
}
