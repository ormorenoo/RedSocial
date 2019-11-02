package red.modelo;

public class Usuario 
{
	private Muro muro;
	private String nombreUsuario, clave, nick;
	
	public Usuario(String nombreUsuario, String clave, String nick)
	{
		muro = new Muro();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.nick = nick;
	}

	public Muro getMuro() {
		return muro;
	}

	public void setMuro(Muro muro) {
		this.muro = muro;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	
}
