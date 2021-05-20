package modelo;

import java.util.ArrayList;
import java.util.Map;

public interface LigaInterface {

	public void altaLiga(Liga liga);
	
	public void modificaLiga(Liga liga);
	
	public void bajaLiga(Liga liga);
	
	public ArrayList<Liga> todasLiga();
	
	public String[][] tabla(String codLiga);
	
}
