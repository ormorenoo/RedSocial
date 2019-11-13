package red.modelo;

import java.io.IOException;
import java.util.ArrayList;

public class Nodo {
	private Usuario usuario;
	private String nombre;
	private int limiteConexiones;
	private ArrayList<Nodo> enlaces;
	private int size;

	public Nodo(String nombre, Usuario usuario) {
		this.nombre = nombre;
		this.usuario = usuario;
		limiteConexiones = 100;
		enlaces = new ArrayList<Nodo>();
		size = 0;
	}

	// Metodo aceptar solicitud
	public void aceptarSolicitud(Nodo a, Nodo b) throws IOException {
		a.conectar(b);
		b.conectar(a);
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
			if (destino.getNombre().equals(enlaces.get(i).getNombre())) {
				enlaces.remove(i);
				cent = true;
			}
		}
		if (cent == false) {
			throw new IOException("Usuario no encontrado");
		}

	}

	public boolean verificarConexRepetidas(Nodo nodo) {
		boolean cent = false;
		for (int i = 0; i < enlaces.size() && cent == false; i++) {
			if (nodo.getNombre().equals(enlaces.get(i).getNombre())) {
				cent = true;
			}
		}
		return cent;
	}
	
	public Nodo seguirEnlace(int indice)
	{
		return enlaces.get(indice);
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
	
	public int getSize()
	{
		return size;
	}

}
