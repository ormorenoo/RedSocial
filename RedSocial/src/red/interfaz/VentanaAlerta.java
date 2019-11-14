package red.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaAlerta extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnAceptar;
	private String msj;

	/**
	 * Create the frame.
	 */
	public VentanaAlerta(String msj) 
	{
		this.msj = msj;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAlerta.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		setType(Type.POPUP);
		setTitle("Alerta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdvertencia = new JLabel("Advertencia:");
		lblAdvertencia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdvertencia.setBounds(10, 11, 118, 20);
		contentPane.add(lblAdvertencia);
		
		JLabel lblEstoEsUna = new JLabel(this.msj);
		lblEstoEsUna.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstoEsUna.setVerticalAlignment(SwingConstants.TOP);
		lblEstoEsUna.setBounds(10, 58, 306, 61);
		contentPane.add(lblEstoEsUna);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(120, 130, 89, 23);
		contentPane.add(btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAceptar)
		{
			this.setVisible(false);
		}
	}

}
