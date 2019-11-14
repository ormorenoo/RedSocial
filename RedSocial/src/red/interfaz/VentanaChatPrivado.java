package red.interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import red.modelo.Mensaje;
import red.modelo.Nodo;
import red.modelo.Usuario;

public class VentanaChatPrivado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea textAreaResibido;
	private JTextArea textAreaEnviado;
	private JTextField textFieldAmigo;
	private JButton btnEnviarMensaje;
	private VentanaPrincipal principal;
	private Usuario user;
	private Mensaje mensaje;
	private Nodo nodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaChatPrivado frame = new VentanaChatPrivado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaChatPrivado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaResibido = new JTextArea();
		textAreaEnviado.setText("");
		textAreaResibido.setBounds(185, 50, 227, 181);
		contentPane.add(textAreaResibido);

		textAreaEnviado = new JTextArea();
		textAreaEnviado.setText("");
		textAreaEnviado.setBounds(23, 115, 136, 57);
		contentPane.add(textAreaEnviado);

		btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.addActionListener(this);
		btnEnviarMensaje.setBounds(23, 186, 136, 30);
		contentPane.add(btnEnviarMensaje);

		textFieldAmigo = new JTextField();
		textFieldAmigo.setText("Nombre amigo");
		textFieldAmigo.setBounds(23, 73, 119, 30);
		contentPane.add(textFieldAmigo);
		textFieldAmigo.setColumns(10);
	}

	public void EnviarMensaje() {
		String mensajeAEnviar = textAreaEnviado.getText();

		String nombre = textFieldAmigo.getText();

		if (principal.buscarUsuario(nombre) != null) {

			Usuario u = principal.buscarUsuario(nombre);

			u.agregarMensaje(mensajeAEnviar);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEnviarMensaje) {

		}
	}

}
