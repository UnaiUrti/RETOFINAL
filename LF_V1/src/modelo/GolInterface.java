package modelo;

import java.util.ArrayList;

public interface GolInterface {

	public void altaGol(int minGol, String codJugador, String codPartido);
	
	public void modificarEquipo(Equipo equipo);
	
	public void bajaEquipo(Equipo equipo);
	
	public ArrayList<Equipo> todosEquipo();
}
