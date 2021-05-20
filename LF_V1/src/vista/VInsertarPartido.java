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
import modelo.Liga;
import modelo.LigaInterface;
import modelo.PartidoInterface;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class VInsertarPartido extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
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

	/**
	 * Create the dialog.
	 */
	public VInsertarPartido() {
		setBounds(100, 100, 633, 420);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblInsertarPartido = new JLabel("Insertar Partido");
		lblInsertarPartido.setBounds(28, 11, 139, 25);
		lblInsertarPartido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setBounds(174, 65, 50, 19);
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbLiga = new JComboBox();
		cmbLiga.setBounds(230, 61, 94, 27);
		cmbLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipoL = new JLabel("Equipo Local:");
		lblEquipoL.setBounds(28, 128, 84, 19);
		lblEquipoL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipoV = new JLabel("Equipo Visitante:");
		lblEquipoV.setBounds(22, 184, 106, 19);
		lblEquipoV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbEquipoL = new JComboBox();
		cmbEquipoL.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbEquipoL.removeAllItems();
				cargarEquiposL();
			}
		});
		cmbEquipoL.setBounds(138, 128, 121, 22);
		cmbEquipoV = new JComboBox();
		cmbEquipoV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbEquipoV.removeAllItems();
				cargarEquiposV();
			}
		});
		cmbEquipoV.setBounds(138, 184, 121, 22);
		JLabel lblGolesL = new JLabel("Goles Local");
		lblGolesL.setBounds(342, 128, 72, 19);
		lblGolesL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblGolesV = new JLabel("Goles Visitante");
		lblGolesV.setBounds(342, 184, 94, 19);
		lblGolesV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textGolesL = new JTextField();
		textGolesL.setBounds(440, 129, 96, 20);
		textGolesL.setColumns(10);
		textGolesV = new JTextField();
		textGolesV.setBounds(440, 185, 96, 20);
		textGolesV.setColumns(10);
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setBounds(159, 242, 56, 19);
		lblJornada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(271, 298, 0, 0);
		textJornada = new JTextField();
		textJornada.setBounds(225, 243, 46, 20);
		textJornada.setColumns(10);
		fecha = new JDateChooser();
		fecha.setBounds(393, 243, 121, 20);
		contentPanel.add(fecha);
		JButton btnAlta = new JButton("ALTA");
		btnAlta.setBounds(138, 304, 57, 23);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				altaPartido();
			}
		});
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(342, 304, 91, 23);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(342, 243, 41, 17);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.setLayout(null);
		contentPanel.add(lblFecha);
		contentPanel.add(lblInsertarPartido);
		contentPanel.add(lblEquipoL);
		contentPanel.add(lblEquipoV);
		contentPanel.add(cmbEquipoV);
		contentPanel.add(cmbEquipoL);
		contentPanel.add(btnAlta);
		contentPanel.add(lblGolesV);
		contentPanel.add(lblGolesL);
		contentPanel.add(btnModificar);
		contentPanel.add(textGolesV);
		contentPanel.add(textGolesL);
		contentPanel.add(lblJornada);
		contentPanel.add(textJornada);
		contentPanel.add(lblNewLabel_8);
		contentPanel.add(lblLiga);
		contentPanel.add(cmbLiga);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("RETROCEDER");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volverAtras();
					}
				});
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
		
		cargarLigas();
		cmbLiga.setSelectedIndex(-1);
		
	}
	
	private void altaPartido() {
		
		if(textGolesL.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONER LA CANTIDAD DE GOLES (SI NO HA HABIDO GOLES PON 0)");
		}else if(textGolesV.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONER LA CANTIDAD DE GOLES (SI NO HA HABIDO GOLES PON 0)");
		}else if(fecha.getDate()==null) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR LA FECHA EN LA QUE SE JUGO EL PARTIDO");
		}else if(textJornada.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR LA JORNADA DEL PARTIDO");
		}else if(cmbEquipoL.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR UN PARTIDO");
		}else if(cmbEquipoV.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR UN PARTIDO");
		}else if(cmbEquipoL.getSelectedItem().equals(cmbEquipoV.getSelectedItem())) {
			JOptionPane.showMessageDialog(this, "UN EQUIPO NO PUEDE JUGAR CONSIGO MISMO. DEBES CAMBIAR UNO DE LOS DOS");
		}else {
			
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			String textFecha = formateador.format(fecha.getDate());
			
			int posL=cmbEquipoL.getSelectedIndex();
			int posV=cmbEquipoV.getSelectedIndex();
			String codigoEquipoL = equipos.get(posL).getCodE();
			String codigoEquipoV = equipos.get(posV).getCodE();

			datosPartido.altaPartido(LocalDate.parse(textFecha), Integer.parseInt(textJornada.getText()), codigoEquipoL, codigoEquipoV);
				
			JOptionPane.showMessageDialog(this, "Partido dado de alta correctamente");
			
			int cantGol = Integer.parseInt(textGolesL.getText()) + Integer.parseInt(textGolesV.getText());
			
			if(cantGol>0) {
				VInsertarGol ventanaGol = new VInsertarGol(Integer.parseInt(textGolesL.getText()), Integer.parseInt(textGolesV.getText()));
				ventanaGol.setVisible(true);
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
		
		if(cmbLiga.getSelectedIndex()!=-1) {
			int pos=cmbLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();
			
			equipos = datosEquipo.todosEquipo(codigoLiga);
			
			for (Equipo equipo : equipos) {
				cmbEquipoL.addItem(equipo.getNombreE());
			}
		}
	}

	private void cargarEquiposV() {
		
		if(cmbLiga.getSelectedIndex()!=-1) {
			int pos=cmbLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();
			
			equipos = datosEquipo.todosEquipo(codigoLiga);
			
			for (Equipo equipo : equipos) {
				cmbEquipoV.addItem(equipo.getNombreE());
			}
		}
	}

	private void volverAtras() {
		this.dispose();
		VInsertarPrincipal  ventanaInsertarPrincipal = new VInsertarPrincipal();
		ventanaInsertarPrincipal.setVisible(true);
		
	}
}
