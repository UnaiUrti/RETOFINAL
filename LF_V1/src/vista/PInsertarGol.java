package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;

import controlador.Main;
import modelo.entidades.Equipo;
import modelo.interfaces.GolInterface;
import modelo.entidades.Jugador;
import modelo.interfaces.JugadorInterface;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PInsertarGol extends JPanel {

	private JTextField textEquipo;
	private JTextField textGol;
	private JTextField textMinuto;
	private JComboBox cmbGoleador;
	private ArrayList<Jugador> dorsales;
	private GolInterface datosGol = Main.cargarGol();
	private JugadorInterface datosJugador = Main.cargarJugador();
	Equipo[] equipos = datosGol.sacarEquipos();
	private VAdminMenu adminMenu;

	private int numGolL = 1;
	private int numGolV = 1;

	private int golesLocal;
	private int golesVisitante;

	public PInsertarGol(VAdminMenu adminMenu, int golesL, int golesV) {

		this.adminMenu = adminMenu;
		
		this.golesLocal = golesL;
		this.golesVisitante = golesV;

		setLayout(null);
		this.setBounds(246, 11, 697, 403);

		JLabel lblInsertarGol = new JLabel("Insertar Gol");
		lblInsertarGol.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarGol.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInsertarGol.setBounds(231, 46, 202, 43);
		add(lblInsertarGol);

		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo.setBounds(153, 122, 80, 33);
		add(lblEquipo);

		textEquipo = new JTextField();
		textEquipo.setEditable(false);
		textEquipo.setColumns(10);
		textEquipo.setBounds(243, 130, 95, 20);
		add(textEquipo);

		JLabel lblGol = new JLabel("Gol num");
		lblGol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGol.setBounds(397, 122, 65, 33);
		add(lblGol);

		textGol = new JTextField();
		textGol.setEditable(false);
		textGol.setColumns(10);
		textGol.setBounds(461, 130, 39, 20);
		add(textGol);

		JLabel lblGoleador = new JLabel("Goleador (dorsal):");
		lblGoleador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGoleador.setBounds(153, 207, 128, 33);
		add(lblGoleador);

		cmbGoleador = new JComboBox();
		cmbGoleador.setBounds(319, 214, 56, 22);
		add(cmbGoleador);

		JLabel lblMinuto = new JLabel("Minuto (entre 0 - 90):");
		lblMinuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMinuto.setBounds(153, 263, 156, 33);
		add(lblMinuto);

		textMinuto = new JTextField();
		textMinuto.setColumns(10);
		textMinuto.setBounds(319, 271, 45, 20);
		add(textMinuto);

		JButton btnAlta = new JButton("ALTA");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (golesLocal > 0) {
					golesLocal--;
					//System.out.println(golesLocal);
				} else if (golesVisitante > 0) {
					golesVisitante--;
					//System.out.println(golesVisitante);

				}
				altaGol();
			}
		});
		btnAlta.setBounds(537, 348, 105, 33);
		add(btnAlta);

		cargarEquipo();
		cargarNumGol();
		cargarDorsal();

		textEquipo.setEditable(false);
		textGol.setEditable(false);

	}

	private void altaGol() {

		int goleador = cmbGoleador.getSelectedIndex();
		String codigoGoleador = buscarGoleador(goleador);

		if (Integer.parseInt(textMinuto.getText()) <= 0 || Integer.parseInt(textMinuto.getText()) > 90) {
			JOptionPane.showMessageDialog(null, "EL MINUTO DEL GOL TIENE QUE SER ENTRE 0 Y 90");
		} else if (textMinuto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "DEBES INTRODUCIR EL MINUTO EN QUE SE MARCO EL GOL");
		} else if (cmbGoleador.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "DEBES INTRODUCIR EL GOLEADOR QUE MARCO EL GOL");
		} else {

			datosGol.altaGol(Integer.parseInt(textMinuto.getText()), codigoGoleador);

			JOptionPane.showMessageDialog(this, "Gol dado de alta correctamente");

			textEquipo.setText("");
			textGol.setText("");
			cmbGoleador.removeAllItems();
			textMinuto.setText("");

			cargarEquipo();
			cargarNumGol();
			cargarDorsal();
		}

	}

	private void cargarDorsal() {

		if (golesLocal > 0) {
			dorsales = datosJugador.todosJugador(equipos[0].getCodE());
		} else if (golesVisitante > 0) {
			dorsales = datosJugador.todosJugador(equipos[1].getCodE());
		}

		Collections.sort(dorsales);

		for (Jugador jugador : dorsales) {
			cmbGoleador.addItem(jugador.getDorsal());
		}

	}

	private void cargarEquipo() {

		if (golesLocal > 0) {
			textEquipo.setText(equipos[0].getNombreE());
		} else if (golesVisitante > 0) {
			textEquipo.setText(equipos[1].getNombreE());
		} else {
			PInsertarPartido insertarPartido = new PInsertarPartido(adminMenu);
			adminMenu.cambiarJPanel(insertarPartido);
		}
	}

	private void cargarNumGol() {

		if (golesLocal > 0) {
			textGol.setText(Integer.toString(numGolL));
			numGolL++;

		} else if (golesVisitante > 0) {
			textGol.setText(Integer.toString(numGolV));
			numGolV++;

		}
	}

	private String buscarGoleador(int goleador) {

		String codigoGoleador = null;

		for (Jugador jugador : dorsales) {
			if (dorsales.get(goleador).getDorsal() == jugador.getDorsal()) {
				codigoGoleador = jugador.getCodJ();
			}
		}

		return codigoGoleador;
	}

}
