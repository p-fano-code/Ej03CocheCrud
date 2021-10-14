package coche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delCoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
				
		// Paso 2: Interactuar con la BD
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			
			String sql = "DELETE FROM COHES WHERE ID=?"; 
			
			int id = 1;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setInt(1, id);
			
			//Como estamos cambiando registros, executeUpdate
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al borrar el coche");
			System.out.println(e.getMessage());
		}

	}

}
