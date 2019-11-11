package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import red.modelo.Nodo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Toolkit;

public class VentanaSolicitud extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Nodo origen, destino;

	/**
	 * Create the frame.
	 */
	public VentanaSolicitud(Nodo origen, Nodo destino) {
		this.origen = origen;
		this.destino = destino;
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSolicitud.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		setTitle("Solicitud de Amistad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMsj = new JLabel(destino.getUsuario()+" ,el usuario "+origen.getUsuario()+" quiere ser tu amigo");
		lblMsj.setVerticalAlignment(SwingConstants.TOP);
		lblMsj.setBounds(27, 22, 253, 64);
		contentPane.add(lblMsj);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(20, 112, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(192, 112, 89, 23);
		contentPane.add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAceptar)
		{
			try {
				destino.aceptarSolicitud(origen, destino);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			this.setVisible(false);
		}
		if(e.getSource() == btnCancelar)
		{
			this.setVisible(false);
		}
	}
}
