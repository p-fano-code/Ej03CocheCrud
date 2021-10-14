package coche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modCoche {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
			
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			
			String sql = "update cohes set MARCA=?, MODELO=?, KILOMETROS=? WHERE ID=?";
			
			String marca = "Renault";
			String modelo = "Megane";
			int kilometros = 200000;
			int id = 1;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);
			sentencia.setInt(3, kilometros);
			sentencia.setInt(4, id);
			
			//como estamos cambiando datos de la BBDD, hacemos un executeUpdate
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir nuevo coche");
			System.out.println(e.getMessage());
		}		

	}

}
