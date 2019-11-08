package red.principal;

import javax.swing.JOptionPane;

import red.interfaz.VentanaAdministrador;
import red.modelo.Red;

public class Principal 
{
	public static void main(String[] args) 
	{
		Red red = new Red();
		VentanaAdministrador adm = new VentanaAdministrador(red);
		adm.setVisible(true);
	}
}
