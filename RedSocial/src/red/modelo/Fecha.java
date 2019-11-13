package red.modelo;

public class Fecha 
{
	private int año, mes, dia, hora, min;
	
	public Fecha(int año, int mes, int dia, int hora, int min)
	{
		this.año = año;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.min = min;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public String darFecha()
	{
		return año+"/"+mes+"/"+dia;
	}
	
	public String darHora()
	{
		return hora+":"+min;
	}
	
	public String toString()
	{
		String f = año+"/"+mes+"/"+dia+"/ "+hora+":"+min;
		return f;
	}
	
	
}
