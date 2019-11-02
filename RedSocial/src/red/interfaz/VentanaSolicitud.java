package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class VentanaSolicitud extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSolicitud frame = new VentanaSolicitud();
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
	public VentanaSolicitud() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSolicitud.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		setTitle("Solicitud de Amistad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMsj = new JLabel("El usuario                      quiere ser tu amigo.");
		lblMsj.setVerticalAlignment(SwingConstants.TOP);
		lblMsj.setBounds(27, 22, 253, 64);
		contentPane.add(lblMsj);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(20, 112, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(192, 112, 89, 23);
		contentPane.add(btnCancelar);
	}
}
