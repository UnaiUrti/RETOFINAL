package modelo;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import modelo.entidades.Partido;
import modelo.interfaces.PartidoInterface;

public class PartidoMySQLImplementation implements PartidoInterface {
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
	private final String altaPartido = "{CALL altaPartido( ? , ? , ? , ?)}";
	private final String modificaPartido = "UPDATE partido SET Fecha_P=?, Jornada_P=? WHERE Cod_P=?";
	private final String bajaPartido = "DELETE FROM partido WHERE Cod_P=?";
	private final String listarPartidos = "SELECT * FROM partido";

	/* CONEXION CON EL ARCHIVO DE CONFIGURACION */
	public PartidoMySQLImplementation() {
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
	public void altaPartido(LocalDate fechaPartido, int jornada, String codEquipoL, String codEquipoV) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(altaPartido);

			stmt.setDate(1, Date.valueOf(fechaPartido));
			stmt.setInt(2, jornada);
			stmt.setString(3, codEquipoL);
			stmt.setString(4, codEquipoV);

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
	public void modificarPartido(Partido partido) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(modificaPartido);

			stmt.setString(3, partido.getCodPartido());
			stmt.setDate(1, Date.valueOf(partido.getFechaPartido()));
			stmt.setInt(2, partido.getJornada());

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

			stmt.setString(1, partido.getCodPartido());

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
	public ArrayList<Partido> todosPartido() {

		ArrayList<Partido> partidos = new ArrayList<>();
		Partido partido = null;

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(listarPartidos);

			rs = stmt.executeQuery();

			while (rs.next()) {
				partido = new Partido();
				partido.setCodPartido(rs.getString("Cod_P"));
				partido.setFechaPartido(rs.getDate("Fecha_P").toLocalDate());
				partido.setJornada(rs.getInt("Jornada"));
				partidos.add(partido);
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

		return partidos;

	}
}
