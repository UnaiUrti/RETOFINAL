package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import modelo.interfaces.EquipoInterface;
import modelo.entidades.Equipo;

public class EquipoMySQLImplementation implements EquipoInterface {

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
	private final String altaEquipo = "{CALL altaEquipo( ? , ? )}";
	private final String modificaEquipo = "UPDATE equipo SET Nombre_E=? , Cod_L=? WHERE Cod_E=?";
	private final String bajaEquipo = "DELETE FROM equipo WHERE Cod_E=?";
	private final String listarEquipos = "SELECT * FROM equipo WHERE Cod_L=?";
	private final String listarTodosEquipos = "SELECT * FROM equipo";

	/* CONEXION CON EL ARCHIVO DE CONFIGURACION */
	public EquipoMySQLImplementation() {
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
	public void altaEquipo(String nombreEquipo, String codLiga) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(altaEquipo);

			stmt.setString(1, nombreEquipo);
			stmt.setString(2, codLiga);

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
	public void modificarEquipo(String nombreEquipo, String codLiga, String codEquipo) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(modificaEquipo);

			stmt.setString(3, codEquipo);
			stmt.setString(1, nombreEquipo);
			stmt.setString(2, codLiga);

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
	public void bajaEquipo(Equipo equipo) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(bajaEquipo);

			stmt.setString(1, equipo.getCodE());

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
	public ArrayList<Equipo> todosEquipo(String codLiga) {

		ArrayList<Equipo> equipos = new ArrayList<>();
		Equipo equipo = null;

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(listarEquipos);
			stmt.setString(1, codLiga);
			rs = stmt.executeQuery();

			while (rs.next()) {
				equipo = new Equipo();
				equipo.setCodE(rs.getString("Cod_E"));
				equipo.setNombreE(rs.getString("Nombre_E"));
				equipo.setCodL(rs.getString("Cod_L"));
				equipos.add(equipo);
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

		return equipos;

	}

	@Override
	public ArrayList<Equipo> listarTodosEquipo() {

		ArrayList<Equipo> equipos = new ArrayList<>();
		Equipo equipo = null;

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(listarTodosEquipos);
			rs = stmt.executeQuery();

			while (rs.next()) {
				equipo = new Equipo();
				equipo.setCodE(rs.getString("Cod_E"));
				equipo.setNombreE(rs.getString("Nombre_E"));
				equipo.setCodL(rs.getString("Cod_L"));
				equipos.add(equipo);
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

		return equipos;

	}
}
