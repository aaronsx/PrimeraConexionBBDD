package aplicacion.conexionbd;


public class conexionBDMain {

	public static void main(String[] args) {
		 conexionBD bd=new conexionBD();
		try 
		{
			 bd.CrearConexion();
			 bd.HacerConsulta();
			 
		}catch(Exception e) {
			System.err.println("33");

		 }
		
	
	}
}
