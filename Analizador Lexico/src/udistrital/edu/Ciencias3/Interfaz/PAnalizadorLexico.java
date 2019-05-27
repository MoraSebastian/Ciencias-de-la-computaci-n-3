package udistrital.edu.Ciencias3.Interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import udistrital.edu.Ciencias3.Controlador.Controlador;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class PAnalizadorLexico extends JPanel implements ActionListener{
	private JTextField tfExpresiones;
	private JButton btnAnalizar ;	
	private Controlador micontrolador;
	private JButton btnLimpiar;
	/**
	 * Create the panel.
	 */
	public PAnalizadorLexico() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblIngreseLasExpresiones = new JLabel("<html><body>Ingrese las expresiones regulares <br> separadas por espacios <br>ej: 11 22 cont  </body></html>");
		lblIngreseLasExpresiones.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lblIngreseLasExpresiones);
		
		tfExpresiones = new JTextField();
		tfExpresiones.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(tfExpresiones);
		tfExpresiones.setColumns(10);
		
		btnAnalizar = new JButton("Analizar");
		btnAnalizar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAnalizar.setBackground(Color.WHITE);
		btnAnalizar.addActionListener(this);
		add(btnAnalizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(btnLimpiar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAnalizar) {
			if(tfExpresiones.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar algo",
						"Mensaje", JOptionPane.WARNING_MESSAGE);
			}else {
				if(tfExpresiones.getText().substring(0, 1) == " ") {
					JOptionPane.showMessageDialog(null, "Debe empezar directamente con las expresiones, no con espacios",
							"Mensaje", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, micontrolador.Analizar(tfExpresiones.getText()),
							"Mensaje", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
		if(e.getSource()==btnLimpiar) {
			tfExpresiones.setText("");
		}
	}
	public void setMicontrolador(Controlador micontrolador) {
		this.micontrolador = micontrolador;
	}
}
