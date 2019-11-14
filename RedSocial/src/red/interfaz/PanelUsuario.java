package red.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import red.modelo.Comentario;
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
	private JButton btnBloquear;
	private JButton btnDesbloquear;
	
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
		
		setBounds(100, 100, 583, 343);
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 309, 76, 23);
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
		textFieldPublicacion.setBounds(10, 207, 206, 44);
		add(textFieldPublicacion);
		textFieldPublicacion.setColumns(10);

		btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(this);
		btnPublicar.setBounds(69, 255, 89, 23);
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
		
		btnBloquear = new JButton("Bloquear");
		btnBloquear.addActionListener(this);
		btnBloquear.setBounds(10, 134, 149, 23);
		add(btnBloquear);
		
		btnDesbloquear = new JButton("Desbloquear");
		btnDesbloquear.addActionListener(this);
		btnDesbloquear.setBounds(10, 163, 149, 23);
		add(btnDesbloquear);
		
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
	
	public void agregarComentario(Publicacion pub, Comentario comentario)
	{
		Nodo p = principal.buscarNodo(pub.getUserOrigen().getNick());
		for (int i = 0; i < p.getSize(); i++) 
		{
			Nodo nAmigo = p.seguirEnlace(i);
			
			if(nAmigo != null)
			{
				Usuario u = nAmigo.getUsuario();
				Muro uMuro = u.getMuro();
				ArrayList<Publicacion> pubs = uMuro.getPublicacion();
				
				for(int j = 0 ; j <pubs.size() ; j++)
				{
					Publicacion pu = pubs.get(j);
					
					if(pub.equals(pu))
					{
						pu.agregarComentario(comentario.getUserOrigen(), comentario.getTexto());
					}
				}	
			}
		}
	}
	
	public void agregarLike(Publicacion pub)
	{
		Nodo p = principal.buscarNodo(pub.getUserOrigen().getNick());
		
		for (int i = 0; i < p.getSize(); i++) 
		{
			Nodo nAmigo = p.seguirEnlace(i);
			
			if(nAmigo != null)
			{
				Usuario u = nAmigo.getUsuario();
				Muro uMuro = u.getMuro();
				ArrayList<Publicacion> pubs = uMuro.getPublicacion();
				
				for(int j = 0 ; j <pubs.size() ; j++)
				{
					Publicacion pu = pubs.get(j);
					
					if(pub.equals(pu))
					{
						pu.setMeGusta(user);
					}
				}	
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			principal.ocultar();
		}

		if (e.getSource() == btnEnviarSolicitud) 
		{
			String nombre = txtNombreUsuario.getText();

			if (principal.buscarUsuario(nombre) != null) {
				Usuario d = principal.buscarUsuario(txtNombreUsuario.getText());
				Nodo destino = principal.buscarNodo(d.getNick());
				
				if(destino.isBloqueado(nodo))
				{
					VentanaAlerta alerta = new VentanaAlerta("No puedes enviar solicitudes a este usuario");
					alerta.setVisible(true);
				}else
				{
					if(nodo.isBloqueado(destino))
					{
						VentanaAlerta alerta = new VentanaAlerta("Desbloquea primero al usuario");
						alerta.setVisible(true);
					}else
					{
						VentanaSolicitud solicitud = new VentanaSolicitud(nodo, destino);
						solicitud.setVisible(true);
					}
				}
				
			}else
			{
				VentanaAlerta alerta = new VentanaAlerta("El usuario buscado no existe");
				alerta.setVisible(true);
			}
		}

		if (e.getSource() == btnPublicar) {
			
			if(textFieldPublicacion.getText().equals(""))
			{
				VentanaAlerta alerta = new VentanaAlerta("Debe escribir algo");
				alerta.setVisible(true);
			}else
			{
				publicarMensaje();
				principal.actualizarTablas();
				textFieldPublicacion.setText("");
			}
			
		}
		
		if(e.getSource() == btnVerPublicacion)
		{
			if(table_1.isRowSelected(table_1.getSelectedRow()))
			{
				int indice = table_1.getSelectedRow();
				ArrayList<Publicacion> publicaciones = muro.getPublicacion();
				Publicacion p = publicaciones.get(indice);
				
				VentanaPublicacion ventanaPublicacion = new VentanaPublicacion(p, user, this);
				ventanaPublicacion.setVisible(true);
			}else
			{
				VentanaAlerta alerta = new VentanaAlerta("No hay publicaciones seleccionadas");
				alerta.setVisible(true);
			}
			
		}
		
		if(e.getSource() == btnBloquear)
		{
			String nombre = txtNombreUsuario.getText();

			if (principal.buscarUsuario(nombre) != null) 
			{
				Usuario d = principal.buscarUsuario(txtNombreUsuario.getText());
				Nodo destino = principal.buscarNodo(d.getNick());
				
				if(nodo.isConectado(destino))
				{
					try {
						if(nodo.isBloqueado(destino))
						{
							VentanaAlerta alerta = new VentanaAlerta("El usuario ya esta bloqueado");
							alerta.setVisible(true);
						}else
						{
							nodo.bloquear(nodo, destino);
							JOptionPane.showMessageDialog(null, "Usuario bloqueado");
						}
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else
				{
					VentanaAlerta alerta = new VentanaAlerta("El usuario buscado no es su amigo");
					alerta.setVisible(true);
				}
				
			}else
			{
				VentanaAlerta alerta = new VentanaAlerta("El usuario buscado no existe");
				alerta.setVisible(true);
			}
		}
		
		if(e.getSource() == btnDesbloquear)
		{
			String nombre = txtNombreUsuario.getText();

			if (principal.buscarUsuario(nombre) != null) 
			{
				Usuario d = principal.buscarUsuario(txtNombreUsuario.getText());
				Nodo destino = principal.buscarNodo(d.getNick());
				
				if(nodo.isBloqueado(destino))
				{
					nodo.desbloquear(destino);
					JOptionPane.showMessageDialog(null, "Usuario desbloqueado");
				}else
				{
					VentanaAlerta alerta = new VentanaAlerta("El usuario buscado no esta bloqueado");
					alerta.setVisible(true);
				}
			}else
			{
				VentanaAlerta alerta = new VentanaAlerta("El usuario buscado no existe");
				alerta.setVisible(true);
			}
			
		}
		
	}
}
