package red.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Red {
	HashMap<String, Nodo> grafo;

	public Red() {
		grafo = new HashMap<String, Nodo>();
	}

	public void registrarUsuario(Usuario user) {
		Nodo n = new Nodo(user.getNick(), user);
		grafo.put(n.getNombre(), n);
	}

	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		for (Nodo value : grafo.values()) {
			usuarios.add(value.getUsuario());
		}

		return usuarios;
	}

	public Nodo buscarNodo(String nick) {
		Nodo n = null;
		for (Nodo value : grafo.values()) {
			if (value.getNombre().equals(nick)) {
				n = value;
			}
		}
		return n;
	}

	public Usuario buscarUsuario(String nombre) {
		Usuario u = null;

		if (nombre != null) {
			ArrayList<Usuario> usuarios = getUsuarios();

			for (int i = 0; i < usuarios.size(); i++) {
				Usuario userB = usuarios.get(i);

				if (userB != null) {

					if (nombre.equalsIgnoreCase(userB.getNick())) {
						u = userB;
					}
				}

			}
		}

		return u;
	}

	public boolean isVacio() {
		return grafo.isEmpty();
	}

}
