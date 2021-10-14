package coche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCoche {

	public static void main(String[] args) {
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
		
			String sql = "INSERT INTO COHES (ID, MARCA, MODELO, KILOMETROS) VALUES (?, ?, ?, ?)"; 
			
			int id = 1;
			String marca = "VolksWagen";
			String modelo = "Golf";
			int kilometros = 130000;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);
			sentencia.setInt(1, id);
			sentencia.setString(2, marca);//
			sentencia.setString(3, modelo);
			sentencia.setInt(4, kilometros);
			
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
			
		} catch (SQLException e) {
			System.out.println("Error al añadir un coche");
			System.out.println(e.getMessage());
		}
	}
}
