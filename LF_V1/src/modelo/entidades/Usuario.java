package modelo.entidades;

public class Usuario {
	
	private String nombreU;
	private String contrasenaU;
	private boolean admin;
	
	public String getNombreU() {
		return nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

	public String getContrasenaU() {
		return contrasenaU;
	}

	public void setContrasenaU(String contrasenaU) {
		this.contrasenaU = contrasenaU;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
