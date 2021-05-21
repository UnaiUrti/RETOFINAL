package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import controlador.Main;
import modelo.interfaces.EquipoInterface;
import modelo.entidades.Equipo;
import modelo.entidades.Liga;
import modelo.interfaces.LigaInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PInsertarEquipo extends JPanel {
	
	private JTextField textNombre;
	private ArrayList<Liga> ligas;
	private JComboBox <String> comboLiga;
	private EquipoInterface datosEquipo = Main.cargarEquipo();
	private LigaInterface datosLiga = Main.cargarLiga();
	private Equipo equipo;
	

	public PInsertarEquipo(boolean altaOculto, Equipo equipo) {

		this.equipo = equipo;
		
		setLayout(null);
		this.setBounds(246, 11, 697, 403);
		
		JLabel lblTitulo = new JLabel("Insertar Equipo");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(239, 51, 241, 61);
		add(lblTitulo);
		
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLiga.setBounds(215, 137, 81, 24);
		add(lblLiga);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(215, 204, 93, 24);
		add(lblNombre);
		
		comboLiga = new JComboBox();
		comboLiga.setSelectedIndex(-1);
		comboLiga.setBounds(306, 142, 142, 22);
		add(comboLiga);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(306, 210, 142, 20);
		add(textNombre);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEquipo();
			}
		});
		btnAlta.setBounds(407, 331, 120, 34);
		add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarEquipo();
			}
		});
		btnModificar.setBounds(537, 331, 120, 34);
		add(btnModificar);
		
		cargarLigas();

		if (altaOculto) {
			btnAlta.setEnabled(false);

			comboLiga.setSelectedItem(buscarLiga(equipo).getNombreL());

			textNombre.setText(equipo.getNombreE());
		} else {
			btnModificar.setEnabled(false);
		}
		
		
	}
	
	private void modificarEquipo() {
		
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
	
	
	private Liga buscarLiga(Equipo equipo) {
		Liga suLiga = null;
		
		for (Liga liga : ligas) {
			if(liga.getCodL().equals(equipo.getCodL())) {
				suLiga = liga;
			}
		}
		
		return suLiga;
	}
	
	private void cargarLigas() {
		
		ligas = datosLiga.todasLiga();
		
		for (Liga liga : ligas) {
			comboLiga.addItem(liga.getNombreL());
		}
		
	}
	
	private void altaEquipo() {

		if (textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN NOMBRE AL EQUIPO");
		} else if (comboLiga.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "DEBES METER EL EQUIPO EN UNA LIGA");
		} else {
			int pos = comboLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();

			datosEquipo.altaEquipo(textNombre.getText(), codigoLiga);

			JOptionPane.showMessageDialog(this, "Equipo dado de alta correctamente");
			textNombre.setText("");
			comboLiga.setSelectedIndex(-1);
		}

	}
	
	
}
