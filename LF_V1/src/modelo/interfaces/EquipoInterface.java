package modelo.interfaces;

import java.util.Map;
import modelo.entidades.Equipo;

public interface EquipoInterface {

	public void altaEquipo(String nombreEquipo, String codLiga);
	
	public void modificarEquipo(Equipo equipo);
	
	public void bajaEquipo(Equipo equipo);
	
	public Equipo buscarEquipo(String codE);
	
	public Map<String, Equipo> todosEquipo();

}
