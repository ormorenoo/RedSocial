package red.modelo;

import java.util.ArrayList;

public class Usuario {
	private Muro muro;
	private String clave, nick;
	private ArrayList<Chat> chats;

	public Usuario(String clave, String nick) {
		muro = new Muro();
		this.clave = clave;
		this.nick = nick;
		chats = new ArrayList<Chat>();
	}

	public void agregarChat(Usuario destino) {
		Chat c = new Chat(destino);
		chats.add(c);
	}

	public Chat buscarChat(Usuario destino) {
		Chat c = null;

		for (int i = 0; i < chats.size(); i++) {
			if (chats.get(i).getUsuario2().getNick().equals(destino.getNick())) {
				c = chats.get(i);
			}
		}
		return c;
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

	public ArrayList<Chat> getChats() {
		return chats;
	}

}
