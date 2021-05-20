package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import aplicacion.Main;
import modelo.EquipoInterface;
import modelo.Jugador;
import modelo.JugadorInterface;
import modelo.Partido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VConsultarEquipo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JugadorInterface datosJugador=Main.cargarJugador();
	private ArrayList<Jugador> jugadores;
	private JTable tablaJugadores;
	private JTable tablaPartidos;
	private String codE;
	private EquipoInterface datosEquipo=Main.cargarEquipo();
	private VConsultarLiga2 vConsultarLiga2;
	private String[][] ultimosPartidos;

	/**
	 * Create the dialog.
	 * @param vConsultarLiga 
	 * @param codE 
	 */
	public VConsultarEquipo(VConsultarLiga2 vConsultarLiga2, String codE) {
		
		this.vConsultarLiga2 = vConsultarLiga2;
		this.codE = codE;
		
		
		setBounds(100, 100, 826, 462);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(28, 11, 62, 19);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(107, 12, 132, 20);
		textNombre.setColumns(10);
		textNombre.setText(datosEquipo.buscarEquipo(codE).getNombreE());
		
		String titulos2[] = { "FECHA","EQUIPO L","GOLES L","GOLES V","EQUIPO V" };
		ultimosPartidos = datosEquipo.ultimosPartidos(codE);
		
		DefaultTableModel model2 = new DefaultTableModel(ultimosPartidos,titulos2);
		tablaPartidos = new JTable(model2);
		tablaPartidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane2 = new JScrollPane(tablaPartidos);
		tablaPartidos.setBounds(542, 103, 209, 48);
		scrollPane2.setVisible(true);
		tablaPartidos.setVisible(true);
		scrollPane2.setLocation(271, 103);
		scrollPane2.setSize(508, 200);
		
		tablaPartidos.setEnabled(false);
		
		tablaPartidos.getColumnModel().getColumn(0).setMinWidth(100);
		tablaPartidos.getColumnModel().getColumn(1).setMinWidth(150);
		tablaPartidos.getColumnModel().getColumn(2).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(3).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(4).setMinWidth(150);
		
		String titulos[] = { "DORSAL", "POS", "NOMBRE" };
	
		DefaultTableModel model = new DefaultTableModel(tablaJugadores(),titulos);
		tablaJugadores = new JTable(model);
		tablaJugadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tablaJugadores);
		scrollPane.setBounds(28, 103, 211, 277);
		scrollPane.setVisible(true);
		tablaJugadores.setVisible(true);
		
		tablaJugadores.setEnabled(false);
		
		contentPanel.setLayout(null);
		contentPanel.add(lblNombre);
		contentPanel.add(textNombre);
		contentPanel.add(scrollPane);
		contentPanel.add(scrollPane2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Volver");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volverVConsultarLiga2();
					}
				});
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
	}

	public String[][] tablaJugadores() {
		
		this.jugadores=datosJugador.todosJugadoresEquipo(codE);
		
		String[][] jugadoresData = new String[jugadores.size()][6];
		
		for (int i = 0; i < jugadores.size(); i++) {
			jugadoresData[i][0] = String.valueOf(jugadores.get(i).getDorsal());
			jugadoresData[i][1] = jugadores.get(i).getPosicion();
			jugadoresData[i][2] = jugadores.get(i).getNombreJ();
			jugadoresData[i][3] = jugadores.get(i).getCodJ();
		}
		
		return jugadoresData;
		
	}
	
	private void volverVConsultarLiga2() {
		
		this.dispose();
		vConsultarLiga2.setVisible(true);
		
	}
	
}
