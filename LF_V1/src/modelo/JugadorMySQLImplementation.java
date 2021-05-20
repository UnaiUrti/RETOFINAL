package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class JugadorMySQLImplementation implements JugadorInterface{

	//ATRIBUTOS DE LA CONEXION A BD
			private Connection con;
			private PreparedStatement stmt;
			
			//SENTENCIAS SQL
			private final String altaJugador="{CALL altaJugador( ? , ? , ? , ? , ? )}";
			private final String modificaJugador="UPDATE jugador SET Nombre_J=? , Dorsal=? , Pais_J=? , Posicion=? , Cod_E=? WHERE Cod_J=?";
			private final String bajaJugador="DELETE FROM jugador WHERE Cod_J=?";
			private final String listarJugadores="SELECT * FROM jugador";
			
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
			public void altaJugador(String nombreJugador, int dorsal, String paisJugador, String posicion, String codEquipo) {
				
				this.openConnection();
				
				try {
					stmt = con.prepareStatement(altaJugador);
					
					stmt.setString(1, nombreJugador);
					stmt.setInt(2, dorsal);
					stmt.setString(3, paisJugador);
					stmt.setString(4, posicion);
					stmt.setString(5, codEquipo);
					
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
			public void modificarJugador(Jugador jugador) {
				
				this.openConnection();
				
				try {
					stmt = con.prepareStatement(modificaJugador);
					
					stmt.setString(6, jugador.getCodJ());
					stmt.setString(1, jugador.getNombreJ());
					stmt.setInt(2, jugador.getDorsal());
					stmt.setString(3, jugador.getPaisJ());
					stmt.setString(4, jugador.getPosicion());
					stmt.setString(5, jugador.getCodE());
					
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
			public void bajaJugador(Jugador jugador) {
				
				this.openConnection();
				
				try {
					stmt = con.prepareStatement(bajaJugador);
					
					stmt.setString(1, jugador.getCodJ());
					
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
			public ArrayList<Jugador> todosJugador() {
				
				ArrayList<Jugador> jugadores = new ArrayList<>();
				Jugador jugador = null;
				
				ResultSet rs = null;
				
				this.openConnection();
				
				try {
					
					stmt = con.prepareStatement(listarJugadores);
					
					rs = stmt.executeQuery();
						
					while(rs.next()) {
						jugador = new Jugador();
						jugador.setCodJ(rs.getString("Cod_J"));
						jugador.setNombreJ(rs.getString("Nombre_J"));
						jugador.setDorsal(rs.getInt("Dorsal"));
						jugador.setPaisJ(rs.getString("Pais_J"));
						jugador.setPosicion(rs.getString("Posicion"));
						jugadores.add(jugador);
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
				
				return jugadores;
				
			}
}
