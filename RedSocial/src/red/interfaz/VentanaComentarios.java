package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import red.modelo.Comentario;
import red.modelo.Fecha;
import red.modelo.Publicacion;
import red.modelo.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class VentanaComentarios extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextPane textPane;
	private JTextPane textPane2;
	private JButton btnComentar;
	private Usuario user;
	private Publicacion publicacion;
	private JButton btnAtras;
	private PanelUsuario panelUser;
	
	private ArrayList<Comentario> comentarios;


	/**
	 * Create the frame.
	 */
	public VentanaComentarios(Usuario user, Publicacion publicacion, PanelUsuario panelUser) 
	{
		this.user = user;
		this.publicacion = publicacion;
		this.panelUser = panelUser;
		comentarios = publicacion.getComentarios();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 11, 256, 74);
		contentPane.add(scrollPane);
		
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		actualizarLista();
		
		for (int i = 0; i < comentarios.size(); i++) 
		{
			String coment = comentarios.get(i).getTexto();
			textPane.setText(textPane.getText()+coment+"\n\n");
		}
		
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(91, 118, 256, 37);
		contentPane.add(scrollPane2);
		
		textPane2 = new JTextPane();
		scrollPane2.setViewportView(textPane2);
		
		btnComentar = new JButton("Comentar");
		btnComentar.addActionListener(this);
		btnComentar.setBounds(153, 166, 109, 23);
		contentPane.add(btnComentar);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnComentar)
		{
			String coment = user+": \n"+textPane2.getText();
			
			if(textPane.getText().equals(""))
			{
				textPane.setText(textPane.getText()+coment);
				textPane2.setText("");
			}else
			{
				textPane.setText(textPane.getText()+"\n\n"+coment);
				textPane2.setText("");
			}
			publicacion.agregarComentario(user, coment);
			Date d = new Date();
			Fecha f = new Fecha(d.getYear()+1900, d.getMonth()+1, d.getDay()+10, d.getHours(), d.getMinutes());
			Comentario comentario = new Comentario(user, coment, f);
			
			panelUser.agregarComentario(publicacion, comentario);
			
		}
		if(e.getSource() == btnAtras)
		{
			this.setVisible(false);
		}
	}
	
	public void actualizarLista()
	{
		comentarios = publicacion.getComentarios();
	}
}
