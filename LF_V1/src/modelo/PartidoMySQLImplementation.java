package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartidoMySQLImplementation implements PartidoInterface {

	//ATRIBUTOS DE LA CONEXION A BD
		private Connection con;
		private PreparedStatement stmt;
		
		//SENTENCIAS SQL
		private final String altaPartido = "INSERT INTO partido VALUES(?, ?, ?)";
		private final String bajaPartido = "DELETE FROM liga WHERE Cod_L=?";
		private final String partidosJornada = "{CALL partidos_jornada(?,?)}";
		private final String jornadas = "{CALL jornadas_liga(?)}";
		
		//CONEXION CON LA BD
		public void openConnection() {
			try {
				String url = "jdbc:mysql://localhost:3306/liga_futbol?serverTimezone=Europe/Madrid&useSSL=false";
				//con = DriverManager.getConnection(url+"?" +"user=root&password=abcd*1234");
				con = DriverManager.getConnection(url, "root", "abcd*1234");
				
			} catch (SQLException e) {
				System.out.println("Error al intentar abrir la BD");
			} 
		}
		
		//CERRAR LA CONEXION CON LA BD
		private void closeConnection() throws SQLException {
			if (stmt != null) {
			stmt.close();
			}
			if(con != null) {
			con.close();
			}
		}
		
		@Override
		public void altaPartido(Partido partido) {
			
			this.openConnection();
			
			try {
				stmt = con.prepareStatement(altaPartido);
				
				// Sin hacer
				
				stmt.executeUpdate();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				this.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void bajaPartido(Partido partido) {
			
			this.openConnection();
			
			try {
				stmt = con.prepareStatement(bajaPartido);
				
				// Sin hacer
				
				stmt.executeUpdate();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				this.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public String[][] partidosJornada(String codL, int jornada) {

			String[][] partidosJornadaL = null; 
			
			ResultSet rs = null;
			
			this.openConnection();
			
			try {
				stmt = con.prepareStatement(partidosJornada);
		
				stmt.setString(1, codL);
				stmt.setInt(2, jornada);
				
				rs = stmt.executeQuery();
				
				int i = 0;
				
				rs.last();
				i = rs.getRow();
		        rs.beforeFirst();
			
		        partidosJornadaL = new String[i][5];
				
				i = 0;
				
				while(rs.next()) {
					
					partidosJornadaL[i][0] = rs.getDate("Fecha").toLocalDate().toString();
					partidosJornadaL[i][1] = rs.getString("Equipo_L");
					partidosJornadaL[i][2] = String.valueOf(rs.getInt("Goles_L"));
					partidosJornadaL[i][3] = String.valueOf(rs.getInt("Goles_V"));
					partidosJornadaL[i][4] = rs.getString("Equipo_V");
					
					i++;
						
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			try {
				this.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return partidosJornadaL;
			
		}
		
		public int[] jornadasLiga(String codL) {

			int[] jornadasL = null; 
			
			ResultSet rs = null;
			
			this.openConnection();
			
			try {
				stmt = con.prepareStatement(jornadas);
		
				stmt.setString(1, codL);
				
				rs = stmt.executeQuery();
				
				int i = 0;
				
				rs.last();
				i = rs.getRow();
		        rs.beforeFirst();
			
		        jornadasL = new int[i];
				
				i = 0;
				
				while(rs.next()) {
					
					jornadasL[i] =rs.getInt("Jornada_P");
					
					i++;
						
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			try {
				this.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return jornadasL;
			
		}
		
}
