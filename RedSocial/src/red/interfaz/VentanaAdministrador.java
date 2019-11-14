package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import red.modelo.Red;
import red.modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class VentanaAdministrador extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Red red;
	private JButton btnAgregarUsuario;
	private JButton btnAdministrarRed;
	private JButton btnSalir;

	/**
	 * Create the frame.
	 */
	public VentanaAdministrador(Red red) {
		this.red = red;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienveidoAdministradorPor = new JLabel("Bienvenido administrador, por favor seleccione una opcion :");
		lblBienveidoAdministradorPor.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblBienveidoAdministradorPor.setBounds(10, 26, 414, 14);
		contentPane.add(lblBienveidoAdministradorPor);
		
		btnAgregarUsuario = new JButton("Agregar Usuario");
		btnAgregarUsuario.addActionListener(this);
		btnAgregarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregarUsuario.setBounds(53, 100, 136, 23);
		contentPane.add(btnAgregarUsuario);
		
		btnAdministrarRed = new JButton("Administrar Red");
		btnAdministrarRed.addActionListener(this);
		btnAdministrarRed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdministrarRed.setBounds(239, 100, 136, 23);
		contentPane.add(btnAdministrarRed);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalir.setBounds(350, 227, 74, 23);
		contentPane.add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAgregarUsuario)
		{
			VentanaInicioSesion agregar = new VentanaInicioSesion(this);
			agregar.setVisible(true);
		}
		
		if(e.getSource() == btnAdministrarRed)
		{
			if(red.isVacio())
			{
				VentanaAlerta alerta = new VentanaAlerta("Aun no hay usuarios agregados");
				alerta.setVisible(true);
			}else
			{
				VentanaPrincipal principal = new VentanaPrincipal(this);
				principal.setVisible(true);
				this.setVisible(false);
			}

			
		}
		
		if(e.getSource() == btnSalir)
		{
			this.setVisible(false);
		}
	}
	
	public void registrarUsuario(Usuario user)
	{
		red.registrarUsuario(user);
	}
	
	public ArrayList<Usuario> getUsuarios()
	{
		return red.getUsuarios();
	}
	
	public Red getRed()
	{
		return red;
	}
}
