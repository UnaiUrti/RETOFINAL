package controlador;

import modelo.interfaces.UsuarioInterface;
import modelo.UsuarioMySQLImplementation;

import modelo.interfaces.EquipoInterface;
import modelo.EquipoMySQLImplementation;

import modelo.interfaces.LigaInterface;
import modelo.LigaMySQLImplementation;

import modelo.interfaces.JugadorInterface;
import modelo.JugadorMySQLImplementation;

import vista.VPrincipalMenu;

public class Main {

	public static void main(String[] args) {
		
		VPrincipalMenu ventanaPrincipal = new VPrincipalMenu();
		ventanaPrincipal.setVisible(true);
		
	}
	
	public static UsuarioInterface cargarUsuario() {
		return new UsuarioMySQLImplementation();
	}

	public static LigaInterface cargarLiga() {
		return new LigaMySQLImplementation();
	}
	
	public static EquipoInterface cargarEquipo() {
		return new EquipoMySQLImplementation();
	}
	
	public static JugadorInterface cargarJugador() {
		return new JugadorMySQLImplementation();
	}

}
