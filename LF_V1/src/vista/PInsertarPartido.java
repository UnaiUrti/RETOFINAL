package vista;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import controlador.Main;
import modelo.interfaces.EquipoInterface;
import modelo.interfaces.LigaInterface;
import modelo.interfaces.PartidoInterface;
import modelo.entidades.Equipo;
import modelo.entidades.Liga;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PInsertarPartido extends JPanel {
	
	private JTextField textGolesL;
	private JTextField textGolesV;
	private JTextField textJornada;
	private JDateChooser fecha;
	private ArrayList<Liga> ligas;
	private ArrayList<Equipo> equipos;
	private String[] codEquipos;
	private EquipoInterface datosEquipo = Main.cargarEquipo();
	private LigaInterface datosLiga = Main.cargarLiga();
	private PartidoInterface datosPartido = Main.cargarPartido();
	private JComboBox <String> cmbLiga;
	private JComboBox <String> cmbEquipoL;
	private JComboBox <String> cmbEquipoV;
	private VAdminMenu adminMenu;

	public PInsertarPartido(VAdminMenu adminMenu) {

		this.adminMenu = adminMenu;
		
		setLayout(null);
		this.setBounds(246, 11, 697, 403);
		
		JLabel lblInsertarPartido = new JLabel("Insertar Partido");
		lblInsertarPartido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertarPartido.setBounds(48, 34, 139, 25);
		add(lblInsertarPartido);
		
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLiga.setBounds(256, 103, 50, 19);
		add(lblLiga);
		
		cmbLiga = new JComboBox();
		cmbLiga.setSelectedIndex(-1);
		cmbLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbLiga.setBounds(312, 99, 94, 27);
		add(cmbLiga);
		
		JLabel lblEquipoL = new JLabel("Equipo Local:");
		lblEquipoL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipoL.setBounds(91, 176, 84, 19);
		add(lblEquipoL);
		
		JLabel lblEquipoV = new JLabel("Equipo Visitante:");
		lblEquipoV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipoV.setBounds(91, 234, 106, 19);
		add(lblEquipoV);
		
		cmbEquipoL = new JComboBox();
		cmbEquipoL.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbEquipoL.removeAllItems();
				cargarEquiposL();
			}
		});
		cmbEquipoL.setBounds(219, 176, 121, 22);
		add(cmbEquipoL);
		
		cmbEquipoV = new JComboBox();
		cmbEquipoV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbEquipoV.removeAllItems();
				cargarEquiposV();
			}
		});
		cmbEquipoV.setBounds(219, 234, 121, 22);
		add(cmbEquipoV);
		
		JLabel lblGolesL = new JLabel("Goles Local");
		lblGolesL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGolesL.setBounds(401, 180, 72, 19);
		add(lblGolesL);
		
		JLabel lblGolesV = new JLabel("Goles Visitante");
		lblGolesV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGolesV.setBounds(401, 238, 94, 19);
		add(lblGolesV);
		
		textGolesL = new JTextField();
		textGolesL.setColumns(10);
		textGolesL.setBounds(522, 181, 96, 20);
		add(textGolesL);
		
		textGolesV = new JTextField();
		textGolesV.setColumns(10);
		textGolesV.setBounds(522, 239, 96, 20);
		add(textGolesV);
		
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJornada.setBounds(219, 292, 56, 19);
		add(lblJornada);
		
		textJornada = new JTextField();
		textJornada.setColumns(10);
		textJornada.setBounds(295, 293, 46, 20);
		add(textJornada);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(401, 293, 41, 17);
		add(lblFecha);
		
		JButton btnAlta = new JButton("ALTA");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPartido();
			}
		});
		btnAlta.setBounds(389, 350, 120, 23);
		add(btnAlta);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnModificar.setBounds(522, 350, 120, 23);
		add(btnModificar);
		
		fecha = new JDateChooser();
		fecha.setBounds(522, 291, 96, 20);
		add(fecha);
		
		cargarLigas();
		cmbLiga.setSelectedIndex(-1);
		
	}

	private void altaPartido() {

		if (textGolesL.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONER LA CANTIDAD DE GOLES (SI NO HA HABIDO GOLES PON 0)");
		} else if (textGolesV.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONER LA CANTIDAD DE GOLES (SI NO HA HABIDO GOLES PON 0)");
		} else if (fecha.getDate() == null) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR LA FECHA EN LA QUE SE JUGO EL PARTIDO");
		} else if (textJornada.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR LA JORNADA DEL PARTIDO");
		} else if (cmbEquipoL.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR UN PARTIDO");
		} else if (cmbEquipoV.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR UN PARTIDO");
		} else if (cmbEquipoL.getSelectedItem().equals(cmbEquipoV.getSelectedItem())) {
			JOptionPane.showMessageDialog(this, "UN EQUIPO NO PUEDE JUGAR CONSIGO MISMO. DEBES CAMBIAR UNO DE LOS DOS");
		} else {

			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			String textFecha = formateador.format(fecha.getDate());

			int posL = cmbEquipoL.getSelectedIndex();
			int posV = cmbEquipoV.getSelectedIndex();
			String codigoEquipoL = equipos.get(posL).getCodE();
			String codigoEquipoV = equipos.get(posV).getCodE();

			datosPartido.altaPartido(LocalDate.parse(textFecha), Integer.parseInt(textJornada.getText()), codigoEquipoL,
					codigoEquipoV);

			JOptionPane.showMessageDialog(this, "Partido dado de alta correctamente");

			int cantGol = Integer.parseInt(textGolesL.getText()) + Integer.parseInt(textGolesV.getText());

			if (cantGol > 0) {
				//cambiar el jpanel
				PInsertarGol insertarGol = new PInsertarGol(adminMenu,Integer.parseInt(textGolesL.getText()), Integer.parseInt(textGolesV.getText()));
				adminMenu.cambiarJPanel(insertarGol);
			}

			fecha.setDateFormatString("");
			textGolesL.setText("");
			textGolesV.setText("");
			textJornada.setText("");
			cmbLiga.setSelectedIndex(-1);
			cmbEquipoL.setSelectedIndex(-1);
			cmbEquipoV.setSelectedIndex(-1);
		}

	}

	private void cargarLigas() {

		ligas = datosLiga.todasLiga();

		for (Liga liga : ligas) {
			cmbLiga.addItem(liga.getNombreL());
		}

	}

	private void cargarEquiposL() {

		if (cmbLiga.getSelectedIndex() != -1) {
			int pos = cmbLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();

			equipos = datosEquipo.todosEquipo(codigoLiga);

			for (Equipo equipo : equipos) {
				cmbEquipoL.addItem(equipo.getNombreE());
			}
		}
	}

	private void cargarEquiposV() {

		if (cmbLiga.getSelectedIndex() != -1) {
			int pos = cmbLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();

			equipos = datosEquipo.todosEquipo(codigoLiga);

			for (Equipo equipo : equipos) {
				cmbEquipoV.addItem(equipo.getNombreE());
			}
		}
	}
	
}
