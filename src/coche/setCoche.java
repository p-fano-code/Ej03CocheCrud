package coche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class setCoche {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";

		// Paso 2: Interactuar con la BD
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COHES");
			ResultSet rs = sentencia.executeQuery();
			
			List<Coche> listadoCoches = new ArrayList<Coche>();
			while (rs.next()) {
				Coche c = new Coche();
				c.setId(rs.getInt("ID"));
				c.setMarca(rs.getString("MARCA"));
				c.setModelo(rs.getString("MODELO"));
				c.setKilometros(rs.getInt("KILOMETROS"));
				
				listadoCoches.add(c);
			}

			System.out.println(listadoCoches);
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de coches");
			System.out.println(e.getMessage());
		}
	}
}
