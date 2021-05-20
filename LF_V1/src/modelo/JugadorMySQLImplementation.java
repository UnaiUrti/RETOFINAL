package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import modelo.interfaces.JugadorInterface;
import modelo.entidades.Equipo;
import modelo.entidades.Jugador;

public class JugadorMySQLImplementation implements JugadorInterface {

	// ATRIBUTOS DE LA CONEXION A BD
	private Connection con;
	private PreparedStatement stmt;

	/* CONDFIGURACION */
	private String driver;
	private String url;
	private String user;
	private String passwd;
	private ResourceBundle configFile;

	// SENTENCIAS SQL
	private final String altaJugador = "{CALL altaJugador( ? , ? , ? , ? , ? )}";
	private final String modificaJugador = "UPDATE jugador SET Nombre_J=? , Dorsal=? , Pais_J=? , Posicion=? , Cod_E=? WHERE Cod_J=?";
	private final String bajaJugador = "DELETE FROM jugador WHERE Cod_J=?";
	private final String buscarJugador = "SELECT * FROM jugador WHERE Cod_J=? ";
	private final String listarJugadores = "SELECT * FROM jugador WHERE Cod_E=?";

	/* CONEXION CON EL ARCHIVO DE CONFIGURACION */
	public JugadorMySQLImplementation() {
		this.configFile = ResourceBundle.getBundle("modelo.config");
		this.driver = this.configFile.getString("driver");
		this.url = this.configFile.getString("url");
		this.user = this.configFile.getString("user");
		this.passwd = this.configFile.getString("passwd");
	}

	// CONEXION CON LA BD
	public void openConnection() {
		try {

			// CONEXION XAMPP
			con = DriverManager.getConnection(this.url, this.user, this.passwd);
			// String url =
			// "jdbc:mysql://localhost:3306/liga_futbol?serverTimezone=Europe/Madrid&useSSL=false";
			// con = DriverManager.getConnection(url, "root", "abcd*1234");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	// CERRAR LA CONEXION CON LA BD
	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
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
	public void modificarJugador(String nombreJugador, int dorsal, String paisJugador, String posicion,
			String codEquipo, String codJugador) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(modificaJugador);

			stmt.setString(6, codJugador);
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

	public Jugador buscarJugador(String codJ) {

		Jugador jugador = null;
		ResultSet rs = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(buscarJugador);

			stmt.setString(1, codJ);

			rs = stmt.executeQuery();

			if (rs.next()) {
				jugador = new Jugador();
				jugador.setCodJ(rs.getString("Cod_J"));
				jugador.setNombreJ(rs.getString("Nombre_J"));
				jugador.setDorsal(rs.getInt("Dorsal"));
				jugador.setPaisJ(rs.getString("Pais_J"));
				jugador.setPosicion(rs.getString("Posicion"));
				jugador.setCodE(rs.getString("Cod_E"));
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (rs != null) {
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

		return jugador;

	}
	
	@Override
	public ArrayList<Jugador> todosJugador(String codEquipo) {

		ArrayList<Jugador> jugadores = new ArrayList<>();
		Jugador jugador = null;

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(listarJugadores);
			stmt.setString(1, codEquipo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				jugador = new Jugador();
				jugador.setCodJ(rs.getString("Cod_J"));
				jugador.setNombreJ(rs.getString("Nombre_J"));
				jugador.setDorsal(rs.getInt("Dorsal"));
				jugador.setPaisJ(rs.getString("Pais_J"));
				jugador.setPosicion(rs.getString("Posicion"));
				jugador.setCodE(rs.getString("Cod_E"));
				jugadores.add(jugador);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (rs != null) {
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
