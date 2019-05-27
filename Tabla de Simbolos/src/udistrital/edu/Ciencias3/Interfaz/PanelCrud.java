package udistrital.edu.Ciencias3.Interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import udistrital.edu.Ciencias3.Controlador.Controlador;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class PanelCrud extends JPanel implements ActionListener{
	private Controlador micontrolador;
	private JTextField tfIdentificador;
	private JTextField tfTipo;
	private JTextField tfDeclarada;
	private JTextField tfReferencias;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JButton btnImprimir;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelCrud() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblIdentificador = new JLabel("Identificador:");
		lblIdentificador.setBounds(0, 1, 265, 44);
		lblIdentificador.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(lblIdentificador);
		
		tfIdentificador = new JTextField();
		tfIdentificador.setBounds(265, 1, 265, 44);
		tfIdentificador.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(tfIdentificador);
		tfIdentificador.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(0, 45, 265, 44);
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(lblTipo);
		
		tfTipo = new JTextField();
		tfTipo.setBounds(265, 45, 265, 44);
		tfTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(tfTipo);
		tfTipo.setColumns(10);
		
		JLabel lblLineaDondeFue = new JLabel("Linea donde fue declarada: ");
		lblLineaDondeFue.setBounds(0, 89, 265, 44);
		lblLineaDondeFue.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(lblLineaDondeFue);
		
		tfDeclarada = new JTextField();
		tfDeclarada.setBounds(265, 89, 265, 44);
		tfDeclarada.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(tfDeclarada);
		tfDeclarada.setColumns(10);
		
		String texto = "<html><body>Referencias (lineas donde se encuentra) <br> poner número separado por comas sin espacio <br>ej: 11,22  </body></html>";
		JLabel lblNewLabel = new JLabel(texto);
		lblNewLabel.setBounds(0, 133, 265, 44);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		add(lblNewLabel);
		
		tfReferencias = new JTextField();
		tfReferencias.setBounds(265, 133, 265, 44);
		tfReferencias.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(tfReferencias);
		tfReferencias.setColumns(10);
		
		btnAgregar = new JButton("Adicionar");
		btnAgregar.setBounds(0, 177, 265, 44);
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(btnAgregar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(265, 177, 265, 44);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(btnBuscar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(0, 221, 265, 44);
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.addActionListener(this);
		btnBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(btnBorrar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(265, 221, 265, 44);
		btnImprimir.setBackground(Color.WHITE);
		btnImprimir.addActionListener(this);
		btnImprimir.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(btnImprimir);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 286, 510, 197);
		add(table);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnAgregar) {
			String[] valores = new String[4];
			if(tfIdentificador.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No ha escrito el identificador.", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
			if(tfTipo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No ha escrito el tipo correspondiente al identificador.", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
			if(tfDeclarada.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No ha escrito en que linea se declaro.", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
			if (!tfIdentificador.getText().equals("") && !tfTipo.getText().equals("") &&!tfDeclarada.getText().equals("")) {
				valores[0] = tfIdentificador.getText();
				valores[1] =tfTipo.getText();
				valores[2] =tfDeclarada.getText();
				valores[3] =tfReferencias.getText();
				
				micontrolador.AdicionarRegistro(valores);
				JOptionPane.showMessageDialog(null, "Se ha hecho la inserción en la base de datos.", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}					
		}
		if(e.getSource()==btnBuscar) {
			micontrolador.Consultar(table, Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo de la fila que desea buscar:")));
		}
		if(e.getSource()==btnBorrar) {
			micontrolador.BorrarRegistro(Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo de la fila que desea borrar:")));
		}
		if(e.getSource()==btnImprimir) {
			micontrolador.Consultar(table, 0);
		}
	}
	public void setMicontrolador(Controlador micontrolador) {
		this.micontrolador = micontrolador;
	}
}
