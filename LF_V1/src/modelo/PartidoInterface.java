package modelo;

import java.util.ArrayList;

public interface PartidoInterface {

	public void altaPartido(Partido partido);
	
	public void bajaPartido(Partido partido);

	String[][] partidosJornada(String codL, int jornada);
	
}
