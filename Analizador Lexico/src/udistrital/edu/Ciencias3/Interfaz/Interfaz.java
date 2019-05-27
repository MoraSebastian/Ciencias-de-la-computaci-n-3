package udistrital.edu.Ciencias3.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import udistrital.edu.Ciencias3.Controlador.Controlador;

import java.awt.GridLayout;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private PAnalizadorLexico panel;

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 157);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
						
	}
	
	public void PonerControladorEnPanel(Controlador micontrolador) {
		panel = new PAnalizadorLexico();
		panel.setMicontrolador(micontrolador);
		contentPane.add(panel, BorderLayout.CENTER);
	}
}
