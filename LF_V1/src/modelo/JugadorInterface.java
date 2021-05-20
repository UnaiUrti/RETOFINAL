package modelo;

import java.util.ArrayList;

public interface JugadorInterface {

	public void altaJugador(Jugador jugador);
	
	public void modificaJugador(Jugador jugador);
	
	public void bajaJugador(Jugador jugador);
	
	public ArrayList<Jugador> todosJugadoresEquipo(String codE);
	
}
