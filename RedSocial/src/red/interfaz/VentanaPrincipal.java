package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import red.modelo.Nodo;
import red.modelo.Red;
import red.modelo.Usuario;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	
	ArrayList<JPanel> paneles;
	
	private VentanaAdministrador adm;


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(VentanaAdministrador adm) 
	{
		this.adm = adm;
		paneles = new ArrayList<JPanel>();
		
		setTitle("Red Social");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		abrirPanelUser();
	}
	
	public void abrirPanelUser()
	{
		ArrayList<Usuario> users = adm.getUsuarios();
		for(int i = 0 ; i < users.size() ; i++)
		{
			Usuario u = users.get(i);
			JPanel panel = new PanelUsuario(this, u);
			paneles.add(panel);
			tabbedPane.addTab(u.getNick(), null, panel, null);
			panel.setLayout(null);
		}
		if(users.isEmpty())
		{
			//Lanzar alerta de no hay usuarios
		}
	}
	
	public void actualizarTablas()
	{
		for(int i = 0; i < paneles.size() ; i++)
		{
			PanelUsuario panel = (PanelUsuario) paneles.get(i);
			panel.actualizarTable();
		}
	}
	
	public void ocultar()
	{
		this.setVisible(false);
		adm.setVisible(true);
	}
	
	public Usuario buscarUsuario(String nombre)
	{
		return adm.getRed().buscarUsuario(nombre);
	}
	
	public Nodo buscarNodo(String nick)
	{
		return adm.getRed().buscarNodo(nick);
	}
}
