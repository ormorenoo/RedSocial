package red.modelo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

public class Red 
{
	HashMap<String, Nodo> grafo;
	
	public Red()
	{
		grafo = new HashMap<String, Nodo>();
	}
	
	public void registrarUsuario(Usuario user)
	{
		Nodo n = new Nodo(user.getNick(), user);
		grafo.put(n.getNombre(), n);
	}
	
	public ArrayList<Usuario> getUsuarios()
	{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 
		
		for(Nodo value : grafo.values())
		{
			usuarios.add(value.getUsuario());
		}
		
		return usuarios;
	}
	
	
}
