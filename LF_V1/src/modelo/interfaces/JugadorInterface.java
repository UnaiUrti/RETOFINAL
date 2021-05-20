package modelo.interfaces;

import java.util.ArrayList;
import modelo.entidades.Jugador;

public interface JugadorInterface {

	public void altaJugador(Jugador jugador);
	
	public void modificaJugador(Jugador jugador);
	
	public void bajaJugador(Jugador jugador);
	
	public ArrayList<Jugador> todosJugadoresEquipo(String codE);
	
}
