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
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VBaja extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ArrayList <Liga> ligas;
	private ArrayList<Equipo> equipos;
	private ArrayList<Jugador> jugadores;
	private JComboBox <String> cmbLiga;
	private JComboBox <String> cmbEquipo;
	private JComboBox <String> cmbJugador;
	private EquipoInterface datosEquipo = Main.cargarEquipo();
	private LigaInterface datosLiga = Main.cargarLiga();
	private JugadorInterface datosJugador = Main.cargarJugador();

	/**
	 * Create the dialog.
	 */
	public VBaja(boolean bajaOculto) {
		setBounds(100, 100, 600, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(50, 39, 72, 25);
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setBounds(87, 126, 30, 19);
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(87, 195, 47, 19);
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setBounds(87, 262, 56, 19);
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbJugador = new JComboBox();
		cmbJugador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbJugador.removeAllItems();
				cmbJugador.addItem("");
				cargarJugadores();
			}
		});
		cmbJugador.setBounds(153, 262, 118, 22);
		cmbEquipo = new JComboBox();
		cmbEquipo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cmbEquipo.removeAllItems();
				cmbEquipo.addItem("");
				cargarEquipos();
			}
		});
		cmbEquipo.setBounds(152, 195, 119, 22);
		cmbLiga = new JComboBox();
		cmbLiga.setBounds(153, 126, 119, 22);
		JButton btnBaja = new JButton("BAJA");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();
			}
		});
		btnBaja.setBounds(437, 154, 57, 23);
		contentPanel.setLayout(null);
		contentPanel.add(lblJugador);
		contentPanel.add(cmbJugador);
		contentPanel.add(lblEquipo);
		contentPanel.add(lblLiga);
		contentPanel.add(cmbLiga);
		contentPanel.add(cmbEquipo);
		contentPanel.add(btnBaja);
		contentPanel.add(lblEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(403, 224, 91, 23);
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
		
		if(bajaOculto) {
			btnBaja.setEnabled(false);
		}else {
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
		
		if(cmbLiga.getSelectedIndex()!=-1) {
			int pos=cmbLiga.getSelectedIndex();
			String codigoLiga = ligas.get(pos).getCodL();
			
			equipos = datosEquipo.todosEquipo(codigoLiga);
			
			for (Equipo equipo : equipos) {
				cmbEquipo.addItem(equipo.getNombreE());
			}
		}
	}
	
	private void cargarJugadores() {
		if(cmbEquipo.getSelectedIndex()>0) {
			int pos=cmbEquipo.getSelectedIndex();
			String codigoEquipo = equipos.get(pos-1).getCodE();
			
			jugadores = datosJugador.todosJugador(codigoEquipo);
			
			for (Jugador jugador : jugadores) {
				cmbJugador.addItem(jugador.getNombreJ() +"  "+ jugador.getDorsal());
			}
		}
	}
	
	
	
	private void baja() {
		if(cmbJugador.getSelectedIndex()>0) {
			bajaJugador();
		}else if(cmbEquipo.getSelectedIndex()>0) {
			bajaEquipo();
		}else if(cmbLiga.getSelectedIndex()!=-1) {
			bajaLiga();
		}else {
			JOptionPane.showMessageDialog(this, "TIENES QUE ELEGIR POR LO MENOS UNA LIGA");
		}
	}

	private void modificar() {
		if(cmbJugador.getSelectedIndex()>0) {
			int pos=(cmbJugador.getSelectedIndex())-1;
			
			System.out.println(jugadores.get(pos).getCodE());
			
			VInsertarJugador ventanaJugador = new VInsertarJugador(true, jugadores.get(pos));
			this.dispose();
			ventanaJugador.setVisible(true);
		}else if(cmbEquipo.getSelectedIndex()>0) {
			int pos=(cmbEquipo.getSelectedIndex())-1;
			VInsertarEquipo ventanaEquipo = new VInsertarEquipo(true, equipos.get(pos));
			this.dispose();
			ventanaEquipo.setVisible(true);
		}else if(cmbLiga.getSelectedIndex()!=-1) {
			int pos=cmbLiga.getSelectedIndex();
			VInsertarLiga ventanaLiga = new VInsertarLiga(true, ligas.get(pos));
			this.dispose();
			ventanaLiga.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(this, "TIENES QUE ELEGIR POR LO MENOS UNA LIGA");
		}
	}
	
	
	
	private void bajaJugador() {
		int pos=cmbJugador.getSelectedIndex();
		datosJugador.bajaJugador(jugadores.get(pos-1));
		JOptionPane.showMessageDialog(this, "JUGADOR ELIMINADO CORRECTAMENTE");
	}
	
	private void bajaEquipo() {
		int pos=cmbEquipo.getSelectedIndex();
		datosEquipo.bajaEquipo(equipos.get(pos-1));
		JOptionPane.showMessageDialog(this, "EQUIPO ELIMINADO CORRECTAMENTE");
	}
	
	private void bajaLiga() {
		int pos=cmbLiga.getSelectedIndex();
		datosLiga.bajaLiga(ligas.get(pos));
		JOptionPane.showMessageDialog(this, "LIGA ELIMINADA CORRECTAMENTE");
	}
}
