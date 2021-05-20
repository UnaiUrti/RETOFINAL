package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import modelo.entidades.Gol;
import modelo.entidades.Equipo;
import modelo.interfaces.GolInterface;

public class GolMySQLImplementation implements GolInterface {

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
	private final String altaGol = "{CALL altaGol( ? , ? )}";
	private final String bajaGol = "DELETE FROM gol WHERE Cod_G=?";
	private final String listarGol = "SELECT * FROM gol";
	private final String sacarEquipos = "SELECT equipo.* FROM equipo,juega WHERE equipo.Cod_E=juega.Cod_E ORDER BY juega.Cod_P DESC, juega.esLocal DESC LIMIT 2";

	/* CONEXION CON EL ARCHIVO DE CONFIGURACION */
	public GolMySQLImplementation() {
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
	public void altaGol(int minGol, String codJugador) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(altaGol);

			stmt.setInt(1, minGol);
			stmt.setString(2, codJugador);

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
	public void bajaGol(Gol gol) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(bajaGol);

			stmt.setString(1, gol.getCodGol());

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
	public ArrayList<Gol> todosGol() {

		ArrayList<Gol> goles = new ArrayList<>();
		Gol gol = null;

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(listarGol);

			rs = stmt.executeQuery();

			while (rs.next()) {
				gol = new Gol();
				gol.setCodGol(rs.getString("Cod_G"));
				gol.setMinGol(rs.getInt("min_G"));
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

		return goles;

	}

	public Equipo[] sacarEquipos() {

		Equipo[] equipos = new Equipo[2];
		int cont = 0;

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(sacarEquipos);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Equipo equipo = new Equipo();
				equipo.setCodE(rs.getString("Cod_E"));
				equipo.setCodL(rs.getString("Cod_L"));
				equipo.setNombreE(rs.getString("Nombre_E"));

				equipos[cont] = equipo;
				cont++;
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
