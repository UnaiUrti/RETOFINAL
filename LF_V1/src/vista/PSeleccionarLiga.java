package vista;

import javax.swing.JPanel;

import controlador.Main;
import modelo.entidades.Liga;
import modelo.interfaces.LigaInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PSeleccionarLiga extends JPanel {

	private LigaInterface datosLiga = Main.cargarLiga();
	private JComboBox cmbLiga;
	private ArrayList<Liga> todasLigas;
	private VUsuarioMenu usuarioMenu;
	/**
	 * Create the panel.
	 */
	public PSeleccionarLiga(VUsuarioMenu usuarioMenu) {
		
		this.usuarioMenu = usuarioMenu;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblTitulo = new JLabel("CONSULTAR LIGA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(218, 38, 239, 37);
		add(lblTitulo);
		
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLiga.setBounds(199, 149, 44, 25);
		add(lblLiga);
		
		todasLigas = datosLiga.todasLiga();
		
		cmbLiga = new JComboBox();
		cmbLiga.setSelectedIndex(-1);
		cmbLiga.setBounds(275, 154, 157, 22);
		add(cmbLiga);
		
		JButton btnSiguiente = new JButton("CONTINUAR");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verClasificacionLiga();
			}
		});
		btnSiguiente.setBounds(466, 314, 157, 37);
		add(btnSiguiente);
		cargarLiga();
	}
	
	private void verClasificacionLiga() {
		
		if (cmbLiga.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona una liga");
		} else {
			int pos = cmbLiga.getSelectedIndex();
			Liga liga = todasLigas.get(pos);
			
			PClasificacionLiga clasificacionLiga = new PClasificacionLiga(usuarioMenu,liga);
		
			usuarioMenu.cambiarJPanel(clasificacionLiga);
		}
	}
	
	private void cargarLiga() {
		
		for (Liga liga : todasLigas) {
			cmbLiga.addItem(liga.getNombreL());
		}
		cmbLiga.setSelectedIndex(-1);
	}
}
