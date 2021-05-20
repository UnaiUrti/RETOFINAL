package modelo;

import java.util.ArrayList;

public interface GolInterface {

	public void altaGol(int minGol, String codJugador);

	public Equipo[] sacarEquipos();
	
	public void bajaGol(Gol gol);
	
	public ArrayList<Gol> todosGol();
}
