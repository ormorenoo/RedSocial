package red.modelo;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	
}
