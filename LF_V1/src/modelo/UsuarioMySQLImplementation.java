package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import modelo.interfaces.UsuarioInterface;
import modelo.entidades.Usuario;

public class UsuarioMySQLImplementation implements UsuarioInterface{

	//ATRIBUTOS DE LA CONEXION A BD
	private Connection con;
	private PreparedStatement stmt;
	
	/*CONDFIGURACION*/
	private String driver;
	private String url;
	private String user;
	private String passwd;
	private ResourceBundle configFile;
	
	//SENTENCIAS SQL
	private final String altaUsuario="INSERT INTO usuario VALUES(?, ?, ?)";
	private final String listarUsuarios="SELECT * FROM usuario";
	
	/*CONEXION CON EL ARCHIVO DE CONFIGURACION*/
	public UsuarioMySQLImplementation() {
		this.configFile = ResourceBundle.getBundle("modelo.config");
		this.driver = this.configFile.getString("driver");
		this.url = this.configFile.getString("url");
		this.user = this.configFile.getString("user");
		this.passwd = this.configFile.getString("passwd");
	}
	
	//CONEXION CON LA BD
	public void openConnection() {
		try {
			
			//CONEXION XAMPP
			con = DriverManager.getConnection(this.url, this.user, this.passwd);
			//String url = "jdbc:mysql://localhost:3306/liga_futbol?serverTimezone=Europe/Madrid&useSSL=false";
			//con = DriverManager.getConnection(url, "root", "abcd*1234");
			
			
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
	
	
	public void altaUsuario(Usuario usuario) {
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(altaUsuario);
			
			stmt.setString(1, usuario.getNombreU());
			stmt.setString(2, usuario.getContrasenaU());
			stmt.setBoolean(3, usuario.isAdmin());
			
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
	
	public Map<String, Usuario> todosUsuarios() {
		
		Map<String, Usuario> usuarios = new TreeMap<>();
		Usuario usuario = null;
		
		ResultSet rs = null;
		
		this.openConnection();
		
		try {
			
			stmt = con.prepareStatement(listarUsuarios);
			
			rs = stmt.executeQuery();
				
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setNombreU(rs.getString("Nombre_U"));
				usuario.setContrasenaU(rs.getString("Contraseña_U"));
				usuario.setAdmin(rs.getBoolean("Admin"));
				usuarios.put(usuario.getNombreU(), usuario);
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
		
		return usuarios;
		
	}
	
	
	
}
