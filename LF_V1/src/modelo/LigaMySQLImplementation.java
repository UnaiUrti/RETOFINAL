package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class LigaMySQLImplementation implements LigaInterface {

	//ATRIBUTOS DE LA CONEXION A BD
	private Connection con;
	private PreparedStatement stmt;
	
	//SENTENCIAS SQL
	private final String altaLiga = "INSERT INTO liga VALUES(?, ?, ?)";
	private final String modificaLiga = "UPDATE liga SET Nombre_L=?, Pais_L=? WHERE Cod_L=?";
	private final String bajaLiga = "DELETE FROM liga WHERE Cod_L=?";
	private final String listarLigas = "SELECT * FROM liga";
	private final String clasificacionLiga = "{CALL calcular_clasificacion(?)}";
	
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
	public void altaLiga(Liga liga) {
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(altaLiga);
			
			stmt.setString(1, liga.getCodL());
			stmt.setString(2, liga.getNombreL());
			stmt.setString(3, liga.getPaisL());
			
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
	public void modificaLiga(Liga liga) {
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(modificaLiga);
			
			stmt.setString(3, liga.getCodL());
			stmt.setString(1, liga.getNombreL());
			stmt.setString(2, liga.getPaisL());
			
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
	public void bajaLiga(Liga liga) {
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(bajaLiga);
			
			stmt.setString(1, liga.getCodL());
			
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
	public Map<String, Liga> todasLiga() {
		
		Map<String, Liga> ligas = new TreeMap<>();
		Liga liga = null;
		
		ResultSet rs = null;
		
		this.openConnection();
		
		try {
			
			stmt = con.prepareStatement(listarLigas);
			
			rs = stmt.executeQuery();
				
			while(rs.next()) {
				liga = new Liga();
				liga.setCodL(rs.getString("Cod_L"));
				liga.setNombreL(rs.getString("Nombre_L"));
				liga.setPaisL(rs.getString("Pais_L"));
				ligas.put(liga.getCodL(), liga);
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
		
		return ligas;
		
	}

	public ArrayList<Clasificacion> tablaClasificacion(String codLiga) {
		
		ArrayList<Clasificacion> clasificacion = new ArrayList<>();
		Clasificacion clasi;
		
		ResultSet rs = null;
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(clasificacionLiga);
	
			stmt.setString(1, codLiga);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				clasi = new Clasificacion();
				
				clasi.setPuesto(rs.getInt("Puesto"));
				clasi.setCodE(rs.getString("Cod_E"));
				clasi.setNombreE(rs.getString("Nombre_E"));
				clasi.setpJugados(rs.getInt("P_jugados"));
				clasi.setpGanados(rs.getInt("P_ganados"));
				clasi.setpEmpatados(rs.getInt("P_empatados"));
				clasi.setpPerdidos(rs.getInt("P_perdidos"));
				clasi.setgAFavor(rs.getInt("G_aFavor"));
				clasi.setgEnContra(rs.getInt("G_enContra"));
				clasi.setPtsTotal(rs.getInt("Pts_total"));
				
				clasificacion.add(clasi);
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
		
		return clasificacion;
	}	
	
}
