package coche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainConection {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
		
		Connection con = null;
		try {
			//DriverManager es una clase que gestiona las conexiones, y aqui le
			//pedimos una conexion
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con la BD");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return;
		}
		
		System.out.println("Se ha establecido la conexión con la Base de datos");
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha cerrado la base de datos");
	}
}
