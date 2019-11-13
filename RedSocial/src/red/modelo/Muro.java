package red.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Muro 
{
	private ArrayList<Publicacion> publicaciones;
	
	public Muro()
	{
		publicaciones = new ArrayList<Publicacion>();
	}
	
	public void agregarPublicacion(String txt, Usuario origen)
	{
		Date d = new Date();
		Fecha f = new Fecha(d.getYear()+1900, d.getMonth()+1, d.getDay()+10, d.getHours(), d.getMinutes());
		Publicacion p = new Publicacion(origen, txt, f);
		publicaciones.add(p);
	}

	public ArrayList<Publicacion> getPublicacion() {
		return publicaciones;
	}

	public void setPublicacion(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	
}
