package udistrital.edu.Ciencias3.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import udistrital.edu.Ciencias3.Controlador.Controlador;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private PanelPila panelPila;
	
	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
	}
	public void PonerControladorEnPanel(Controlador micontrolador) {
		panelPila = new PanelPila();
		panelPila.setMicontrolador(micontrolador);		
		contentPane.add(panelPila, BorderLayout.CENTER);
	}
}
