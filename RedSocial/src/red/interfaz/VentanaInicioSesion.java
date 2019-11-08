package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import red.modelo.Usuario;

import java.awt.Window.Type;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicioSesion extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNick;
	private JTextField txtNombre;
	private JPasswordField passwordField;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private VentanaAdministrador adm;


	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion(VentanaAdministrador adm) {
		this.adm = adm;
		setType(Type.UTILITY);
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(204, 11, 1, 229);
		panel.add(separator);
		
		JLabel lblNickname = new JLabel("Nickname :");
		lblNickname.setBounds(10, 27, 104, 14);
		panel.add(lblNickname);
		
		txtNick = new JTextField();
		txtNick.setBounds(20, 52, 140, 20);
		panel.add(txtNick);
		txtNick.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(215, 27, 82, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(225, 52, 165, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setBounds(111, 102, 89, 14);
		panel.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 127, 140, 20);
		panel.add(passwordField);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(25, 217, 89, 23);
		panel.add(btnCancelar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(305, 217, 89, 23);
		panel.add(btnAgregar);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAgregar)
		{
			Usuario u = new Usuario(txtNombre.getText(), passwordField.getText(), txtNick.getText());
			adm.registrarUsuario(u);
			JOptionPane.showMessageDialog(null, "El usuario "+u.getNombreUsuario()+" ha sido agregado");
			this.setVisible(false);
		}
		
		if(e.getSource() == btnCancelar)
		{
			this.setVisible(false);
		}
		
	}
}
