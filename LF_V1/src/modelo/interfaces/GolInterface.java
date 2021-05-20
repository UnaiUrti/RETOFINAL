package modelo.interfaces;

import java.util.ArrayList;
import modelo.entidades.Equipo;
import modelo.entidades.Gol;

public interface GolInterface {

	public void altaGol(int minGol, String codJugador);

	public Equipo[] sacarEquipos();
	
	public void bajaGol(Gol gol);
	
	public ArrayList<Gol> todosGol();
}
