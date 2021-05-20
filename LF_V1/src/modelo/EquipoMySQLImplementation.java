package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import modelo.interfaces.EquipoInterface;
import modelo.entidades.Equipo;

public class EquipoMySQLImplementation implements EquipoInterface {

	// ATRIBUTOS DE LA CONEXION A BD
	private Connection con;
	private PreparedStatement stmt;

	// SENTENCIAS SQL
	private final String altaEquipo = "{CALL altaEquipo( ? , ? )}";
	private final String modificaEquipo = "UPDATE equipo SET Nombre_E=? , Cod_L=? WHERE Cod_E=?";
	private final String bajaEquipo = "DELETE FROM equipo WHERE Cod_E=?";
	private final String buscarEquipo = "SELECT * FROM equipo WHERE Cod_E=?";
	private final String listarEquipos = "SELECT * FROM equipo";

	// CONEXION CON LA BD
	public void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/liga_futbol?serverTimezone=Europe/Madrid&useSSL=false";
			// con = DriverManager.getConnection(url+"?" +"user=root&password=abcd*1234");
			con = DriverManager.getConnection(url, "root", "abcd*1234");

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
	public void modificarEquipo(Equipo equipo) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(modificaEquipo);

			stmt.setString(3, equipo.getCodE());
			stmt.setString(1, equipo.getNombreE());
			stmt.setString(2, equipo.getCodL());

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

	public Equipo buscarEquipo(String codE) {

		Equipo equipo = new Equipo();
		;
		ResultSet rs = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(buscarEquipo);

			stmt.setString(1, codE);

			rs = stmt.executeQuery();

			if (rs.next()) {

				equipo.setCodE(rs.getString("Cod_E"));
				equipo.setNombreE(rs.getString("Nombre_E"));
				equipo.setCodL(rs.getString("Cod_L"));
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

		return equipo;

	}

	@Override
	public Map<String, Equipo> todosEquipo() {

		Map<String, Equipo> equipos = new TreeMap<>();
		Equipo equipo = null;

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(listarEquipos);

			rs = stmt.executeQuery();

			while (rs.next()) {
				equipo = new Equipo();
				equipo.setCodE(rs.getString("Cod_E"));
				equipo.setNombreE(rs.getString("Nombre_E"));
				equipo.setCodL(rs.getString("Cod_L"));
				equipos.put(equipo.getCodE(), equipo);
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
