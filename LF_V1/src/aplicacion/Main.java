package aplicacion;

import modelo.EquipoInterface;
import modelo.EquipoMySQLImplementation;
import modelo.GolInterface;
import modelo.GolMySQLImplementation;
import modelo.JugadorInterface;
import modelo.JugadorMySQLImplementation;
import modelo.LigaInterface;
import modelo.LigaMySQLImplementation;
import modelo.PartidoInterface;
import modelo.PartidoMySQLImplementation;
import modelo.UsuarioInterface;
import modelo.UsuarioMySQLImplementation;
import vista.VConsultarEquipo;
import vista.VInsertarEquipo;
import vista.VInsertarJugador;
import vista.VInsertarLiga;
import vista.VInsertarPartido;
import vista.VInsertarPrincipal;
import vista.VModoAdmin;
import vista.VPrincipal;

public class Main {

	public static void main(String[] args) {
		
		/*
		VInsertarLiga  ventanaLiga = new VInsertarLiga();
		ventanaLiga.setVisible(true);
		*/
	
		/*
		VInsertarEquipo  ventanaEquipo = new VInsertarEquipo();
		ventanaEquipo.setVisible(true);
		*/
		
		/*
		VInsertarJugador  ventanaJugador = new VInsertarJugador();
		ventanaJugador.setVisible(true);
		*/
		
		
		VInsertarPartido  ventanaPartido = new VInsertarPartido();
		ventanaPartido.setVisible(true);
		
		
		/*
		VInsertarPrincipal  ventanaInsertarPrincipal = new VInsertarPrincipal();
		ventanaInsertarPrincipal.setVisible(true);
		*/
		
		/*
		VModoAdmin  ventanaAdmin = new VModoAdmin();
		ventanaAdmin.setVisible(true);
		*/
		
		/*
		VPrincipal ventanaPrincipal = new VPrincipal(datosUsuario, datosLiga);
		ventanaPrincipal.setVisible(true);
		*/
	}
	
	public static EquipoInterface cargarEquipo(){
		return new EquipoMySQLImplementation();
	}
	public static LigaInterface cargarLiga() {
		return new LigaMySQLImplementation();
	}
	public static UsuarioInterface cargarUsuario() {
		return new UsuarioMySQLImplementation();
	}
	public static JugadorInterface cargarJugador() {
		return new JugadorMySQLImplementation();
	}
	public static PartidoInterface cargarPartido() {
		return new PartidoMySQLImplementation();
	}
	public static GolInterface cargarGol() {
		return new GolMySQLImplementation();
	}
	
	
	

}
