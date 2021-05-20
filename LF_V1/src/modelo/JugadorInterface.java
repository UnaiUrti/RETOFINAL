package modelo;

import java.util.Map;

public interface JugadorInterface {

	public void altaJugador(String nombreJugador, int dorsalJugador, String paisJugador, String posicionJugador, String codEquipo);
	
	public void modificarJugador(Jugador jugador);
	
	public void bajaJugador(Jugador jugador);
	
	public Map<String, Jugador> todosJugador();
}
