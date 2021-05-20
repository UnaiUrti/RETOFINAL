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
	private Map<String, Liga> ligasMap;
	private VAcceder vAcceder;

	/**
	 * Create the dialog.
	 */
	public VConsultaPrincipal(VAcceder vAcceder) {
		
		this.vAcceder = vAcceder;
		ligasMap = datosLiga.todasLiga();
		
		setBounds(100, 100, 599, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblTitulo = new JLabel("CONSULTAR LIGA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cmbLiga = new JComboBox();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(155)
							.addComponent(lblTitulo))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(136)
							.addComponent(lblLiga)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cmbLiga, 0, 157, Short.MAX_VALUE)
							.addGap(47)))
					.addGap(179))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblTitulo)
					.addGap(89)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLiga)
						.addComponent(cmbLiga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(161, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
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

			//PASAR EL MAP A UN ARRAYLIST PARA CONSEGUIR EL OBJETO LIGA DEL INDEX DEL COMBO BOX
			ArrayList<Liga> ligasList = new ArrayList<>(ligasMap.values());
			Liga liga = ligasList.get(pos);
			
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
		
		for (Liga liga : ligasMap.values()) {
			cmbLiga.addItem(liga.getNombreL());
		}
		cmbLiga.setSelectedIndex(-1);
	}
	
	
	private void volverVAcceder() {
		this.dispose();
		vAcceder.setVisible(true);
	}
	
}
