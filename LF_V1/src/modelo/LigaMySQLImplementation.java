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
	public ArrayList<Liga> todasLiga() {
		
		ArrayList<Liga> ligas = new ArrayList<>();
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
				ligas.add(liga);
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
	
	public String[][] tablaClasificacion(String codL) {

		String[][] clasi = null; 
		
		ResultSet rs = null;
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(clasificacionLiga);
	
			stmt.setString(1, codL);
			
			rs = stmt.executeQuery();
			
			int i = 0;
			
			rs.last();
			i = rs.getRow();
	        rs.beforeFirst();
		
			clasi = new String[i][10];
			
			i = 0;
			
			while(rs.next()) {
				
				clasi[i][0] = String.valueOf(rs.getInt("Puesto"));
				clasi[i][1] = rs.getString("Cod_E");
				clasi[i][2] = rs.getString("Nombre_E");
				clasi[i][3] = String.valueOf(rs.getInt("P_jugados"));
				clasi[i][4] = String.valueOf(rs.getInt("P_ganados"));
				clasi[i][5] = String.valueOf(rs.getInt("P_empatados"));
				clasi[i][6] = String.valueOf(rs.getInt("P_perdidos"));
				clasi[i][7] = String.valueOf(rs.getInt("G_aFavor"));
				clasi[i][8] = String.valueOf(rs.getInt("G_enContra"));
				clasi[i][9] = String.valueOf(rs.getInt("Pts_total"));
				
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
		
		return clasi;
		
	}
	
}
