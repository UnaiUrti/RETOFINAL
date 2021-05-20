package modelo.interfaces;

import java.util.ArrayList;

import modelo.entidades.Liga;

public interface LigaInterface {

	public void altaLiga(String nombreLiga, String paisLiga);
	
	public void modificaLiga(String nombreLiga, String paisLiga, String codLiga);
	
	public void bajaLiga(Liga liga);
	
	public ArrayList<Liga> todasLiga();
	
	public String[][] tablaClasificacion(String codL);
	
}
