package red.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import red.modelo.Publicacion;
import red.modelo.Usuario;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaPublicacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnLike;
	private JButton btnAtras;
	private JLabel lblLike;
	
	private Publicacion publicacion;
	private Usuario user;
	private int cont = 0;
	private String texto;
	

	/**
	 * Create the frame.
	 */
	public VentanaPublicacion(Publicacion publicacion, Usuario user) 
	{
		this.publicacion = publicacion;
		this.user = user;
		texto = publicacion.getTexto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("De: "+publicacion.getUserOrigen());
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(10, 11, 170, 20);
		contentPane.add(lblUsuario);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30,43,367,118);
		contentPane.add(scrollPane);
		
		JTextArea txtTexto = new JTextArea();
		txtTexto.setText(texto);
		txtTexto.setEditable(false);
		scrollPane.setViewportView(txtTexto);
		
		
		JLabel lblFecha = new JLabel(publicacion.getFecha()+"");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(195, 16, 202, 14);
		contentPane.add(lblFecha);
		
		lblLike = new JLabel("Likes: "+publicacion.getMeGusta());
		lblLike.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLike.setBounds(30, 164, 80, 20);
		contentPane.add(lblLike);
		
		btnLike = new JButton("Like");
		btnLike.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLike.addActionListener(this);
		btnLike.setBounds(311, 164, 89, 23);
		contentPane.add(btnLike);
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 227, 100, 23);
		contentPane.add(btnAtras);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLike) 
		{
			if(publicacion.buscarUsuario(user) == false)
			{
				publicacion.setMeGusta(user);
				cont++;
				lblLike.setText("Likes: "+publicacion.getMeGusta());
			}
			
		}

		if (e.getSource() == btnAtras) {

			this.setVisible(false);
		}
	}
}
