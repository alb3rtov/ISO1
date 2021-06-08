package dominio;

public class GestorAdministracion {

	//Metodo para series
	public static boolean anadirContenido(String idContenido, String titulo, String fechaEstreno, 
			String sinopsis, String actores, String duracion, 
			String pais, String genero, String director, 
			String numTemporadas, String finalizada) throws Exception {
		
		boolean anadido = false;

		Integer id = Integer.parseInt(idContenido);
		Integer dur = Integer.parseInt(duracion);
		Integer nTemp = Integer.parseInt(numTemporadas);
		Boolean mfinalizada = Boolean.parseBoolean(finalizada);
		
		Serie s = new Serie(id, titulo, fechaEstreno, sinopsis,
				actores, dur, pais, genero, director,
				nTemp, mfinalizada);
		
		if (s.insert() == 2) {
			anadido = true;
		}
		
		return anadido;
	}
	
	//Metodo para peliculas
	public static boolean anadirContenido(String idContenido, String titulo, String fechaEstreno, 
			String sinopsis, String actores, String duracion, 
			String pais, String genero, String director, 
			String saga, String TresD, String fechaEstrenoCine) throws Exception{
		boolean anadido = false;
		
		Integer id = Integer.parseInt(idContenido);
		Integer dur = Integer.parseInt(duracion);
		Boolean tresd = Boolean.parseBoolean(TresD);
		
		Pelicula p = new Pelicula(id, titulo, fechaEstreno, sinopsis,
				actores, dur, pais, genero, director, saga,
				tresd, fechaEstrenoCine);
		
		int prueba = p.insert();
		
		if (prueba == 2) {
			anadido = true;
		}
		
		return anadido;
	}
}
