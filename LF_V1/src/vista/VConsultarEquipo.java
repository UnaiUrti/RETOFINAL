package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import aplicacion.Main;
import modelo.Jugador;
import modelo.JugadorInterface;

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
	private JTable table_1;
	private String codE;

	/**
	 * Create the dialog.
	 * @param vConsultarLiga 
	 * @param codE 
	 */
	public VConsultarEquipo(VConsultarLiga2 vConsultarLiga, String codE) {
		
		this.codE = codE;
		
		setBounds(100, 100, 600, 439);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(25, 72, 62, 19);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre = new JTextField();
		textNombre.setBounds(97, 73, 132, 20);
		textNombre.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBounds(360, 124, 209, 48);
		
		
		String titulos[] = { "DORSAL", "POS", "NOMBRE" };
	
		DefaultTableModel model = new DefaultTableModel(tablaJugadores(),titulos);
		tablaJugadores = new JTable(model);
		tablaJugadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tablaJugadores);
		scrollPane.setBounds(28, 103, 690, 291);
		scrollPane.setVisible(true);
		tablaJugadores.setVisible(true);
		
		
		contentPanel.setLayout(null);
		contentPanel.add(lblNombre);
		contentPanel.add(textNombre);
		contentPanel.add(table_1);
		contentPanel.add(scrollPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Volver");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
	}

	public String[][] tablaJugadores() {
		
		this.jugadores=datosJugador.todosJugadoresEquipo(codE);
		
		String[][] jugadoresData = new String[jugadores.size()][6];
		
		for (int i = 0; i < jugadores.size(); i++) {
			jugadoresData[i][0] = jugadores.get(i).getCodJ();
			jugadoresData[i][1] = jugadores.get(i).getNombreJ();
			jugadoresData[i][2] = String.valueOf(jugadores.get(i).getDorsal());
			jugadoresData[i][3] = jugadores.get(i).getPaisJ();
			jugadoresData[i][4] = jugadores.get(i).getPosicion();
			jugadoresData[i][5] = jugadores.get(i).getCodE();
		}
		
		return jugadoresData;
		
	}
	
}
