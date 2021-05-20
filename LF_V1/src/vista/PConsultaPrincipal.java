package vista;

import javax.swing.JPanel;

import aplicacion.Main;
import modelo.Liga;
import modelo.LigaInterface;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class PConsultaPrincipal extends JPanel {

	private LigaInterface datosLiga = Main.cargarLiga();
	private JComboBox cmbLiga;
	private ArrayList<Liga> todasLigas;
	/**
	 * Create the panel.
	 */
	public PConsultaPrincipal() {


		
		setLayout(null);
		this.setBounds(246, 11, 612, 364);
		
		JLabel lblTitulo = new JLabel("CONSULTAR LIGA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(169, 38, 239, 37);
		add(lblTitulo);
		
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLiga.setBounds(169, 149, 44, 25);
		add(lblLiga);
		
		todasLigas = datosLiga.todasLiga();
		
		cmbLiga = new JComboBox();
		cmbLiga.setSelectedIndex(-1);
		cmbLiga.setBounds(239, 154, 157, 22);
		add(cmbLiga);
		cargarLiga();
	}
	
	private void cargarLiga() {
		
		for (Liga liga : todasLigas) {
			cmbLiga.addItem(liga.getNombreL());
		}
		cmbLiga.setSelectedIndex(-1);
	}
	
}
