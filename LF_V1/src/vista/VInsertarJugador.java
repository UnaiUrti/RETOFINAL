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
import modelo.JugadorInterface;
import modelo.Liga;
import modelo.LigaInterface;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.Map;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInsertarJugador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textPais;
	private JTextField textDorsal;
	private ArrayList <Liga> ligas;
	private ArrayList<Equipo> equipos;
	private JComboBox <String> cmbLiga;
	private JComboBox <String> cmbEquipo;
	private JComboBox <String> cmbPosicion;
	private EquipoInterface datosEquipo = Main.cargarEquipo();
	private LigaInterface datosLiga = Main.cargarLiga();
	private JugadorInterface datosJugador = Main.cargarJugador();

	/**
	 * Create the dialog.
	 */
	public VInsertarJugador() {
		setBounds(100, 100, 600, 430);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblInsertarJugador = new JLabel("Insertar Jugador");
		lblInsertarJugador.setBounds(64, 33, 158, 25);
		lblInsertarJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbLiga = new JComboBox();
		cmbLiga.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cmbEquipo.removeAllItems();
				buscarEquipos();
			}
		});
		cmbLiga.setBounds(118, 105, 107, 22);
		JLabel lblLiga = new JLabel("Liga: ");
		lblLiga.setBounds(54, 105, 60, 19);
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setBounds(54, 145, 60, 19);
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbEquipo = new JComboBox();
		cmbEquipo.setBounds(118, 145, 107, 22);
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(54, 195, 62, 19);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre = new JTextField();
		textNombre.setBounds(120, 196, 105, 20);
		textNombre.setColumns(10);
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(54, 234, 46, 19);
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPais = new JTextField();
		textPais.setBounds(120, 235, 105, 20);
		textPais.setColumns(10);
		JLabel lblDorsal = new JLabel("Dorsal: ");
		lblDorsal.setBounds(311, 195, 50, 19);
		lblDorsal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDorsal = new JTextField();
		textDorsal.setBounds(379, 196, 35, 20);
		textDorsal.setColumns(10);
		JLabel lblPosicion = new JLabel("Posicion: ");
		lblPosicion.setBounds(342, 234, 60, 19);
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbPosicion = new JComboBox();
		cmbPosicion.setModel(new DefaultComboBoxModel(new String[] {"DEL", "MD", "DEF", "POR"}));
		cmbPosicion.setBounds(412, 234, 61, 22);
		JButton btnAlta = new JButton("ALTA");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaJugador();
			}
		});
		btnAlta.setBounds(120, 310, 57, 23);
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(311, 310, 91, 23);
		contentPanel.setLayout(null);
		contentPanel.add(lblInsertarJugador);
		contentPanel.add(lblLiga);
		contentPanel.add(cmbLiga);
		contentPanel.add(lblEquipo);
		contentPanel.add(cmbEquipo);
		contentPanel.add(lblNombre);
		contentPanel.add(textNombre);
		contentPanel.add(lblDorsal);
		contentPanel.add(textDorsal);
		contentPanel.add(lblPais);
		contentPanel.add(textPais);
		contentPanel.add(lblPosicion);
		contentPanel.add(cmbPosicion);
		contentPanel.add(btnAlta);
		contentPanel.add(btnModificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Cancel");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}

		cargarLigas();
		cmbLiga.setSelectedIndex(-1);
		
	}

	private void altaJugador() {

		/*
		 * String pos= Integer.toString(comboLiga.getSelectedIndex()+1); String
		 * codigoLiga = ""; String codLigNum;
		 * 
		 * for (Liga liga : ligas.values()) {
		 * 
		 * if(liga.getCodL().substring(2).equals("0")) { if(liga.getCodL().substring(3,
		 * liga.getCodL().length()) == pos) { codigoLiga = liga.getCodL(); } } else
		 * if(liga.getCodL().substring(2, liga.getCodL().length()) == pos) { codigoLiga
		 * = liga.getCodL(); } }
		 */

		int pos=cmbEquipo.getSelectedIndex();
		String codigoEquipo = equipos.get(pos).getCodE();

		datosJugador.altaJugador(textNombre.getText(), Integer.parseInt(textDorsal.getText()), textPais.getText(), cmbPosicion.getSelectedItem().toString(), codigoEquipo);

		//
		JOptionPane.showMessageDialog(this, "Jugador dado de alta correctamente");
		textNombre.setText("");
		cmbLiga.setSelectedIndex(-1);

	}

	private void cargarLigas() {

		ligas = datosLiga.todasLiga();

		for (Liga liga : ligas) {
			cmbLiga.addItem(liga.getNombreL());
		}

	}
	
	private void cargarEquipos() {
		
		if(cmbLiga.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Debes elegir una liga");
		}
		else {
			int pos=cmbLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();
			
			equipos = datosEquipo.todosEquipo(codigoLiga);
			
			for (Equipo equipo : equipos) {
				cmbEquipo.addItem(equipo.getNombreE());
			}
		}
	}
	
	private void buscarEquipos() {
		cargarEquipos();
		
	}
}
