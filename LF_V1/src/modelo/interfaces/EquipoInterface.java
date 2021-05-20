package modelo.interfaces;

import java.util.ArrayList;
import java.util.Map;
import modelo.entidades.Equipo;

public interface EquipoInterface {

	public void altaEquipo(String nombreEquipo, String codLiga);
	
	public void modificarEquipo(String nombreEquipo, String codLiga, String codEquipo);
	
	public void bajaEquipo(Equipo equipo);
	
	public Equipo buscarEquipo(String codE);
	
	public ArrayList<Equipo> todosEquipo(String codL);

	public ArrayList<Equipo> listarTodosEquipo();
	
	public String[][] ultimosPartidos(String codE);

}
