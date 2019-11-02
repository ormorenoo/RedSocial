package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PanelUsuario extends JPanel implements ActionListener{

	private JPanel contentPane;
	private JButton btnTab;
	private int i = 2;
	private JButton btnIniciar;
	private JTabbedPane tabbedPane;
	private VentanaPrincipal principal;

	/**
	 * Create the frame.
	 */
	public PanelUsuario(VentanaPrincipal principal) {
		this.principal = principal;
		setBounds(100, 100, 450, 300);
		setLayout(null);
		
		btnIniciar = new JButton("Iniciar Sesion");
		btnIniciar.addActionListener(this);
		btnIniciar.setBounds(32, 92, 112, 23);
		add(btnIniciar);
		
		btnTab = new JButton("+");
		btnTab.addActionListener(this);
		btnTab.setBounds(409, 0, 41, 23);
		
		add(btnTab);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	public void agregarTab()
	{
		principal.agregarTab();
	}
	
	public void setPanel()
	{
		btnIniciar.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnTab)
		{
			agregarTab();
			i++;
		}
		
		if(e.getSource() == btnIniciar)
		{
			setPanel();
		}
		
	}

}
