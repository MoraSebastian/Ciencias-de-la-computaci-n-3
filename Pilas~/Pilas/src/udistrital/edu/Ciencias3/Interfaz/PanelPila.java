package udistrital.edu.Ciencias3.Interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import udistrital.edu.Ciencias3.Controlador.Controlador;

import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class PanelPila extends JPanel implements ActionListener{
	private JTextField tfAdicionarEntero;
	private JTextField tfTamanoPila;
	private JTextField tfPromedio;
	private JTextField tfRepeticionesUnValor;
	private Controlador micontrolador;
	private ArrayList<JLabel> enteros = new ArrayList<JLabel>();
	private JButton btnAdicionarEntero, btnTamanoPila, btnPromedio, btnRepeticionesUnValor;
	/**
	 * Create the panel.
	 */
	public PanelPila() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pila de Enteros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblAdicionarEntero = new JLabel("Adicionar Entero");
		lblAdicionarEntero.setBounds(7, 16, 143, 38);
		lblAdicionarEntero.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		add(lblAdicionarEntero);
		
		tfAdicionarEntero = new JTextField();
		tfAdicionarEntero.setBounds(155, 16, 143, 38);
		tfAdicionarEntero.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(tfAdicionarEntero);
		tfAdicionarEntero.setColumns(10);
		
		btnAdicionarEntero = new JButton("Adicionar");
		btnAdicionarEntero.setBounds(303, 16, 143, 38);
		btnAdicionarEntero.setBackground(Color.WHITE);
		btnAdicionarEntero.setFont(new Font("Segoe UI", Font.PLAIN, 11));	
		btnAdicionarEntero.addActionListener(this);
		add(btnAdicionarEntero);
		
		JLabel lblTamaoDeLa = new JLabel("Tama\u00F1o de la Pila");
		lblTamaoDeLa.setBounds(7, 59, 143, 38);
		lblTamaoDeLa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lblTamaoDeLa);
		
		tfTamanoPila = new JTextField();
		tfTamanoPila.setBounds(155, 59, 143, 38);
		tfTamanoPila.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(tfTamanoPila);
		tfTamanoPila.setColumns(10);
		
		btnTamanoPila = new JButton("Obtener Tama\u00F1o");
		btnTamanoPila.setBounds(303, 59, 143, 38);
		btnTamanoPila.setBackground(Color.WHITE);
		btnTamanoPila.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnTamanoPila.addActionListener(this);
		add(btnTamanoPila);
		
		JLabel lblPromedio = new JLabel("Promedio");
		lblPromedio.setBounds(7, 108, 143, 38);
		lblPromedio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lblPromedio);
		
		tfPromedio = new JTextField();
		tfPromedio.setBounds(155, 108, 143, 38);
		tfPromedio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(tfPromedio);
		tfPromedio.setColumns(10);
		
		btnPromedio = new JButton("Obtener Promedio");
		btnPromedio.setBounds(303, 108, 143, 38);
		btnPromedio.setBackground(Color.WHITE);
		btnPromedio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnPromedio.addActionListener(this);
		add(btnPromedio);
		
		JLabel lblRepeticionesUnValor = new JLabel("Repeticiones de un Valor");
		lblRepeticionesUnValor.setBounds(7, 151, 143, 38);
		lblRepeticionesUnValor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lblRepeticionesUnValor);
		
		tfRepeticionesUnValor = new JTextField();
		tfRepeticionesUnValor.setBounds(155, 151, 143, 38);
		tfRepeticionesUnValor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(tfRepeticionesUnValor);
		tfRepeticionesUnValor.setColumns(10);
		
		btnRepeticionesUnValor = new JButton("Obtener Repeticiones");
		btnRepeticionesUnValor.setBounds(303, 151, 143, 38);
		btnRepeticionesUnValor.setBackground(Color.WHITE);
		btnRepeticionesUnValor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRepeticionesUnValor.addActionListener(this);
		add(btnRepeticionesUnValor);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdicionarEntero) {
			if(micontrolador.isInteger(tfAdicionarEntero.getText())) {
				JLabel lblEntero = new JLabel("");
				lblEntero.setBounds(480, 212 - 18*(enteros.size()), 25, 15);
				add(lblEntero);
				lblEntero.setText(tfAdicionarEntero.getText());
				
				enteros.add(lblEntero);
				micontrolador.AdicionarEntero(Integer.parseInt(tfAdicionarEntero.getText()));
				tfAdicionarEntero.setText("");
				tfTamanoPila.setText("");
				tfPromedio.setText("");
				tfRepeticionesUnValor.setText("");
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese un Entero", "Mensaje", JOptionPane.WARNING_MESSAGE);
				tfAdicionarEntero.setText("");
			}
		}
		if(e.getSource() == btnTamanoPila) {
			tfTamanoPila.setText(Integer.toString(micontrolador.TamanoPila()));
		}
		if(e.getSource() == btnPromedio) {
			if(micontrolador.PilaVacia()) {
				tfPromedio.setText("No hay valores");
			}else {
				tfPromedio.setText(String.valueOf(micontrolador.Promedio()));
			}
		}
		if(e.getSource() == btnRepeticionesUnValor) {
			if(!tfRepeticionesUnValor.getText().equals("") && micontrolador.isInteger(tfRepeticionesUnValor.getText())) {
				JOptionPane.showMessageDialog(null, "El valor" + tfRepeticionesUnValor.getText() + 
						" se encuentra "+micontrolador.RepeticionesValor(Integer.parseInt(tfRepeticionesUnValor.getText()))
						, "Mensaje", JOptionPane.WARNING_MESSAGE);
				tfRepeticionesUnValor.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese un entero", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}						
		}
	}
	public void setMicontrolador(Controlador micontrolador) {
		this.micontrolador = micontrolador;
	}
}
