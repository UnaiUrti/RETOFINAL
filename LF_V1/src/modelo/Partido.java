package modelo;

import java.time.LocalDate;

public class Partido {
	
	private String codP;
	private LocalDate fechaP;
	private int jornadaP;
	private String codELocal;
	private String codEVisitante;
	
	public String getCodP() {
		return codP;
	}
	public void setCodP(String codP) {
		this.codP = codP;
	}
	public LocalDate getFechaP() {
		return fechaP;
	}
	public void setFechaP(LocalDate fechaP) {
		this.fechaP = fechaP;
	}
	public int getJornadaP() {
		return jornadaP;
	}
	public void setJornadaP(int jornadaP) {
		this.jornadaP = jornadaP;
	}
	public String getCodELocal() {
		return codELocal;
	}
	public void setCodELocal(String codELocal) {
		this.codELocal = codELocal;
	}
	public String getCodEVisitante() {
		return codEVisitante;
	}
	public void setCodEVisitante(String codEVisitante) {
		this.codEVisitante = codEVisitante;
	}
	
}
