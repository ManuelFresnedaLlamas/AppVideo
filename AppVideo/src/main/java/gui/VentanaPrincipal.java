package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import pulsador.IEncendidoListener;
import pulsador.Luz;

public class VentanaPrincipal {

	private JFrame frmVentanaPrincipal;
	private JTextField txtTituloVideo;
	private JTextField textBuscarTitulo;
	private JTable table;
	Luz luz = new Luz();
	 String color = "rojo";
	 private JTextArea textArea;
	

	public VentanaPrincipal() {
		initialize();

	}


	public void mostrarVentana() {
		//frmVentanaPrincipal.setLocationRelativeTo(null);
		frmVentanaPrincipal.setVisible(true);
	}
	
	public void crearMenuSuperior(final JPanel contentPane) {

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
		txtpnHolaUser.setText("¡Hola, " + Controlador.getUnicaInstancia().getUsuarioActual().getNombre() + "!");
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
		
		
		JPanel panelMenuSuperior = new JPanel();
		panelMenuSuperior.setBackground(new Color(255, 0, 0));
		panelMenuSuperior.setLayout(new BoxLayout(panelMenuSuperior, BoxLayout.X_AXIS));
		panelMenuSuperior.setPreferredSize(new Dimension(150,35));
		contentPane.add(panelMenuSuperior);
		
		JButton btnExplorar = new JButton("Explorar");
		panelMenuSuperior.add(btnExplorar);
		btnExplorar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				crearVentanaExplorar(contentPane);
			}
		});

		
		JButton btnMisListas = new JButton("Mis Listas");
		panelMenuSuperior.add(btnMisListas);

		
		JButton btnRecientes = new JButton("Recientes");
		panelMenuSuperior.add(btnRecientes);

		
		JButton btnNuevaLista = new JButton("Nueva Lista");
		panelMenuSuperior.add(btnNuevaLista);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(SystemColor.activeCaptionBorder);
		separator_4.setPreferredSize(new Dimension(0,10));
		frmVentanaPrincipal.getContentPane().add(separator_4);

		
		
		frmVentanaPrincipal.pack();
	}
	
	public void crearVentanaExplorar(JPanel contentPane){

		JPanel panelExplorar = new JPanel();
		panelExplorar.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(panelExplorar);
		panelExplorar.setLayout(new BoxLayout(panelExplorar, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panelExplorar.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panelBuscarTitulo = new JPanel();
		panelBuscarTitulo.setLayout(new BoxLayout(panelBuscarTitulo, BoxLayout.X_AXIS));
		panel_1.add(panelBuscarTitulo);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setPreferredSize(new Dimension(40,0));
		panelBuscarTitulo.add(separator_6);
		
		JLabel lblBuscarTitulo = new JLabel("Buscar título:");
		panelBuscarTitulo.add(lblBuscarTitulo);
		
		textBuscarTitulo = new JTextField();
		panelBuscarTitulo.add(textBuscarTitulo);
		textBuscarTitulo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(40,0));
		panelBuscarTitulo.add(separator);
		
		JButton botonBuscarTitulos = new JButton("Buscar");
		panelBuscarTitulo.add(botonBuscarTitulos);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setPreferredSize(new Dimension(40,0));
		panelBuscarTitulo.add(separator_5);
		
		JPanel panelVideos = new JPanel();
		panel_1.add(panelVideos);
		
		table = new JTable();
		panelVideos.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2,BoxLayout.Y_AXIS));
		panelExplorar.add(panel_2);
		
		
		JLabel lblEtiquetasDisponibles = new JLabel("Etiquetas disponibles:");
		panel_2.add(lblEtiquetasDisponibles);
		
		JList listaEtiquetas = new JList();
		panel_2.add(listaEtiquetas);
		
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
		
		
		frmVentanaPrincipal.getContentPane().add(luz);
		luz.setColor(Color.RED);
		

		
		 luz.addEncendidoListener(new IEncendidoListener() {
			 public void enteradoCambioEncendido(EventObject e) {
				 cambioBoton(0);
			 }
		 });
		 
		 
		
	}
	
	private void cambioBoton(int n){
		JButton btnNewButton_1 = new JButton("Añadir canciones XML");
		frmVentanaPrincipal.getContentPane().add(btnNewButton_1);
		frmVentanaPrincipal.pack();
		frmVentanaPrincipal.repaint();
	}
}

