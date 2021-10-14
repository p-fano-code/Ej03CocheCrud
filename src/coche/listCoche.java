package coche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class listCoche {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COHES");
			ResultSet rs = sentencia.executeQuery();//no cambia registros, se usa para consultas
			while (rs.next()) {//preguntamos si hay mas filas
				System.out.print(rs.getInt("ID"));//DAME EL VALOR DE LA COLUMNA ID
				System.out.print(" - "); 
				System.out.print(rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print(rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print(rs.getInt("KILOMETROS"));
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}		
	}

}


