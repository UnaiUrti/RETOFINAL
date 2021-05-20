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
import modelo.interfaces.JugadorInterface;
import modelo.interfaces.LigaInterface;
import modelo.entidades.Jugador;
import modelo.entidades.Equipo;
import modelo.entidades.Liga;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PInsertarJugador extends JPanel {

	private JTextField textNombre;
	private JTextField textPais;
	private JTextField textDorsal;
	private ArrayList<Liga> ligas;
	private ArrayList<Equipo> equipos;
	private JComboBox<String> cmbLiga;
	private JComboBox<String> cmbEquipo;
	private JComboBox<String> cmbPosicion;
	private EquipoInterface datosEquipo = Main.cargarEquipo();
	private LigaInterface datosLiga = Main.cargarLiga();
	private JugadorInterface datosJugador = Main.cargarJugador();
	private Jugador jugador;

	public PInsertarJugador(boolean altaOculto, Jugador jugador) {

		this.jugador = jugador;

		setLayout(null);
		this.setBounds(246, 11, 697, 403);

		JLabel lblInsertarJugador = new JLabel("Insertar Jugador");
		lblInsertarJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertarJugador.setBounds(59, 51, 158, 25);
		add(lblInsertarJugador);

		JLabel lblLiga = new JLabel("Liga: ");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLiga.setBounds(105, 114, 60, 19);
		add(lblLiga);

		cmbLiga = new JComboBox();
		cmbLiga.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cmbEquipo.removeAllItems();
				cargarEquipos();
				cmbEquipo.setSelectedIndex(-1);
			}
		});
		/*cmbLiga.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cmbEquipo.removeAllItems();
				cargarEquipos();
			}
		});*/
		cmbLiga.setSelectedIndex(-1);
		cmbLiga.setBounds(177, 114, 107, 22);
		add(cmbLiga);

		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo.setBounds(105, 153, 60, 19);
		add(lblEquipo);

		cmbEquipo = new JComboBox();
		cmbEquipo.setBounds(177, 153, 107, 22);
		add(cmbEquipo);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(105, 216, 62, 19);
		add(lblNombre);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(177, 217, 105, 20);
		add(textNombre);

		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPais.setBounds(105, 246, 46, 19);
		add(lblPais);

		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setBounds(177, 248, 105, 20);
		add(textPais);

		JLabel lblDorsal = new JLabel("Dorsal: ");
		lblDorsal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDorsal.setBounds(396, 216, 50, 19);
		add(lblDorsal);

		textDorsal = new JTextField();
		textDorsal.setColumns(10);
		textDorsal.setBounds(469, 217, 35, 20);
		add(textDorsal);

		JLabel lblPosicion = new JLabel("Posicion: ");
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosicion.setBounds(396, 250, 60, 19);
		add(lblPosicion);

		cmbPosicion = new JComboBox();
		cmbPosicion.setModel(new DefaultComboBoxModel(new String[] { "DEL", "MD", "DEF", "POR" }));
		cmbPosicion.setBounds(467, 247, 61, 22);
		add(cmbPosicion);

		JButton btnAlta = new JButton("ALTA");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaJugador();
			}
		});
		btnAlta.setBounds(482, 338, 57, 23);
		add(btnAlta);

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarJugador();
			}
		});
		btnModificar.setBounds(562, 338, 91, 23);
		add(btnModificar);

		cargarLigas();
		cmbLiga.setSelectedIndex(-1);

		if (altaOculto) {
			btnAlta.setEnabled(false);


			cmbLiga.setSelectedItem(buscarLiga(jugador).getNombreL());

			cmbEquipo.setSelectedItem(buscarEquipo(jugador));

			textNombre.setText(jugador.getNombreJ());
			textDorsal.setText(Integer.toString(jugador.getDorsal()));
			textPais.setText(jugador.getPaisJ());
			cmbPosicion.setSelectedItem(jugador.getPosicion());
		} else {
			btnModificar.setEnabled(false);
		}

	}

	private Liga buscarLiga(Jugador jugador) {
		Liga suLiga = null;
		Equipo codE = null;

		equipos = datosEquipo.listarTodosEquipo();
		for (Equipo equipo : equipos) {
			if (equipo.getCodE().equals(jugador.getCodE())) {
				codE = equipo;
			}
		}
		for (Liga liga : ligas) {
			if (codE.getCodL().equals(liga.getCodL())) {
				suLiga = liga;
			}
		}

		return suLiga;
	}

	private Equipo buscarEquipo(Jugador jugador) {
		Equipo suEquipo = null;

		for (Equipo equipo : equipos) {
			if (equipo.getCodE().equals(jugador.getCodE())) {
				suEquipo = equipo;
			}
		}

		return suEquipo;
	}

	private void cargarLigas() {

		ligas = datosLiga.todasLiga();

		for (Liga liga : ligas) {
			cmbLiga.addItem(liga.getNombreL());
		}

	}

	private void cargarEquipos() {

		if (cmbLiga.getSelectedIndex() != -1) {
			int pos = cmbLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();

			equipos = datosEquipo.todosEquipo(codigoLiga);

			for (Equipo equipo : equipos) {
				cmbEquipo.addItem(equipo.getNombreE());
			}
		}
	}

	private void modificarJugador() {

		if (textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "EL JUGADOR TIENE QUE TENER UN NOMBRE");
		} else if (textDorsal.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR EL DORSAL DEL JUGADOR");
		} else if (textPais.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "EL JUGADOR TIENE QUE SER DE ALGUN PAIS");
		} else if (cmbPosicion.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UNA POSICION AL JUGADOR");
		} else if (cmbEquipo.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "EL JUGADOR TIENE QUE SER DE ALGUN EQUIPO");
		} else {
			int pos = cmbEquipo.getSelectedIndex();
			String codigoEquipo = equipos.get(pos).getCodE();

			datosJugador.modificarJugador(textNombre.getText(), Integer.parseInt(textDorsal.getText()),
					textPais.getText(), cmbPosicion.getSelectedItem().toString(), codigoEquipo, jugador.getCodJ());

			JOptionPane.showMessageDialog(this, "Jugador modificado correctamente");
		}
	}

	private void altaJugador() {

		if (textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "EL JUGADOR TIENE QUE TENER UN NOMBRE");
		} else if (textDorsal.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR EL DORSAL DEL JUGADOR");
		} else if (textPais.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "EL JUGADOR TIENE QUE SER DE ALGUN PAIS");
		} else if (cmbPosicion.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UNA POSICION AL JUGADOR");
		} else if (cmbEquipo.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "EL JUGADOR TIENE QUE SER DE ALGUN EQUIPO");
		} else if (textDorsal.getText().equals()
		
		}else {
			int pos = cmbEquipo.getSelectedIndex();
			String codigoEquipo = equipos.get(pos).getCodE();

			datosJugador.altaJugador(textNombre.getText(), Integer.parseInt(textDorsal.getText()), textPais.getText(),
					cmbPosicion.getSelectedItem().toString(), codigoEquipo);

			JOptionPane.showMessageDialog(this, "Jugador dado de alta correctamente");
			textNombre.setText("");
			textPais.setText("");
			textDorsal.setText("");
			cmbLiga.setSelectedIndex(-1);
			cmbEquipo.setSelectedIndex(-1);
			cmbPosicion.setSelectedIndex(-1);
		}

	}

}
