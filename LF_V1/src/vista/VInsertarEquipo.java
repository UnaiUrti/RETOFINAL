package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.Main;
import modelo.Equipo;
import modelo.EquipoInterface;
import modelo.Jugador;
import modelo.Liga;
import modelo.LigaInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInsertarEquipo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private ArrayList<Liga> ligas;
	private JComboBox <String> comboLiga;
	private EquipoInterface datosEquipo = Main.cargarEquipo();
	private LigaInterface datosLiga = Main.cargarLiga();

	/**
	 * Create the dialog.
	 */
	public VInsertarEquipo(boolean altaOculto, Equipo equipo) {
		setBounds(100, 100, 673, 479);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Insertar Equipo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(49, 45, 157, 61);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Liga:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(38, 164, 81, 24);
			contentPanel.add(lblNewLabel_1);
		}
		
		comboLiga = new JComboBox();
		comboLiga.setSelectedIndex(-1);
		comboLiga.setBounds(81, 167, 142, 22);
		contentPanel.add(comboLiga);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(38, 233, 72, 14);
		contentPanel.add(lblNewLabel_2);
		
		textNombre = new JTextField();
		textNombre.setBounds(120, 232, 103, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEquipo();
			}
		});
		btnAlta.setBounds(81, 352, 89, 23);
		contentPanel.add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificaEquipo(equipo);
			}
		});
		btnModificar.setBounds(207, 352, 89, 23);
		contentPanel.add(btnModificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("RETROCEDER");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volverAtras();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarLigas();
		
		if(altaOculto) {
			btnAlta.setEnabled(false);
			
			cargarLigas();
			comboLiga.setSelectedItem(buscarLiga(equipo).getNombreL());
			
			textNombre.setText(equipo.getNombreE());
		}else {
			btnModificar.setEnabled(false);
		}
	}
	

	private void altaEquipo() {
		
		if(textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN NOMBRE AL EQUIPO");
		}else if(comboLiga.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "DEBES METER EL EQUIPO EN UNA LIGA");
		}else {
			int pos=comboLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();
			
			datosEquipo.altaEquipo(textNombre.getText(), codigoLiga);
			
			//
			JOptionPane.showMessageDialog(this, "Equipo dado de alta correctamente");
			textNombre.setText("");
			comboLiga.setSelectedIndex(-1);
		}
		
		
	}
	
	private void modificaEquipo(Equipo equipo) {
		
		if(textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN NOMBRE AL EQUIPO");
		}else if(comboLiga.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "DEBES METER EL EQUIPO EN UNA LIGA");
		}else {
			int pos=comboLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();
			
			datosEquipo.modificarEquipo(textNombre.getText(), codigoLiga, equipo.getCodE());
			JOptionPane.showMessageDialog(this, "Equipo modificado correctamente");
		}
	}
	
	
	
	private void cargarLigas() {
		
		ligas = datosLiga.todasLiga();
		
		
		for (Liga liga : ligas) {
			comboLiga.addItem(liga.getNombreL());
		}
		
		
	}
	
	private void volverAtras() {
		this.dispose();
		VInsertarPrincipal  ventanaInsertarPrincipal = new VInsertarPrincipal();
		ventanaInsertarPrincipal.setVisible(true);
		
	}
	
	
	
	private Liga buscarLiga(Equipo equipo) {
		Liga suLiga = null;
		
		for (Liga liga : ligas) {
			if(liga.getCodL().equals(equipo.getCodL())) {
				suLiga = liga;
			}
		}
		
		return suLiga;
	}

}
