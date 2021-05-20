package modelo;

import java.util.ArrayList;
import java.util.Map;

public interface JugadorInterface {

	public void altaJugador(String nombreJugador, int dorsalJugador, String paisJugador, String posicionJugador, String codEquipo);
	
	public void modificarJugador(String nombreJugador, int dorsalJugador, String paisJugador, String posicionJugador, String codEquipo, String codJugador);
	
	public void bajaJugador(Jugador jugador);
	
	public ArrayList<Jugador> todosJugador(String codEquipo);
}
