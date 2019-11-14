package red.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Publicacion {

	private int meGusta;
	private Usuario userOrigen;
	private String texto;
	private Fecha fecha;
	private ArrayList<Usuario> usersLikes;
	private ArrayList<Comentario> comentarios;

	public Publicacion(Usuario userOrigen, String texto, Fecha fecha) {
		super();
		meGusta = 0;
		this.userOrigen = userOrigen;
		this.texto = texto;
		this.fecha = fecha;
		usersLikes = new ArrayList<Usuario>();
		comentarios = new ArrayList<Comentario>();
	}
	
	public void agregarComentario(Usuario userOrigen, String texto)
	{
		Date d = new Date();
		Fecha f = new Fecha(d.getYear()+1900, d.getMonth()+1, d.getDay()+10, d.getHours(), d.getMinutes());
		Comentario comentario = new Comentario(userOrigen, texto, f);
		comentarios.add(comentario);
	}
	
	public ArrayList<Comentario> getComentarios()
	{
		return comentarios;
		
	}
	
	public boolean buscarUsuario(Usuario user)
	{
		boolean cent = false;
		for(int i = 0 ; i < usersLikes.size() && cent == false ; i++)
		{
			if(user.getNick().equals(usersLikes.get(i).getNick()))
			{
				cent = true;
			}
		}return cent;
	}

	public int getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(Usuario user)
	{
		meGusta++;
		usersLikes.add(user);
	}

	public Usuario getUserOrigen() {
		return userOrigen;
	}

	public void setUserOrigen(Usuario userOrigen) {
		this.userOrigen = userOrigen;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	
	public String[] split()
	{
		return texto.split(" ");
	}
	
	public String darEncabezado()
	{
		String[] txt = split();
		String enc = "";
		
		if(txt.length < 4)
		{
			for (int i = 0; i < txt.length; i++) 
			{
				enc+= txt[i]+" ";
			}
		}else
		{
			for (int i = 0; i < 4; i++) 
			{
				enc+= txt[i]+" ";
			}
		}
		return enc;
		
	}
	
	public boolean equals(Publicacion p)
	{
		boolean cent = false;
		
		if(p.getUserOrigen().equals(userOrigen))
		{
			if(p.getFecha().equals(fecha))
			{
				if(p.getTexto().equals(texto))
				{
					cent = true;
				}
			}
		}return cent;
	}

}
