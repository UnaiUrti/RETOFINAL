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
import modelo.GolInterface;
import modelo.JugadorInterface;
import modelo.Jugador;
import modelo.Liga;

import javax.swing.ComboBoxEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInsertarGol extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textEquipo;
	private JTextField textGol;
	private JTextField textMinuto;
	private JComboBox cmbGoleador;
	private ArrayList<Jugador> dorsales;
	private GolInterface datosGol = Main.cargarGol();
	private JugadorInterface datosJugador = Main.cargarJugador();
	Equipo[] equipos = datosGol.sacarEquipos();

	private int numGolL=1;
	private int numGolV=1;

	public VInsertarGol(int golesL, int golesV) {
		setBounds(100, 100, 600, 430);
		
		int golesLocal=golesL;
		int golesVisitante=golesV;
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblInsertarGol = new JLabel("Insertar Gol");
		lblInsertarGol.setBounds(41, 30, 105, 25);
		lblInsertarGol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setBounds(41, 97, 52, 19);
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEquipo = new JTextField();
		textEquipo.setBounds(99, 98, 95, 20);
		textEquipo.setColumns(10);
		JLabel lblGol = new JLabel("Gol num");
		lblGol.setBounds(270, 97, 54, 19);
		lblGol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textGol = new JTextField();
		textGol.setBounds(328, 98, 39, 20);
		textGol.setColumns(10);
		JLabel lblGoleador = new JLabel("Goleador (dorsal):");
		lblGoleador.setBounds(99, 170, 117, 19);
		lblGoleador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbGoleador = new JComboBox();
		cmbGoleador.setBounds(220, 170, 56, 22);
		JLabel lblMinuto = new JLabel("Minuto (entre 0 - 90):");
		lblMinuto.setBounds(99, 210, 143, 19);
		lblMinuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMinuto = new JTextField();
		textMinuto.setBounds(246, 211, 45, 20);
		textMinuto.setColumns(10);
		JButton btnAlta = new JButton("ALTA");
		btnAlta.setBounds(74, 304, 57, 23);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaGol(golesLocal, golesVisitante);
					
			}
		});
		contentPanel.setLayout(null);
		contentPanel.add(lblInsertarGol);
		contentPanel.add(lblEquipo);
		contentPanel.add(textEquipo);
		contentPanel.add(lblGol);
		contentPanel.add(textGol);
		contentPanel.add(lblGoleador);
		contentPanel.add(cmbGoleador);
		contentPanel.add(lblMinuto);
		contentPanel.add(textMinuto);
		contentPanel.add(btnAlta);
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
		cargarEquipo(golesLocal, golesVisitante);
		cargarNumGol(golesLocal, golesVisitante);
		if(golesLocal>0) {
			cargarDorsalL();
		}else if(golesVisitante>0) {
			cargarDorsalV();
		}
	}
	
	private void altaGol(int golesLocal, int golesVisitante) {

		int goleador= cmbGoleador.getSelectedIndex();
		String codigoGoleador = buscarGoleador(goleador);
		
		if(Integer.parseInt(textMinuto.getText())<=0 || Integer.parseInt(textMinuto.getText())>90) {
			JOptionPane.showMessageDialog(null, "El minuto del gol tiene que ser entre 0 y 90");
		}else {
			datosGol.altaGol(Integer.parseInt(textMinuto.getText()), codigoGoleador);
			
			JOptionPane.showMessageDialog(this, "Gol dado de alta correctamente");
			
			textEquipo.setText("");
			textGol.setText("");
			cmbGoleador.removeAllItems();
			textMinuto.setText("");
			
			if(golesLocal>0) {
				golesLocal--;
			}else if (golesVisitante>0){
				golesVisitante--;
			}
			
			cargarEquipo(golesLocal, golesVisitante);
			cargarNumGol(golesLocal, golesVisitante);
			if(golesLocal>0) {
				cargarDorsalL();
			}else if(golesVisitante>0) {
				cargarDorsalV();
			}
			
		}

	}

	private void cargarDorsalL() {
		
		dorsales = datosJugador.todosJugador(equipos[0].getCodE());

		Collections.sort(dorsales);
		
		for (Jugador jugador : dorsales) {
			cmbGoleador.addItem(jugador.getDorsal());
		}

	}
	
	private void cargarDorsalV() {

		dorsales = datosJugador.todosJugador(equipos[1].getCodE());

		Collections.sort(dorsales);
		
		for (Jugador jugador : dorsales) {
			cmbGoleador.addItem(jugador.getDorsal());
		}

	}
	
	private void cargarEquipo(int golesLocal, int golesVisitante) {
		
		if(golesLocal>0) {
			textEquipo.setText(equipos[0].getNombreE());
		}else if (golesVisitante>0){
			textEquipo.setText(equipos[1].getNombreE());
		}
	}
	
	private void cargarNumGol(int golesLocal, int golesVisitante) {
		
		if(golesLocal>0) {
			textGol.setText(Integer.toString(numGolL));
			numGolL++;
		}else if(golesVisitante>0) {
			textGol.setText(Integer.toString(numGolV));
			numGolV++;
		}
		
	}
	
	private String buscarGoleador(int goleador) {
		
		String codigoGoleador = null;
		
		for (Jugador jugador : dorsales) {
			if(dorsales.get(goleador).getDorsal()==jugador.getDorsal()) {
				codigoGoleador = jugador.getCodJ();
			}
		}
		
		return codigoGoleador;
	}

}
