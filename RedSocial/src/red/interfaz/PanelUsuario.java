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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import red.modelo.Nodo;
import red.modelo.Publicacion;
import red.modelo.Usuario;

public class PanelUsuario extends JPanel implements ActionListener {

	private JPanel contentPane;
	private int i = 2;
	private JTabbedPane tabbedPane;
	private VentanaPrincipal principal;
	private JTable table;
	private JButton btnAtras;
	private JTextField txtNombreUsuario;
	private JButton btnEnviarSolicitud;
	private JButton btnEnviarMensaje;
	private Usuario user;
	private JTextField textFieldPublicacion;
	private JButton btnPublicar;
	private String mensaje;
	private VentanaPublicacion miVentanaPublicacion;

	/**
	 * Create the frame.
	 */
	public PanelUsuario(VentanaPrincipal principal, Usuario user) {
		this.principal = principal;
		this.user = user;
		setBounds(100, 100, 429, 302);
		setLayout(null);

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 266, 76, 23);
		add(btnAtras);

		btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.addActionListener(this);
		btnEnviarMensaje.setBounds(121, 266, 124, 23);
		add(btnEnviarMensaje);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setText("Nombre usuario");
		txtNombreUsuario.setBounds(10, 75, 111, 20);
		add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		btnEnviarSolicitud = new JButton("Enviar Solicitud");
		btnEnviarSolicitud.addActionListener(this);
		btnEnviarSolicitud.setBounds(10, 106, 111, 23);
		add(btnEnviarSolicitud);

		textFieldPublicacion = new JTextField();
		textFieldPublicacion.setBounds(193, 75, 206, 44);
		add(textFieldPublicacion);
		textFieldPublicacion.setColumns(10);

		btnPublicar = new JButton("publicar");
		btnPublicar.addActionListener(this);
		btnPublicar.setBounds(310, 138, 89, 23);
		add(btnPublicar);

		JLabel lblNoHayMensajes = new JLabel("No hay mensajes para mostrar");

		JScrollPane scrollPane = new JScrollPane();

		if (user != null) {
			String[] columnas = { "Notificaciones", "Fecha", "Usuario" };
			ArrayList<Publicacion> msj = user.getMuro().getMensajes();
			Object[][] inf = new Object[msj.size()][3];
			if (msj.isEmpty()) {
				lblNoHayMensajes.setBounds(145, 128, 183, 14);
				add(lblNoHayMensajes);
			} else {

				scrollPane.setBounds(111, 122, 2, 2);
				add(scrollPane);

				int aux = 0;
				int aux2 = 0;
				int aux3 = 0;
				for (int i = 0; i < inf.length; i++) {
					for (int j = 0; j < inf[0].length; j++) {
						if (j == 0) {
							inf[i][j] = msj.get(aux).getTexto();
							aux++;
						} else {
							if (j == 1) {
								inf[i][j] = msj.get(aux2).getFecha();
								aux2++;
							} else {
								inf[i][j] = msj.get(aux3).getUserOrigen();
							}
						}

					}
				}

			}

			table = new JTable(inf, columnas);
			table.setBounds(45, 162, 345, -115);
			scrollPane.add(table);

		} else {
			JLabel lblNoHayUsuarios = new JLabel("No hay usuarios para mostrar");
			lblNoHayUsuarios.setBounds(145, 128, 183, 14);
			add(lblNoHayUsuarios);
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			principal.ocultar();
		}

		if (e.getSource() == btnEnviarSolicitud) {
			String nombre = txtNombreUsuario.getText();

			if (principal.buscarUsuario(nombre) != null) {
				Nodo origen = principal.buscarNodo(user.getNick());
				Usuario d = principal.buscarUsuario(txtNombreUsuario.getText());
				Nodo destino = principal.buscarNodo(d.getNick());
				VentanaSolicitud solicitud = new VentanaSolicitud(origen, destino);
				solicitud.setVisible(true);
			}
		}

		if (e.getSource() == btnPublicar) {
			mensaje = textFieldPublicacion.getText();
			VentanaPublicacion principal = new VentanaPublicacion(mensaje);
			principal.setVisible(true);
			this.setVisible(false);
		}
	}
}
