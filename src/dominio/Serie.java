package dominio;

import persistencia.Agente;

public class Serie extends Contenido{
	
	private int numeroTemporadas;
	private boolean finalizada;
	
	public Serie(int idContenido, String titulo, String fechaEstreno, String sinopsis,
			String actores, int duracion, String pais, String genero, String director,
			int numeroTemporadas, boolean finalizada) {
		super(idContenido, titulo, fechaEstreno, sinopsis, actores, 
				duracion, pais, genero, director);
		this.numeroTemporadas = numeroTemporadas;
		this.finalizada = finalizada;
	}
	
	public boolean getFinalizada() {
		return finalizada;
	}
	
	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}
	
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	public void setNumTemporadas(int numeroTemporadas) {
		this.numeroTemporadas= numeroTemporadas;
	}
	
	public int insert() throws Exception {
		int salida = 0;
		
		System.out.println("insert into contenido values("+ this.idContenido+",'serie','"+this.titulo+"','"+this.fechaEstreno+"','"+this.sinopsis+"','"+this.actores+"',"+this.duracion+",'"+this.pais+"','"+this.genero+"','"+this.director+"')");
		salida = Agente.getAgente().insert("insert into contenido values("+this.idContenido+",'serie','"+this.titulo+"','"+this.fechaEstreno+"','"+this.sinopsis+"','"+this.actores+"',"+this.duracion+",'"+this.pais+"','"+this.genero+"','"+this.director+"')");
		System.out.println(salida);
		salida += Agente.getAgente().insert("insert into serie values("+this.idContenido+","+this.numeroTemporadas+","+this.finalizada+","+this.idContenido+")");
		System.out.println(salida);
		return salida;
	}
	
	
}
