package red.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPublicacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMeGusta;
	private int cont = 0;
	private JLabel lblM;
	private PanelUsuario panelUsuario;
	private JLabel lblNewLabel;
	private String mensaje;
	private JButton btnAtras;
	private JLabel lblMeGustas;

	/**
	 * Create the frame.
	 */
	public VentanaPublicacion(String mensaje) {

		this.mensaje = mensaje;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnMeGusta = new JButton("Me gusta");
		btnMeGusta.addActionListener(this);
		btnMeGusta.setBounds(112, 114, 89, 23);
		contentPane.add(btnMeGusta);

		lblMeGustas = new JLabel("Me gustas :");
		lblMeGustas.setBounds(10, 118, 76, 14);
		contentPane.add(lblMeGustas);

		lblM = new JLabel(cont + "");
		lblM.setBounds(71, 118, 33, 14);
		contentPane.add(lblM);

		lblNewLabel = new JLabel(mensaje);
		lblNewLabel.setBounds(10, 57, 363, 50);
		contentPane.add(lblNewLabel);

		btnAtras = new JButton("atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(318, 216, 89, 23);
		contentPane.add(btnAtras);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnMeGusta) {
			if (cont == 0) {
				System.out.println("Me gusta");
				cont++;
				lblM.setText(cont + "");
			}
		}

		if (e.getSource() == btnAtras) {

			this.setVisible(false);
		}
	}
}
