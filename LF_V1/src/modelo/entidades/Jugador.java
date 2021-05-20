package modelo.entidades;

import modelo.entidades.Jugador;

public class Jugador implements Comparable{

	private String codJ;
	private String nombreJ;
	private int dorsal;
	private String paisJ;
	private String posicion;
	private String codE;
	
	
	public String getCodJ() {
		return codJ;
	}
	public void setCodJ(String codJ) {
		this.codJ = codJ;
	}
	public String getNombreJ() {
		return nombreJ;
	}
	public void setNombreJ(String nombreJ) {
		this.nombreJ = nombreJ;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getPaisJ() {
		return paisJ;
	}
	public void setPaisJ(String paisJ) {
		this.paisJ = paisJ;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getCodE() {
		return codE;
	}
	public void setCodE(String codE) {
		this.codE = codE;
	}
	
	@Override
	public int compareTo(Object o) {
		
		int compararDorsal=((Jugador)o).getDorsal();
		
		return this.getDorsal()-compararDorsal;
	}
	
}
