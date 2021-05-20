package vista;

import javax.swing.JPanel;

import controlador.Main;
import modelo.interfaces.EquipoInterface;
import modelo.interfaces.JugadorInterface;
import modelo.interfaces.LigaInterface;
import modelo.entidades.Equipo;
import modelo.entidades.Jugador;
import modelo.entidades.Liga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PEliminarModificarMenu extends JPanel {

	private ArrayList<Liga> ligas;
	private ArrayList<Equipo> equipos;
	private ArrayList<Jugador> jugadores;
	private JComboBox<String> cmbLiga;
	private JComboBox<String> cmbEquipo;
	private JComboBox<String> cmbJugador;
	private EquipoInterface datosEquipo = Main.cargarEquipo();
	private LigaInterface datosLiga = Main.cargarLiga();
	private JugadorInterface datosJugador = Main.cargarJugador();
	private VAdminMenu adminMenu;

	public PEliminarModificarMenu(VAdminMenu adminMenu, boolean bajaOculto) {

		this.adminMenu = adminMenu;

		setLayout(null);
		this.setBounds(246, 11, 697, 403);

		JLabel lblEliminarbaja = new JLabel("Eliminar/Baja");
		lblEliminarbaja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEliminarbaja.setBounds(58, 36, 135, 44);
		add(lblEliminarbaja);

		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLiga.setBounds(152, 115, 30, 19);
		add(lblLiga);

		cmbLiga = new JComboBox();
		cmbLiga.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cmbEquipo.removeAllItems();
				cmbEquipo.addItem("");
				cargarEquipos();
				cmbEquipo.setSelectedIndex(-1);
			}
		});
		cmbLiga.setSelectedIndex(-1);
		cmbLiga.setBounds(229, 115, 119, 22);
		add(cmbLiga);

		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo.setBounds(152, 183, 47, 19);
		add(lblEquipo);

		cmbEquipo = new JComboBox();
		cmbEquipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cmbJugador.removeAllItems();
				cmbJugador.addItem("");
				cargarJugadores();
				cmbJugador.setSelectedIndex(-1);
			}
		});
		/*cmbEquipo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbEquipo.removeAllItems();
				cmbEquipo.addItem("");
				cargarEquipos();
			}
		});*/
		cmbEquipo.setBounds(229, 183, 119, 22);
		add(cmbEquipo);

		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJugador.setBounds(152, 249, 56, 19);
		add(lblJugador);

		cmbJugador = new JComboBox();
		cmbJugador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbJugador.removeAllItems();
				cmbJugador.addItem("");
				cargarJugadores();
			}
		});
		cmbJugador.setBounds(229, 249, 118, 22);
		add(cmbJugador);

		JButton btnBaja = new JButton("BAJA");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();
			}
		});
		btnBaja.setBounds(369, 336, 100, 30);
		add(btnBaja);

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(503, 336, 135, 30);
		add(btnModificar);

		if (bajaOculto) {
			btnBaja.setEnabled(false);
		} else {
			btnModificar.setEnabled(false);
		}

		cargarLigas();
		cmbLiga.setSelectedIndex(-1);

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

	private void cargarJugadores() {
		if (cmbEquipo.getSelectedIndex() > 0) {
			int pos = cmbEquipo.getSelectedIndex();
			String codigoEquipo = equipos.get(pos - 1).getCodE();

			jugadores = datosJugador.todosJugador(codigoEquipo);

			for (Jugador jugador : jugadores) {
				cmbJugador.addItem(jugador.getNombreJ() + "  " + jugador.getDorsal());
			}
		}
	}

	private void baja() {
		if (cmbJugador.getSelectedIndex() > 0) {
			bajaJugador();
		} else if (cmbEquipo.getSelectedIndex() > 0) {
			bajaEquipo();
		} else if (cmbLiga.getSelectedIndex() != -1) {
			bajaLiga();
		} else {
			JOptionPane.showMessageDialog(this, "TIENES QUE ELEGIR POR LO MENOS UNA LIGA");
		}
	}

	private void modificar() {
		if (cmbJugador.getSelectedIndex() > 0) {
			int pos = (cmbJugador.getSelectedIndex()) - 1;

			PInsertarJugador insertarJugador = new PInsertarJugador(true, jugadores.get(pos));
			adminMenu.cambiarJPanel(insertarJugador);
		} else if (cmbEquipo.getSelectedIndex() > 0) {
			int pos = (cmbEquipo.getSelectedIndex()) - 1;
			PInsertarEquipo insertarEquipo = new PInsertarEquipo(true, equipos.get(pos));
			adminMenu.cambiarJPanel(insertarEquipo);
		} else if (cmbLiga.getSelectedIndex() != -1) {
			int pos = cmbLiga.getSelectedIndex();
			PInsertarLiga insertarLiga = new PInsertarLiga(true, ligas.get(pos));
			adminMenu.cambiarJPanel(insertarLiga);
		} else {
			JOptionPane.showMessageDialog(this, "TIENES QUE ELEGIR POR LO MENOS UNA LIGA");
		}
	}

	private void bajaJugador() {
		int pos = cmbJugador.getSelectedIndex();
		datosJugador.bajaJugador(jugadores.get(pos - 1));
		JOptionPane.showMessageDialog(this, "JUGADOR ELIMINADO CORRECTAMENTE");
	}

	private void bajaEquipo() {
		int pos = cmbEquipo.getSelectedIndex();
		datosEquipo.bajaEquipo(equipos.get(pos - 1));
		JOptionPane.showMessageDialog(this, "EQUIPO ELIMINADO CORRECTAMENTE");
	}

	private void bajaLiga() {
		int pos = cmbLiga.getSelectedIndex();
		datosLiga.bajaLiga(ligas.get(pos));
		JOptionPane.showMessageDialog(this, "LIGA ELIMINADA CORRECTAMENTE");
	}

}
