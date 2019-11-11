package red.modelo;

import java.util.ArrayList;

public class Muro 
{
	private ArrayList<Publicacion> publicaciones;
	
	public Muro()
	{
		publicaciones = new ArrayList<Publicacion>();
	}

	public ArrayList<Publicacion> getMensajes() {
		return publicaciones;
	}

	public void setMensajes(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	
}
