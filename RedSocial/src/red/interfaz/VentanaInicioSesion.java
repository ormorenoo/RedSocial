package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtNick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioSesion frame = new VentanaInicioSesion();
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
	public VentanaInicioSesion() {
		setType(Type.UTILITY);
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(204, 11, 1, 229);
		panel.add(separator);
		
		JLabel lblNickname = new JLabel("Nickname :");
		lblNickname.setBounds(10, 27, 104, 14);
		panel.add(lblNickname);
		
		txtNick = new JTextField();
		txtNick.setBounds(20, 52, 119, 20);
		panel.add(txtNick);
		txtNick.setColumns(10);
	}
}
