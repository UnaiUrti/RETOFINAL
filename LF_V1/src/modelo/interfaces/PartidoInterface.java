package modelo.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.entidades.Partido;

public interface PartidoInterface {

	public void altaPartido(LocalDate fechaPartido, int jornada, String codEquipoL, String codEquipoV);
	
	public void modificarPartido(Partido partido);
	
	public void bajaPartido(Partido partido);
	
	public ArrayList<Partido> todosPartido();
	
	public String[][] partidosJornada(String codL, int jornada);
	
	public int[] jornadasLiga(String codL);
	
	public String[][] buscarPartido(String codP);
	
	public String[][] partidoGoles(String codP);
	
}
