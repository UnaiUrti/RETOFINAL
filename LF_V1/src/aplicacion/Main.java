	package aplicacion;

import modelo.LigaInterface;
import modelo.LigaMySQLImplementation;
import modelo.UsuarioInterface;
import modelo.UsuarioMySQLImplementation;
import vista.VPrincipal;

public class Main {

	public static void main(String[] args) {
		
		VPrincipal ventanaPrincipal = new VPrincipal();
		ventanaPrincipal.setVisible(true);
		
	}
	
	public static UsuarioInterface cargarUsuario() {
		return new UsuarioMySQLImplementation();
	}

	public static LigaInterface cargarLiga() {
		return new LigaMySQLImplementation();
	}
	
	

}
