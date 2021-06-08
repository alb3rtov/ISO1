package dominio;

import persistencia.Agente;

public class Pelicula extends Contenido{

	private String saga;
	private boolean tresD;
	private String fechaEstrenoCine;
	
	public Pelicula(int idContenido, String titulo, String fechaEstreno, String sinopsis, 
			String actores, int duracion, String pais, String genero, String director,
			String saga, boolean tresD, String fechaEstrenoCine) {
		super(idContenido, titulo, fechaEstreno, sinopsis, actores, duracion, pais, genero, director);
		
		this.saga = saga;
		this.tresD = tresD;
		this.fechaEstrenoCine = fechaEstrenoCine;
	}
		
	public String getSaga() {
		return saga;
	}
	
	public void setSaga(String saga) {
		this.saga = saga;
	}
	
	public boolean getTresD() {
		return tresD;
	}
	
	public void setTresD(boolean tresD) {
		this.tresD = tresD;
	}
	
	public String getfechaEstrenoCine() {
		return fechaEstrenoCine;
	}
	
	public void setFechaEstrenoCine(String fechaEstrenoCine) {
		this.fechaEstrenoCine = fechaEstrenoCine;
	}
	
	public int insert() throws Exception {
		int salida = 0;
		
		salida = Agente.getAgente().insert("insert into contenido values("+this.idContenido+",'pelicula','"+this.titulo+"','"+this.fechaEstreno+"','"+this.sinopsis+"','"+this.actores+"',"+this.duracion+",'"+this.pais+"','"+this.genero+"','"+this.director+"')");
		salida += Agente.getAgente().insert("insert into pelicula values("+this.idContenido+",'"+this.saga+"',"+this.tresD+",'"+this.fechaEstrenoCine+"',"+this.idContenido+")");

		return salida;
	}
	
}
