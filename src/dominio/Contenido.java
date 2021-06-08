package dominio;

import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.Agente;

public class Contenido {

	protected int idContenido;
	protected String titulo;
	protected String fechaEstreno;
	protected String sinopsis;
	protected String actores;
	protected int duracion;
	protected String pais;
	protected String genero;
	protected String director;

	public Contenido(int idContenido, String titulo, String fechaEstreno, String sinopsis, 
			String actores, int duracion, String pais, String genero, String director) {
		this.idContenido=idContenido;
		this.titulo=titulo;
		this.fechaEstreno=fechaEstreno;
		this.sinopsis=sinopsis;
		this.actores=actores;
		this.duracion=duracion;
		this.pais=pais;
		this.genero=genero;
		this.director=director;
	}
	
	public int getIdContenido() {
		return idContenido;
	}
	
	public void setIdContenido(int idContenido) {
		this.idContenido = idContenido;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	
	public String getFechaEstreno() {
		return fechaEstreno;
	}
	
	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}
	
	public void setSinopsis(String sinopsis){
		this.sinopsis = sinopsis;
	}	
	
	public String getActores() {
		return actores;
	}
	
	public void setActores(String actores) {
		this.actores = actores;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getGenero(){
		return genero;
	}	

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	
	public static ArrayList<Contenido> read(String tituloContenido) {
		ArrayList<String> list = new ArrayList<String>();
		String str = new String(tituloContenido);
		ArrayList<Contenido> contenidoEncontrado = new ArrayList<Contenido>();
		int idContenido;
		String titulo;
		String fechaEstreno;
		String sinopsis;
		String actores;
		int duracion;
		String pais;
		String genero;
		String director;
		
		try {
			int i = 0;
			int size = 0;
			Contenido contenido;
			list = Agente.getAgente().select("select idcontenido,titulo,fechaestreno,sinopsis,actores,duracion,pais,genero,director from contenido where lower(titulo) like '%" + str.toLowerCase() + "%'");

			while (list.size()/9 > i) {
		
				idContenido = Integer.parseInt(list.get(0+size));
				titulo = list.get(1+size);
				fechaEstreno = list.get(2+size);
				sinopsis = list.get(3+size);
				actores =  list.get(4+size);
				duracion =  Integer.parseInt(list.get(5+size));
				pais = list.get(6+size);
				genero = list.get(7+size);
				director =  list.get(8+size);
				i++;
				size +=9;

				contenido = new Contenido(idContenido, titulo, fechaEstreno, sinopsis, actores, duracion, pais, genero, director);
				contenidoEncontrado.add(contenido);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contenidoEncontrado;
	}
	

}
