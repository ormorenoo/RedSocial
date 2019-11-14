package red.modelo;

import java.util.ArrayList;

public class Chat {

	private Usuario usuario2;
	private ArrayList<Mensaje> mensajes;

	public Chat(Usuario usuario2) {
		super();
		this.usuario2 = usuario2;
		mensajes = new ArrayList<Mensaje>();
	}

	public void agregarMensaje(String txt, Usuario origen, Usuario destino) {
		Mensaje m = new Mensaje(origen, destino, txt);
		mensajes.add(m);
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

}
