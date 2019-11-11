package red.modelo;

public class Usuario 
{
	private Muro muro;
	private String clave, nick;
	
	public Usuario(String clave, String nick)
	{
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
	
	public String toString()
	{
		return nick;
	}
	
}
