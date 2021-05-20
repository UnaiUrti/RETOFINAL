package aplicacion;

import modelo.EquipoInterface;
import modelo.EquipoMySQLImplementation;
import modelo.LigaInterface;
import modelo.LigaMySQLImplementation;
import modelo.UsuarioInterface;
import modelo.UsuarioMySQLImplementation;
import vista.VConsultarEquipo;
import vista.VInsertarEquipo;
import vista.VPrincipal;

public class Main {

	public static void main(String[] args) {
		
		VInsertarEquipo  ventanaEquipo = new VInsertarEquipo();
		ventanaEquipo.setVisible(true);
		
		
		/*
		VPrincipal ventanaPrincipal = new VPrincipal(datosUsuario, datosLiga);
		ventanaPrincipal.setVisible(true);
		*/
	}
	
	public static EquipoInterface cargarEquipo(){
		return new EquipoMySQLImplementation();
	}
	
	
	
	

}
