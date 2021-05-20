package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Main;
import modelo.interfaces.JugadorInterface;
import modelo.interfaces.EquipoInterface;
import modelo.entidades.Jugador;
import modelo.entidades.Partido;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PVerEquipos extends JPanel {
	
	private JTextField textNombreE;
	private VUsuarioMenu usuarioMenu;
	private String codE;
	private JugadorInterface datosJugador=Main.cargarJugador();
	private EquipoInterface datosEquipo=Main.cargarEquipo();
	private String[][] ultimosPartidos;
	private String[][] jugadores;
	private ArrayList<Jugador> jugadoresArray;
	private JTable tablaPartidos;
	private JTable tablaJugadores;
	

	public PVerEquipos(VUsuarioMenu usuarioMenu, String codE) {

		this.usuarioMenu = usuarioMenu;
		this.codE = codE;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblNombre = new JLabel("Equipo: ");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(206, 11, 79, 33);
		add(lblNombre);
		
		textNombreE = new JTextField();
		textNombreE.setText((String) null);
		textNombreE.setEditable(false);
		textNombreE.setColumns(10);
		textNombreE.setText(datosEquipo.buscarEquipo(codE).getNombreE());
		textNombreE.setBounds(293, 19, 132, 20);
		add(textNombreE);
		
		String titulosPartido[] = { "FECHA","EQUIPO L","GOLES L","GOLES V","EQUIPO V" };
		ultimosPartidos = datosEquipo.ultimosPartidos(codE);
		
		DefaultTableModel modelPartido = new DefaultTableModel(ultimosPartidos, titulosPartido);
		//PARA NO PODER EDITAR LA JTABLE DE PARTIDOS
		tablaPartidos = new JTable(modelPartido) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollPartido = new JScrollPane(tablaPartidos);
		scrollPartido.setBounds(52, 55, 596, 77);
		add(scrollPartido);
		
		//PARA QUE NO SE PUEDA MOVER LA CABECERA DEL JTABLE DE PARTIDOS
		tablaPartidos.getTableHeader().setReorderingAllowed(false);
		
		//ALINEAR EL TEXTO DE LAS JTABLES DE PARTIDOS
		DefaultTableCellRenderer alinearPartidos = new DefaultTableCellRenderer();
		alinearPartidos.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaPartidos.getColumnCount(); i++) {
			tablaPartidos.getColumnModel().getColumn(i).setCellRenderer(alinearPartidos);
		}
		
		//PONER ANCHURA MININA A LAS COLUMNAS DE PARTIDOS
		tablaPartidos.getColumnModel().getColumn(0).setMinWidth(100);
		tablaPartidos.getColumnModel().getColumn(1).setMinWidth(150);
		tablaPartidos.getColumnModel().getColumn(2).setMinWidth(30);
		tablaPartidos.getColumnModel().getColumn(3).setMinWidth(30);
		tablaPartidos.getColumnModel().getColumn(4).setMinWidth(150);
		
		String titulosJugador[] = { "DORSAL", "POS", "NOMBRE" };
		
		DefaultTableModel modelJugador = new DefaultTableModel(cargarJugadores(),titulosJugador);
		tablaJugadores = new JTable(modelJugador) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};	
		JScrollPane scrollJugador = new JScrollPane(tablaJugadores);
		scrollJugador.setBounds(52, 143, 316, 249);
		add(scrollJugador);
		
		JButton btnVerJugador = new JButton("VER JUGADOR");
		btnVerJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verJugador();
			}
		});
		btnVerJugador.setBounds(462, 326, 142, 39);
		add(btnVerJugador);
		
		//PARA QUE NO SE PUEDA MOVER LA CABECERA DEL JTABLE DE JUGADORES
		tablaJugadores.getTableHeader().setReorderingAllowed(false);
		
		//ALINEAR EL TEXTO DE LAS JTABLES DE JUGADORES
		DefaultTableCellRenderer alinearJugadores = new DefaultTableCellRenderer();
		alinearJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaJugadores.getColumnCount(); i++) {
			tablaJugadores.getColumnModel().getColumn(i).setCellRenderer(alinearJugadores);
		}
		
		tablaJugadores.getColumnModel().getColumn(2).setMinWidth(150);
		
	}
	
	private void verJugador() {
		
		if (tablaJugadores.getSelectedRowCount()>1) {
			JOptionPane.showMessageDialog(this, "Selecciona solo un jugador");
		} else if (tablaJugadores.getSelectedRowCount()==0) {
			JOptionPane.showMessageDialog(this, "Debes seleccionar un jugador");
		} else {
			Jugador jugador = datosJugador.buscarJugador(jugadores[tablaJugadores.getSelectedRow()][3]);
			PVerJugadores verJugadores = new PVerJugadores(jugador, textNombreE.getText());
			usuarioMenu.cambiarJPanel(verJugadores);
		}
		
	}
	
	
	private String[][] cargarJugadores() {
		
		this.jugadoresArray = datosJugador.todosJugador(codE);
		
		jugadores = new String[jugadoresArray.size()][6];
		
		for (int i = 0; i < jugadoresArray.size(); i++) {
			jugadores[i][0] = String.valueOf(jugadoresArray.get(i).getDorsal());
			jugadores[i][1] = jugadoresArray.get(i).getPosicion();
			jugadores[i][2] = jugadoresArray.get(i).getNombreJ();
			jugadores[i][3] = jugadoresArray.get(i).getCodJ();
		}
		
		return jugadores;
		
	}
	
	
}
