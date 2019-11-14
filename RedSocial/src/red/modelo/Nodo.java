package red.modelo;

import java.io.IOException;
import java.util.ArrayList;

public class Nodo {
	private Usuario usuario;
	private String nombre;
	private int limiteConexiones;
	private ArrayList<Nodo> enlaces;
	private ArrayList<Nodo> bloqueos;
	private int size;

	public Nodo(String nombre, Usuario usuario) {
		this.nombre = nombre;
		this.usuario = usuario;
		limiteConexiones = 100;
		enlaces = new ArrayList<Nodo>();
		bloqueos = new ArrayList<Nodo>();
		size = 0;
	}

	// Metodo aceptar solicitud
	public void aceptarSolicitud(Nodo a, Nodo b) throws IOException {

		a.conectar(b);
		b.conectar(a);
	}

	public void bloquear(Nodo a, Nodo b) throws IOException {
		a.desconectar(b);
		b.desconectar(a);

		bloqueos.add(b);
	}

	public void desbloquear(Nodo b) {
		bloqueos.remove(b);
	}

	public boolean isBloqueado(Nodo b) {
		boolean cent = false;

		for (int i = 0; i < bloqueos.size() && cent == false; i++) {
			if (b.getNombre().equals(bloqueos.get(i).getNombre())) {
				cent = true;
			}
		}
		return cent;
	}

	// Metodo para concectar dos nodos
	public void conectar(Nodo destino) throws IOException {
		if (enlaces.size() < limiteConexiones) {
			if (verificarConexRepetidas(destino)) {
				throw new IOException("Usuario existente.");
			} else {
				enlaces.add(destino);
				size++;
			}
		} else {
			throw new IOException("Limite de amigos superado.");
		}
	}

	public void desconectar(Nodo destino) throws IOException {
		boolean cent = false;
		for (int i = 0; i < enlaces.size() && cent == false; i++) {
			if (enlaces.get(i) != null) {
				if (destino.getNombre().equals(enlaces.get(i).getNombre())) {
					enlaces.set(i, null);
					cent = true;
				}
			}

		}
		if (cent == false) {
			throw new IOException("Usuario no encontrado");
		}

	}

	public boolean verificarConexRepetidas(Nodo nodo) {
		boolean cent = false;
		for (int i = 0; i < enlaces.size() && cent == false; i++) {
			if (enlaces.get(i) != null) {
				if (nodo.getNombre().equals(enlaces.get(i).getNombre())) {
					cent = true;
				}
			}
		}
		return cent;
	}

	public Nodo seguirEnlace(int indice) {
		return enlaces.get(indice);
	}

	public boolean isConectado(Nodo n) {
		boolean cent = false;
		for (int i = 0; i < enlaces.size() && cent == false; i++) {
			if (enlaces.get(i) != null) {
				if (n.getNombre().equals(enlaces.get(i).getNombre())) {
					cent = true;
				}
			}

		}
		return cent;
	}

	public boolean isEnlacesVacio() {
		boolean cent = false;

		for (int i = 0; i < enlaces.size() && cent == false; i++) {

			if (enlaces.get(i) != null) {
				cent = true;
			}
		}
		return cent;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Nodo> getEnlaces() {
		return enlaces;
	}

	public ArrayList<Nodo> getBloqueos() {
		return bloqueos;
	}

	public int getSize() {
		return size;
	}

}
