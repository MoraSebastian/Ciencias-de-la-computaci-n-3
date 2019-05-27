package udistrital.edu.Ciencias3.conexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Conexion {
	Connection conexion = null;
	String pass = "CualColoco";
	String user = "postgres";
	
	private void Conectar(){
		try {
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Tabla_de_Simbolos", user, pass);
			JOptionPane.showMessageDialog(null, "Estas conectado");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar.");
		}
	}

	
	public void CrearRegistro(String[] valores) {
		Conectar();
		PreparedStatement p = null;		
		String script = "insert into tabla_simbolos (identificador, tipo, declarada_en, referencias) values ('"
				+ valores[0] + "', '" + valores[1] + "', " +  Integer.parseInt(valores[2]) + ", '" + valores[3] + "');";
		System.out.println("Script: "+script);
		try {
			p = conexion.prepareStatement(script);
			p.executeUpdate();
		}catch(Exception e) {
			System.out.println("YUCA NO SE PUDO HACER EL REGISTRO");
		}
		Desconectar();
	}
	public void BorrarRegistro(int id) {
		Conectar();
		PreparedStatement p = null;		
		String script = "delete from tabla_simbolos where codigo = "+id+";";
		try {
			p = conexion.prepareStatement(script);
			p.executeUpdate();
		}catch(Exception e) {
			System.out.println("YUCA NO SE PUDO HACER EL BORRADO");
		}		
		Desconectar();
	}
	public void Consultar(JTable tabla, int valor) {
		Statement codigoSQL = null;
		ResultSet resultados = null;
		
		String script;
		if (valor == 0) {
			script = "Select codigo, identificador, tipo, declarada_en, referencias from tabla_simbolos;";
		}else {
			script = "Select codigo, identificador, tipo, declarada_en, referencias from tabla_simbolos where codigo = "+valor+";";
		}
		try {
			
			DefaultTableModel t = new DefaultTableModel();
			tabla.setModel(t);
			
			Conectar();
			codigoSQL = conexion.createStatement();			
			resultados = codigoSQL.executeQuery(script);
			ResultSetMetaData datos = resultados.getMetaData();
			
			int numeroColumnas = datos.getColumnCount();
			
			for (int i = 1; i <= numeroColumnas; i++) {
				t.addColumn(datos.getColumnLabel(i));
				//System.out.println("columa "+i+ " "+ datos.getColumnLabel(i));
			}
			while(resultados.next()) {
				Object [] f = new Object[numeroColumnas];
				for(int i = 0; i < numeroColumnas; i++) {
					f[i] = resultados.getObject(i+1);
				}
				t.addRow(f);				
			}
			codigoSQL.close();
			resultados.close();
			conexion.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void Desconectar() {
		conexion = null;	
	}
	 /**Permite retornar la conexión*/
	public Connection getConnection(){
	    return conexion;
	}	
}
