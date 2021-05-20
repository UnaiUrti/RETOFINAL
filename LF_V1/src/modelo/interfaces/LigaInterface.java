package modelo.interfaces;

import java.util.ArrayList;

import modelo.entidades.Liga;

public interface LigaInterface {

	public void altaLiga(Liga liga);
	
	public void modificaLiga(Liga liga);
	
	public void bajaLiga(Liga liga);
	
	public ArrayList<Liga> todasLiga();
	
	public String[][] tablaClasificacion(String codL);
	
}
