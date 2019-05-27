package udistrital.edu.Ciencias3.Interfaz;

import javax.swing.JPanel;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import udistrital.edu.Ciencias3.Controlador.Controlador;
public class PanelCajas extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private Controlador micontrolador;	
	private JButton btnAtenderC1, btnAtenderC2,btnAtenderC3, btnAgregarCliente;	
	private ArrayList<JLabel> clientesC1 = new ArrayList<JLabel>();
	private ArrayList<JLabel> clientesC2 = new ArrayList<JLabel>();
	private ArrayList<JLabel> clientesC3 = new ArrayList<JLabel>();
	
	String path = "/udistrital/edu/Ciencias3/imagenes/ClienteH.png";  
	java.net.URL url = this.getClass().getResource(path);  
	ImageIcon icon = new ImageIcon(url);  	
	
	String path2 = "/udistrital/edu/Ciencias3/imagenes/ClienteM.png";  
	java.net.URL url2 = this.getClass().getResource(path2);  
	ImageIcon icon2 = new ImageIcon(url2);  	
	
	public PanelCajas() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblCajero1 = new JLabel("");
		lblCajero1.setBounds(10, 51, 190, 190);
		add(lblCajero1);
		
		JLabel lblCajero2 = new JLabel("");
		lblCajero2.setBounds(230, 51, 190, 190);
		add(lblCajero2);
		
		JLabel lblCajero3 = new JLabel("");
		lblCajero3.setBounds(450, 51, 190, 190);
		add(lblCajero3);
		
		String path = "/udistrital/edu/Ciencias3/imagenes/cashier.png";  
		java.net.URL url = this.getClass().getResource(path);  
		ImageIcon icon = new ImageIcon(url);  		  	
		lblCajero1.setIcon(icon);
		lblCajero2.setIcon(icon);
		lblCajero3.setIcon(icon);
		
		btnAtenderC1 = new JButton("ATENDER");
		btnAtenderC1.addActionListener(this);
		btnAtenderC1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAtenderC1.setBackground(Color.WHITE);
		btnAtenderC1.setBounds(62, 245, 90, 25);
		add(btnAtenderC1);
		
		btnAtenderC2 = new JButton("ATENDER");
		btnAtenderC2.addActionListener(this);
		btnAtenderC2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAtenderC2.setBackground(Color.WHITE);
		btnAtenderC2.setBounds(280, 245, 90, 25);
		add(btnAtenderC2);
		
		btnAtenderC3 = new JButton("ATENDER");
		btnAtenderC3.addActionListener(this);
		btnAtenderC3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAtenderC3.setBackground(Color.WHITE);
		btnAtenderC3.setBounds(504, 247, 90, 25);
		add(btnAtenderC3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(191, 285, 47, 260);
		add(verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(417, 285, 47, 260);
		add(verticalStrut_1);
		
		btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.addActionListener(this);		
		btnAgregarCliente.setBackground(Color.WHITE);
		btnAgregarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAgregarCliente.setBounds(10, 8, 142, 32);
		add(btnAgregarCliente);
								
	}
	
	public void setMicontrolador(Controlador micontrolador) {
		this.micontrolador = micontrolador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAtenderC1) {	
			if(clientesC1.size() > 0) {
				micontrolador.AtenderCliente(1);
				clientesC1.get(0).setVisible(false);
				clientesC1.remove(0);				
				for(int i = 0; i < clientesC1.size(); i++) {
					clientesC1.get(i).setBounds(50, 285 + 110*i, 100, 100);
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay clientes para atender", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
			
		}			
		if(e.getSource()==btnAtenderC2) {			
			if(clientesC2.size() > 0) {
				micontrolador.AtenderCliente(2);
				clientesC2.get(0).setVisible(false);
				clientesC2.remove(0);				
				for(int i = 0; i < clientesC2.size(); i++) {
					clientesC2.get(i).setBounds(280, 285 + 110*i, 100, 100);
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay clientes para atender", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
		}			
		if(e.getSource()==btnAtenderC3) {			
			if(clientesC3.size() > 0) {
				micontrolador.AtenderCliente(3);
				clientesC3.get(0).setVisible(false);
				clientesC3.remove(0);				
				for(int i = 0; i < clientesC3.size(); i++) {
					clientesC3.get(i).setBounds(504, 285 + 110*i, 100, 100);
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay clientes para atender", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
		}			
		if(e.getSource()==btnAgregarCliente) {			
			int colamenor = micontrolador.AgregarCliente();			
			JLabel lblCliente = new JLabel("");			
			switch(colamenor) {
			case 1:
				lblCliente.setBounds(50, 285 + 110*(clientesC1.size()), 100, 100);
				add(lblCliente);				
				lblCliente.setIcon(ObtenerImagCliente(GenerarAleatorio()));
				clientesC1.add(lblCliente);
				break;
			case 2:
				lblCliente.setBounds(280, 285 + 110*(clientesC2.size()), 100, 100);
				add(lblCliente);
				lblCliente.setIcon(ObtenerImagCliente(GenerarAleatorio()));
				clientesC2.add(lblCliente);
				break;
			case 3:
				lblCliente.setBounds(504, 285 + 110*(clientesC3.size()), 100, 100);
				add(lblCliente);
				lblCliente.setIcon(ObtenerImagCliente(GenerarAleatorio()));
				clientesC3.add(lblCliente);
				break;
			}
		}
	}
	/**
	 * Función que retorna un entero aleatorio entre 1 y 2 
	 * @return
	 */
	public int GenerarAleatorio() {
		return ( (int) (Math.random() * 2) + 1);
	}
	public ImageIcon ObtenerImagCliente(int num) {
		if(num == 1) {
			return icon;
		}
		return icon2;
	}
}
