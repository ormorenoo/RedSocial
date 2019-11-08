package red.modelo;

public class Publicacion {

	private int meGusta;
	private boolean compartir;
	private Usuario userOrigen;
	private String texto;
	private Fecha fecha;

	public Publicacion(int meGusta, boolean compartir, Usuario userOrigen, String texto, Fecha fecha) {
		super();
		this.meGusta = meGusta;
		this.compartir = compartir;
		this.userOrigen = userOrigen;
		this.texto = texto;
		this.fecha = fecha;
	}

	public int getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(int meGusta) {
		this.meGusta = meGusta;
	}

	public boolean isCompartir() {
		return compartir;
	}

	public void setCompartir(boolean compartir) {
		this.compartir = compartir;
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
