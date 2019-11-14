package red.modelo;

public class Comentario 
{
	private Usuario userOrigen;
	private String texto;
	private Fecha fecha;
	
	public Comentario(Usuario userOrigen, String texto, Fecha fecha) 
	{
		this.userOrigen = userOrigen;
		this.texto = texto;
		this.fecha = fecha;
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
	
	
	
	
	
	
}
