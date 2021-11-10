package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import javax.swing.border.EmptyBorder;

public class VentanaPrincipal {

	private JFrame frmVentanaPrincipal;
	
	public VentanaPrincipal() {
		initialize();
	}


	public void mostrarVentana() {
		//frmVentanaPrincipal.setLocationRelativeTo(null);
		frmVentanaPrincipal.setVisible(true);
	}
	
	public void crearMenuSuperior(JPanel contentPane) {

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(panel);
		
		JTextPane txtpnAppVideo = new JTextPane();
		txtpnAppVideo.setEditable(false);
		txtpnAppVideo.setBackground(SystemColor.activeCaptionBorder);
		txtpnAppVideo.setForeground(Color.RED);
		txtpnAppVideo.setText("AppVideo");
		txtpnAppVideo.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 30));
		txtpnAppVideo.setToolTipText("AppVideo");
		panel.add(txtpnAppVideo);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setSize(new Dimension(20, 20));
		panel.add(separator_3);
		
		JSeparator separator_2 =new JSeparator();
		panel.add(separator_2);
		separator_2.setPreferredSize(new Dimension(100,0));
		
		JTextPane txtpnHolaUser = new JTextPane();
		txtpnHolaUser.setBackground(SystemColor.activeCaptionBorder);
		txtpnHolaUser.setEditable(false);
		txtpnHolaUser.setText("Hola, USUARIO"); //TODO -> sustituir USUARIO por el valor obtenido de Persistencia para usuario logeado
		panel.add(txtpnHolaUser);
		
		JSeparator separator_1 =new JSeparator();
		panel.add(separator_1);
		separator_1.setPreferredSize(new Dimension(100,0));
		
		JButton btnLogout = new JButton("Logout");
		panel.add(btnLogout);
	
		
		JButton btnNewButton = new JButton("\u00A1Hazte Premium!");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(178, 34, 34));
		panel.add(btnNewButton);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.setPreferredSize(new Dimension(150,35));
		contentPane.add(panel_1);
		
		JButton btnExplorar = new JButton("Explorar");
		panel_1.add(btnExplorar);

		
		JButton btnMisListas = new JButton("Mis Listas");
		panel_1.add(btnMisListas);

		
		JButton btnRecientes = new JButton("Recientes");
		panel_1.add(btnRecientes);

		
		JButton btnNuevaLista = new JButton("Nueva Lista");
		panel_1.add(btnNuevaLista);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(panel_2);
		
		JSeparator separator_4 = new JSeparator();
		panel_2.add(separator_4);
		separator_4.setPreferredSize(new Dimension(450, 250));
	

		frmVentanaPrincipal.pack();
	}
	
	public void initialize() {
		frmVentanaPrincipal = new JFrame();
		frmVentanaPrincipal.setTitle("AppVideo");
		frmVentanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaPrincipal.setResizable(false);
		frmVentanaPrincipal.setBounds(100, 100, 640, 480);
		
		JPanel contentPane = (JPanel) frmVentanaPrincipal.getContentPane();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		
		crearMenuSuperior(contentPane);

	}
}

