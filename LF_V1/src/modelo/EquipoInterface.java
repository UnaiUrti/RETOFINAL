package modelo;

import java.util.ArrayList;
import java.util.Map;

public interface EquipoInterface {

	public void altaEquipo(String nombreEquipo, String codLiga);
	
	public void modificarEquipo(Equipo equipo);
	
	public void bajaEquipo(Equipo equipo);
	
	public ArrayList<Equipo> todosEquipo(String codL);

}
