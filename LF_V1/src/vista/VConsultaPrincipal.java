package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.Main;
import modelo.Liga;
import modelo.LigaInterface;
import modelo.UsuarioInterface;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;

public class VConsultaPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LigaInterface datosLiga = Main.cargarLiga();
	private JComboBox cmbLiga;
	private ArrayList<Liga> todasLigas;

	/**
	 * Create the dialog.
	 */
	public VConsultaPrincipal() {
		
		todasLigas = datosLiga.todasLiga();
		
		setBounds(100, 100, 599, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblTitulo = new JLabel("CONSULTAR LIGA");
		lblTitulo.setBounds(160, 42, 239, 37);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setBounds(141, 168, 44, 25);
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cmbLiga = new JComboBox();
		cmbLiga.setBounds(195, 173, 157, 22);
		contentPanel.setLayout(null);
		contentPanel.add(lblTitulo);
		contentPanel.add(lblLiga);
		contentPanel.add(cmbLiga);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						consultarLiga();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnVolver = new JButton("Volver");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volverVAcceder();
					}
				});
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
		
		cargarLiga();
		
	}
	
	private void consultarLiga() {
		if (cmbLiga.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona una liga");
		} else {
			int pos = cmbLiga.getSelectedIndex();
			
			Liga liga = todasLigas.get(pos);
			
			VConsultarLiga2 vConsultarLiga2 = new VConsultarLiga2(this,liga);
			
			//VCoche vent = new VCoche(ven, true, coches.get(matricula), datos);
			vConsultarLiga2.setVisible(true);
			this.dispose();
		}
	}
	
	/*
	private void consultarLiga() {
		if (cmbLiga.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Selecciona una liga");
		} else {
			String nombreL= (String) cmbLiga.getSelectedItem();

			VConsultarLiga vConsultarLiga = new VConsultarLiga();
			this.setVisible(false);
			vConsultarLiga.setVisible(true);
		}
	}
	*/
	private void cargarLiga() {
		
		for (Liga liga : todasLigas) {
			cmbLiga.addItem(liga.getNombreL());
		}
		cmbLiga.setSelectedIndex(-1);
	}
	
	
	private void volverVAcceder() {
		this.dispose();
		vAcceder.setVisible(true);
	}
	
}
