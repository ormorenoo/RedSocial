package red.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	private Muro muro;
	private String clave, nick;
	private ArrayList<Mensaje> mensaje;

	public void agregarMensaje(String texto) {
		Date d = new Date();
		Fecha f = new Fecha(d.getYear() + 1900, d.getMonth() + 1, d.getDay() + 10, d.getHours(), d.getMinutes());
		Mensaje p = new Mensaje(this, texto, f);
		mensaje.add(p);
	}

	public Usuario(String clave, String nick) {
		muro = new Muro();
		this.clave = clave;
		this.nick = nick;
	}

	public Muro getMuro() {
		return muro;
	}

	public void setMuro(Muro muro) {
		this.muro = muro;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String toString() {
		return nick;
	}

	public ArrayList<Mensaje> getMensaje() {
		return mensaje;
	}

	public void setMensaje(ArrayList<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}

}
