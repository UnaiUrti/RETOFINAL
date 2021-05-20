package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public interface PartidoInterface {
	public void altaPartido(LocalDate fechaPartido, int jornada, String codEquipoL, String codEquipoV);
	
	public void modificarPartido(Partido partido);
	
	public void bajaPartido(Partido partido);
	
	public ArrayList<Partido> todosPartido();
}
