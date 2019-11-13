package red.modelo;

public class Fecha 
{
	private int a�o, mes, dia, hora, min;
	
	public Fecha(int a�o, int mes, int dia, int hora, int min)
	{
		this.a�o = a�o;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.min = min;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
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
		return a�o+"/"+mes+"/"+dia;
	}
	
	public String darHora()
	{
		return hora+":"+min;
	}
	
	public String toString()
	{
		String f = a�o+"/"+mes+"/"+dia+"/ "+hora+":"+min;
		return f;
	}
	
	
}
