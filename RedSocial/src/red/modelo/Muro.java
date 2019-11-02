package red.modelo;

import java.util.ArrayList;

public class Muro 
{
	private ArrayList<Mensaje> mensajes;
	
	public Muro()
	{
		mensajes = new ArrayList<Mensaje>();
	}

	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
