package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import red.modelo.Mensaje;
import red.modelo.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelUsuario extends JPanel implements ActionListener{

	private JPanel contentPane;
	private int i = 2;
	private JTabbedPane tabbedPane;
	private VentanaPrincipal principal;
	private JTable table;
	private JButton btnAtras;


	/**
	 * Create the frame.
	 */
	public PanelUsuario(VentanaPrincipal principal, Usuario user) 
	{
		this.principal = principal;
		setBounds(100, 100, 429, 302);
		setLayout(null);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 266, 76, 23);
		add(btnAtras);
		
		JButton btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.setBounds(121, 266, 124, 23);
		add(btnEnviarMensaje);
		
		JLabel lblNoHayMensajes = new JLabel("No hay mensajes para mostrar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		if(user != null)
		{
			String[] columnas = {"Mensajes", "Fecha", "Usuario"};
			ArrayList<Mensaje> msj = user.getMuro().getMensajes();
			Object[][] inf = new Object[msj.size()][3];
			if(msj.isEmpty())
			{
				lblNoHayMensajes.setBounds(145, 128, 183, 14);
				add(lblNoHayMensajes);
			}else
			{
				
				scrollPane.setBounds(111, 122, 2, 2);
				add(scrollPane);
				
				int aux = 0;
				int aux2 = 0;
				int aux3 = 0;
				for(int i = 0 ; i < inf.length ; i++)
				{
					for(int j = 0 ; j < inf[0].length ; j++)
					{
						if(j == 0)
						{
							inf[i][j] = msj.get(aux).getTexto();
							aux++;
						}else
						{
							if(j == 1)
							{
								inf[i][j] = msj.get(aux2).getFecha();
								aux2++;
							}else
							{
								inf[i][j] = msj.get(aux3).getUserOrigen();
							}
						}
						
					}
				}
			
			}
			
			table = new JTable(inf, columnas);
			table.setBounds(45, 162, 345, -115);
			scrollPane.add(table);
			
		}else
		{
			JLabel lblNoHayUsuarios = new JLabel("No hay usuarios para mostrar");
			lblNoHayUsuarios.setBounds(145, 128, 183, 14);
			add(lblNoHayUsuarios);
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() ==btnAtras)
		{
			principal.ocultar();
		}
	}
}
