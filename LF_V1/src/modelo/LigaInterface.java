package modelo;

import java.util.Map;

public interface LigaInterface {

	public void altaLiga(String nombreLiga, String paisLiga);
	
	public void modificaLiga(Liga liga);
	
	public void bajaLiga(Liga liga);
	
	public Map<String, Liga> todasLiga();
	
}
