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
	
	public Usuario buscarUsuario(String nombre)
	{
		Usuario u = null;
		ArrayList<Usuario> usuarios = getUsuarios();
		
		for(int i = 0 ; i < usuarios.size() ; i++)
		{
			Usuario userB = usuarios.get(i);
			
			if(nombre.equalsIgnoreCase(userB.getNick()) || nombre.equalsIgnoreCase(userB.getNombreUsuario()))
			{
				u = userB;
			}
		}return u;
	}
	
	
}
