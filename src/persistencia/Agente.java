package persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.derby.jdbc.EmbeddedDriver;

public class Agente {

	protected static Agente mInstancia = null;
	protected static Connection mBD;
	
	private Agente() throws Exception {
		conectar();
	}

	public static Agente getAgente() throws Exception {
		
		if (mInstancia == null) {	
			mInstancia = new Agente();
		}
		return mInstancia;
	}
	
	public ArrayList<String> select(String SQL) throws SQLException, Exception { 
		ArrayList<String> list = new ArrayList<String>();
		
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultSet = stmt.executeQuery();
		
		while (resultSet.next()) {
			list.add(resultSet.getString("IDCONTENIDO"));
			list.add(resultSet.getString("TITULO"));
			list.add(resultSet.getString("FECHAESTRENO"));
			list.add(resultSet.getString("SINOPSIS"));
			list.add(resultSet.getString("ACTORES"));
			list.add(resultSet.getString("DURACION"));
			list.add(resultSet.getString("PAIS"));
			list.add(resultSet.getString("GENERO"));
			list.add(resultSet.getString("DIRECTOR"));
		}

		stmt.close();
		desconectar();
		return list;
	}
	
	public int insert(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}
	
	
	private void conectar() throws Exception {
		//String jdbcURL = "org.apacha.derby.jdbc.EmbeddedDriver";
		String jdbcURL = "jdbc:derby:sistemadb;create=false";
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		
		try {
			
			mBD = DriverManager.getConnection(jdbcURL);			
		} catch (SQLException e) {
			System.out.println("Error con la conexión en la base de datos");
			e.printStackTrace();
		}
	}
	
	public void desconectar() throws Exception {
		mBD.close();
	}
}
