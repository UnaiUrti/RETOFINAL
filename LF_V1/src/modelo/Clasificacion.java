package modelo;

//CLASE NECESARIA PARA PODER GUARDAR LOS DATOS DEL PROCEDIMIENTO CALCULAR_CLASIFICAION
//AL MENOS QUE SEAS UN FKING GENIO Y SEPAS COMO HACERLO DE OTRA FORMA

public class Clasificacion {

	private int puesto;
	private String codE;
	private String nombreE;
	private int pJugados;
	private int pGanados;
	private int pEmpatados;
	private int pPerdidos;
	private int gAFavor;
	private int gEnContra;
	private int ptsTotal;
	
	public int getPuesto() {
		return puesto;
	}
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	public String getCodE() {
		return codE;
	}
	public void setCodE(String codE) {
		this.codE = codE;
	}
	public String getNombreE() {
		return nombreE;
	}
	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}
	public int getpJugados() {
		return pJugados;
	}
	public void setpJugados(int pJugados) {
		this.pJugados = pJugados;
	}
	public int getpGanados() {
		return pGanados;
	}
	public void setpGanados(int pGanados) {
		this.pGanados = pGanados;
	}
	public int getpEmpatados() {
		return pEmpatados;
	}
	public void setpEmpatados(int pEmpatados) {
		this.pEmpatados = pEmpatados;
	}
	public int getpPerdidos() {
		return pPerdidos;
	}
	public void setpPerdidos(int pPerdidos) {
		this.pPerdidos = pPerdidos;
	}
	public int getgAFavor() {
		return gAFavor;
	}
	public void setgAFavor(int gAFavor) {
		this.gAFavor = gAFavor;
	}
	public int getgEnContra() {
		return gEnContra;
	}
	public void setgEnContra(int gEnContra) {
		this.gEnContra = gEnContra;
	}
	public int getPtsTotal() {
		return ptsTotal;
	}
	public void setPtsTotal(int ptsTotal) {
		this.ptsTotal = ptsTotal;
	}
	
	
	
}
