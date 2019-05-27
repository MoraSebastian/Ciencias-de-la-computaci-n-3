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

public class PanelCambioDivisa extends JPanel implements ActionListener{
	private JTextField tfTasa;
	private JTextField tfDolares;
	private JTextField tfPesos;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JButton btnConvertir;
	private Controlador micontrolador;
	private JButton btnLimpiar;
	
	public void setMicontrolador(Controlador micontrolador) {
		this.micontrolador = micontrolador;
	}

	/**
	 * Create the panel.
	 */
	public PanelCambioDivisa() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(5, 2, 0, 0));
		
		lbl1 = new JLabel("Escriba la equivalencia de un dolar en pesos COL");
		lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lbl1);
		
		tfTasa = new JTextField();
		tfTasa.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(tfTasa);
		tfTasa.setColumns(10);
		
		lbl2 = new JLabel("Escriba la cantidad de dolares a convertir");
		lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lbl2);
		
		tfDolares = new JTextField();
		tfDolares.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(tfDolares);
		tfDolares.setColumns(10);
		
		lbl3 = new JLabel("Cantidad convertida a pesos:");
		lbl3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lbl3);
		
		tfPesos = new JTextField();
		tfPesos.setEditable(false);
		tfPesos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(tfPesos);
		tfPesos.setColumns(10);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnConvertir.setBackground(Color.WHITE);
		btnConvertir.addActionListener(this);
		add(btnConvertir);
		
		lbl4 = new JLabel("Tasa por defecto: 1 dolar - 3,280.80 pesos");
		lbl4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lbl4);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnLimpiar.addActionListener(this);
		add(btnLimpiar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnConvertir) {
			String valor;
			if(tfDolares.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "La cantidad de dolares a convertir está vacía.", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
			if(tfTasa.getText().equals("") && !tfDolares.getText().equals("") 
					&& Verificardouble(tfDolares.getText())) {
				JOptionPane.showMessageDialog(null, "Si no especifica la tasa de cambio, la conversión se hará con la predeterminada",
													"Mensaje", JOptionPane.WARNING_MESSAGE);
				valor = String.valueOf(micontrolador.Convertir(Double.parseDouble(tfDolares.getText())));
				tfPesos.setText(valor);
			}
			if(!tfTasa.getText().equals("") && !tfDolares.getText().equals("")
					&& Verificardouble(tfTasa.getText()) && Verificardouble(tfDolares.getText())) {
				valor = String.valueOf(micontrolador.Convertir(Double.parseDouble(tfDolares.getText()), Double.parseDouble(tfTasa.getText())));
				tfPesos.setText(valor);
			}
		}
		if(e.getSource()==btnLimpiar) {
			tfTasa.setText("");
			tfDolares.setText("");
			tfPesos.setText("");
		}
	}
	
	public boolean Verificardouble(String valor) {
		try {
			Double.parseDouble(valor);
			return true;
		}catch(NumberFormatException excepcion){
			return false;
		}
	}
}
