package modelo;

import java.util.ArrayList;

public interface PartidoInterface {

	public void altaPartido(Partido partido);
	
	public void bajaPartido(Partido partido);
	
	public ArrayList<Partido> todosPartido();
	
	public String[][] ultimosPartidos(String codE);
	
}
