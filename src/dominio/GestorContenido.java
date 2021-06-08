package dominio;

import java.util.ArrayList;

public class GestorContenido {

	public static ArrayList<Contenido> buscarContenido(String titulo) throws Exception{
		ArrayList<Contenido> contenidoEncontrado = new ArrayList<Contenido>();
		
		contenidoEncontrado = Contenido.read(titulo);
		
		return contenidoEncontrado;
	}
	
}
