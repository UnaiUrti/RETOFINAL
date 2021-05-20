package modelo.interfaces;

import java.util.ArrayList;
import modelo.entidades.Jugador;

public interface JugadorInterface {

	public void altaJugador(String nombreJugador, int dorsalJugador, String paisJugador, String posicionJugador, String codEquipo);
	
	public void modificarJugador(String nombreJugador, int dorsalJugador, String paisJugador, String posicionJugador, String codEquipo, String codJugador);
	
	public void bajaJugador(Jugador jugador);
	
	public Jugador buscarJugador(String codJ);
	
	public ArrayList<Jugador> todosJugador(String codEquipo);
	
}
