package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaPublicacion extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnMeGusta;
	private int cont = 0;
	private JLabel lblM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPublicacion frame = new VentanaPublicacion();
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
	public VentanaPublicacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnMeGusta = new JButton("Me gusta");
		btnMeGusta.addActionListener(this);
		btnMeGusta.setBounds(137, 143, 89, 23);
		contentPane.add(btnMeGusta);
		
		JLabel lblMeGustas = new JLabel("Me gustas :");
		lblMeGustas.setBounds(137, 95, 76, 14);
		contentPane.add(lblMeGustas);
		
		lblM = new JLabel(cont+"");
		lblM.setBounds(223, 95, 46, 14);
		contentPane.add(lblM);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnMeGusta)
		{
			if(cont == 0)
			{
				System.out.println("Me gusta");
				cont++;
				lblM.setText(cont+"");
			}
		}
	}
}
