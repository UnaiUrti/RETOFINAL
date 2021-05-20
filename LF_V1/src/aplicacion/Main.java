package aplicacion;

import modelo.UsuarioInterface;
import modelo.UsuarioMySQLImplementation;
import vista.VPrincipal;

public class Main {

	public static void main(String[] args) {
		
		UsuarioInterface datosUsuario = new UsuarioMySQLImplementation();
		
		VPrincipal ventanaPrincipal = new VPrincipal(datosUsuario);
		ventanaPrincipal.setVisible(true);
		
	}

}
