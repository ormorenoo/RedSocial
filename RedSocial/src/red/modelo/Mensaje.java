package red.modelo;

public class Mensaje {
	private Usuario userOrigen, userDestino;
	private String texto;
	private Fecha fecha;

	public Mensaje(Usuario userDestino, String texto, Fecha fecha) {
		this.userDestino = userDestino;
		this.texto = texto;
		this.fecha = fecha;
	}

	public Usuario getUserOrigen() {
		return userOrigen;
	}

	public void setUserOrigen(Usuario userOrigen) {
		this.userOrigen = userOrigen;
	}

	public Usuario getUserDestino() {
		return userDestino;
	}

	public void setUserDestino(Usuario userDestino) {
		this.userDestino = userDestino;
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
