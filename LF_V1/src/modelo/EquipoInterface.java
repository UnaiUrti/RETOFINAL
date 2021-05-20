package modelo;

import java.util.ArrayList;
import java.util.Map;

public interface EquipoInterface {

	public void altaEquipo(String nombreEquipo, String codLiga);
	
	public void modificarEquipo(String nombreEquipo, String codLiga, String codEquipo);
	
	public void bajaEquipo(Equipo equipo);
	
	public ArrayList<Equipo> todosEquipo(String codL);

	ArrayList<Equipo> listarTodosEquipo();

}
