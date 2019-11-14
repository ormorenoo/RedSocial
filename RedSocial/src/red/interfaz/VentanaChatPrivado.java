package red.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import red.modelo.Chat;
import red.modelo.Mensaje;
import red.modelo.Nodo;
import red.modelo.Usuario;

public class VentanaChatPrivado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea textAreaEnviado;
	private JButton btnEnviarMensaje;
	private VentanaPrincipal principal;
	private Mensaje mensaje;
	private Nodo nodo;
	private JScrollPane scrollPane;
	private JTextPane textPane;
	private ArrayList<Chat> chats;
	private Usuario user;
	private JScrollPane scrollPane_1;
	private JList list;
	private JButton btnVerChat;
	private JButton btnAtras;

	public VentanaChatPrivado(Usuario user, VentanaPrincipal principal) {
		this.user = user;
		this.principal = principal;
		nodo = principal.buscarNodo(user.getNick());
		chats = user.getChats();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaEnviado = new JTextArea();
		textAreaEnviado.setText("");
		textAreaEnviado.setBounds(211, 117, 175, 30);
		contentPane.add(textAreaEnviado);

		btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.addActionListener(this);
		btnEnviarMensaje.setBounds(221, 158, 136, 30);
		contentPane.add(btnEnviarMensaje);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(211, 40, 175, 66);
		contentPane.add(scrollPane);

		textPane = new JTextPane();

		String[] amigos = new String[nodo.getSize()];
		int aux = 0;

		for (int i = 0; i < nodo.getSize(); i++) {
			Nodo m = nodo.seguirEnlace(i);

			if (m != null) {
				amigos[aux] = m.getUsuario().getNick();
				aux++;
			}
		}

		scrollPane.setViewportView(textPane);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 40, 103, 161);
		contentPane.add(scrollPane_1);

		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = amigos;

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		list.setBounds(63, 74, 1, 1);

		scrollPane_1.setViewportView(list);

		btnVerChat = new JButton("Ver Chat");
		btnVerChat.addActionListener(this);
		btnVerChat.setBounds(42, 212, 89, 23);
		contentPane.add(btnVerChat);

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 258, 89, 23);
		contentPane.add(btnAtras);
	}

	public void cargarChat(Usuario destino) {

		Chat c = user.buscarChat(destino);
		ArrayList<Mensaje> msjs = c.getMensajes();

		for (int i = 0; i < msjs.size(); i++) {
			Mensaje msj = msjs.get(i);
			if (i == 0) {
				textPane.setText(msj.getTexto());
			} else {
				textPane.setText(textPane.getText() + msj.getTexto());
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Usuario usuarioDestino = principal.buscarUsuario((String) list.getSelectedValue());

		if (e.getSource() == btnEnviarMensaje) {
			Mensaje msj = new Mensaje(user, usuarioDestino, user.getNick() + ": \n" + textAreaEnviado.getText());
			user.buscarChat(usuarioDestino).agregarMensaje(msj.getTexto(), msj.getUserOrigen(), msj.getUserDestino());
			usuarioDestino.buscarChat(user).agregarMensaje(msj.getTexto(), msj.getUserOrigen(), msj.getUserDestino());

			if (textPane.getText().equals("")) {
				textPane.setText(msj.getTexto());
				textAreaEnviado.setText("");
			} else {
				textPane.setText(textPane.getText() + "\n\n" + "\n" + msj.getTexto());
				textAreaEnviado.setText("");
			}

		}

		if (e.getSource() == btnVerChat) {
			if (user.buscarChat(usuarioDestino) == null) {
				user.agregarChat(usuarioDestino);
				usuarioDestino.agregarChat(user);
			}
			cargarChat(usuarioDestino);
		}

		if (e.getSource() == btnAtras) {
			this.setVisible(false);
		}
	}
}
