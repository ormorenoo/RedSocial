package red.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import red.modelo.Muro;
import red.modelo.Nodo;
import red.modelo.Publicacion;
import red.modelo.Usuario;
import javax.swing.table.DefaultTableModel;

public class PanelUsuario extends JPanel implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JButton btnAtras;
	private JButton btnEnviarSolicitud;
	private JTextArea textFieldPublicacion;
	private VentanaPrincipal principal;
	private JButton btnPublicar;
	private JTable table_1;
	private JButton btnVerPublicacion ;
	
	private Usuario user;
	private Muro muro;
	private Nodo nodo;	
	

	/**
	 * Create the frame.
	 */
	public PanelUsuario(VentanaPrincipal principal, Usuario user) 
	{
		this.principal = principal;
		this.user = user;
		muro = user.getMuro();
		nodo = principal.buscarNodo(user.getNick());
		
		setBounds(100, 100, 583, 302);
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 266, 76, 23);
		add(btnAtras);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setText("Nombre usuario");
		txtNombreUsuario.setBounds(10, 75, 111, 20);
		add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		btnEnviarSolicitud = new JButton("Enviar Solicitud");
		btnEnviarSolicitud.addActionListener(this);
		btnEnviarSolicitud.setBounds(10, 106, 149, 23);
		add(btnEnviarSolicitud);

		textFieldPublicacion = new JTextArea();
		textFieldPublicacion.setBounds(10, 159, 206, 44);
		add(textFieldPublicacion);
		textFieldPublicacion.setColumns(10);

		btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(this);
		btnPublicar.setBounds(69, 212, 89, 23);
		add(btnPublicar);
		
		ArrayList<Publicacion> publicaciones = muro.getPublicacion();
		Object[][] inf = getData(publicaciones);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(inf,
			new String[] 
					{"Notificacion", "Usuario", "Fecha", "Hora"}
		));
		
		table_1.setBounds(0, 0, 1, 1);
		JScrollPane scrollPane_2 = new JScrollPane(table_1);
		scrollPane_2.setBounds(226, 54, 347, 204);
		add(scrollPane_2);
		
		btnVerPublicacion = new JButton("Ver Publicacion");
		btnVerPublicacion.addActionListener(this);
		btnVerPublicacion.setBounds(329, 266, 140, 23);
		add(btnVerPublicacion);
		
	}
	
	public Object[][] getData(ArrayList<Publicacion> pubs)
	{
		Object[][] inf = new Object[pubs.size()][4];

		int aux = 0;
		int aux2 = 0;
		int aux3 = 0;
		int aux4 = 0;
		for (int i = 0; i < inf.length; i++) 
		{
			for (int j = 0; j < inf[0].length; j++) 
			{
				if (j == 0) {
					inf[i][j] = pubs.get(aux).darEncabezado();
					aux++;
				} 
				if (j == 1) 
				{
					inf[i][j] = pubs.get(aux2).getUserOrigen();
					aux2++;
				} 
				if(j == 2)
				{
					inf[i][j] = pubs.get(aux3).getFecha().darFecha();
					aux3++;
				}
				if(j == 3)
				{
					inf[i][j] = pubs.get(aux4).getFecha().darHora();
					aux4++;
				}
			}
		}return inf;
	}
	
	public void actualizarTable()
	{
		ArrayList<Publicacion> publicaciones = muro.getPublicacion();
		Object[][] inf = getData(publicaciones);
		
		table_1.setModel(new DefaultTableModel(inf,
				new String[] 
						{"Notificacion", "Usuario", "Fecha", "Hora"}
			));

	}
	
	public void publicarMensaje()
	{
		String pub = textFieldPublicacion.getText();
		
		for (int i = 0; i < nodo.getSize(); i++) 
		{
			Nodo nAmigo = nodo.seguirEnlace(i);
			
			if(nAmigo != null)
			{
				Usuario u = nAmigo.getUsuario();
				Muro uMuro = u.getMuro();
				
				uMuro.agregarPublicacion(pub, user);
			}
		}
		muro.agregarPublicacion(pub, user);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			principal.ocultar();
		}

		if (e.getSource() == btnEnviarSolicitud) {
			String nombre = txtNombreUsuario.getText();

			if (principal.buscarUsuario(nombre) != null) {
				Usuario d = principal.buscarUsuario(txtNombreUsuario.getText());
				Nodo destino = principal.buscarNodo(d.getNick());
				VentanaSolicitud solicitud = new VentanaSolicitud(nodo, destino);
				solicitud.setVisible(true);
			}
		}

		if (e.getSource() == btnPublicar) {
			publicarMensaje();
			principal.actualizarTablas();
			textFieldPublicacion.setText("");
		}
		
		if(e.getSource() == btnVerPublicacion)
		{
			int indice = table_1.getSelectedRow();
			ArrayList<Publicacion> publicaciones = muro.getPublicacion();
			Publicacion p = publicaciones.get(indice);
			
			VentanaPublicacion ventanaPublicacion = new VentanaPublicacion(p, user);
			ventanaPublicacion.setVisible(true);
		}
	}
}
