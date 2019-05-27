package udistrital.edu.Ciencias3.Controlador;

import javax.swing.JTable;

import udistrital.edu.Ciencias3.conexionBD.Conexion;

public class Controlador {
	private Conexion conexion;
	
	public Controlador () {
		conexion = new Conexion();
	}
	public void AdicionarRegistro(String[] valores) {
		conexion.CrearRegistro(valores);
	}
	public void BorrarRegistro(int id) {
		conexion.BorrarRegistro(id);
	}
	public void Consultar(JTable tabla, int valor) {
		conexion.Consultar(tabla, valor);
	}
}
