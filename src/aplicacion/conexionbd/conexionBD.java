package aplicacion.conexionbd;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class conexionBD {
	static String URL;
	static String USER;
	static String PASS;
	static String DRIVERS;
	static Connection conexion= null;
	static Statement stmt = null;
public static Connection CrearConexion() throws ClassNotFoundException, SQLException{
	
	Properties propiedades = new Properties();
	try 
	{
		propiedades.load(new FileReader("src\\aplicacion\\conexionbd\\conexion.properties"));
		
		 URL = propiedades.getProperty("host");
		 USER =propiedades.getProperty("user");
		 PASS =propiedades.getProperty("password");
		 DRIVERS =propiedades.getProperty("driver");
		
		

	}catch(Exception e) {
		System.err.println("r4");

	 }
	
	Class.forName(DRIVERS);
	conexion = DriverManager.getConnection(URL, USER, PASS);
	if (conexion != null){
	
	
	return conexion;
	}
	return null;
	}


public static void HacerConsulta() throws Exception{
	
	try 
	{
		stmt = conexion.createStatement();
		ResultSet rs = stmt.executeQuery( "select * from gbp_almacen.gbp_alm_cat_libros;" );

		   while ( rs.next() ) {

		      int id = rs.getInt("id_libro");

		      String  title = rs.getString("titulo");

		      String autor  = rs.getString("autor");
		      
		      String isbn  = rs.getString("isbn");
		      
		      int edicion = rs.getInt("edicion");

		     

		      System.out.println("id: "+id+" titulo: "+title+" autor:"+autor+" isbn: "+isbn+" edicion:"+edicion);

		   }

		   rs.close();

		   stmt.close();

		   conexion.close();
	}catch (Exception e)
	{
		
	}
	
	

	   
	
	}
}




