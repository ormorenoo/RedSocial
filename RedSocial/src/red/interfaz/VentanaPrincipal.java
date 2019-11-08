package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import red.modelo.Red;
import red.modelo.Usuario;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private VentanaAdministrador adm;


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(VentanaAdministrador adm) {
		this.adm = adm;
		setTitle("Red Social");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 388);
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
			panel = new PanelUsuario(this, u);
			tabbedPane.addTab(u.getNick(), null, panel, null);
			panel.setLayout(null);
		}
		if(users.isEmpty())
		{
			panel = new PanelUsuario(this, null);
			tabbedPane.addTab("Unknow", null, panel, null);
			panel.setLayout(null);
		}
	}
	
	public void ocultar()
	{
		this.setVisible(false);
		adm.setVisible(true);
	}
}
