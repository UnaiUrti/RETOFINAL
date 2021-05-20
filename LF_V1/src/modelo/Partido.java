package modelo;

import java.time.LocalDate;

public class Partido {

	private String codPartido;
	private LocalDate fechaPartido;
	private int jornada;
	
	
	
	public String getCodPartido() {
		return codPartido;
	}
	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}
	
	public LocalDate getFechaPartido() {
		return fechaPartido;
	}
	public void setFechaPartido(LocalDate fechaPartido) {
		this.fechaPartido = fechaPartido;
	}
	
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}
	
	
}
