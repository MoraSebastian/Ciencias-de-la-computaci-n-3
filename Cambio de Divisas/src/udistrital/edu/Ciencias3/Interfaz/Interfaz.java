package udistrital.edu.Ciencias3.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import udistrital.edu.Ciencias3.Controlador.Controlador;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private PanelCambioDivisa panel;

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	public void PonerControladorEnPanel(Controlador micontrolador) {
		panel = new PanelCambioDivisa();
		panel.setMicontrolador(micontrolador);
		contentPane.add(panel, BorderLayout.CENTER);
	}
}
