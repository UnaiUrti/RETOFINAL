package modelo;

import java.util.Map;

public interface EquipoInterface {

	public void altaEquipo(String nombreEquipo, String codLiga);
	
	public void modificarEquipo(Equipo equipo);
	
	public void bajaEquipo(Equipo equipo);
	
	public Equipo buscarEquipo(String codE);
	
	public Map<String, Equipo> todosEquipo();
	
	public String[][] ultimosPartidos(String codE);

}
