package udistrital.edu.Ciencias3.Controlador;


import udistrital.edu.Ciencias3.Colas.Logica;


public class Controlador {

	private Logica logica;	
	
	public Controlador() {
		
		logica = new Logica();
	}
	// -----------------------------------------------------
	
	
	public void setLofica(Logica logica) {
		this.logica = logica;
	}
	
	
	public int AgregarCliente() {		
		return logica.AgregarCliente();
	}
	public int AgregarCliente(int cliente) {
		return logica.AgregarCliente(cliente);
	}
	public void AtenderCliente(int id) {
		logica.AtenderCliente(id);
	}
	public void CerrarCola(int id) {
		logica.CerrarCola(id);
	}
	public void AbrirCola(int id) {
		logica.AbrirCola(id);
	}
}
