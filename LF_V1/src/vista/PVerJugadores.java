package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import modelo.entidades.Jugador;

import javax.swing.JTextField;

public class PVerJugadores extends JPanel {
	
	private JTextField textNombreJ;
	private JTextField textPaisJ;
	private JTextField textPosicionJ;
	private JTextField textDorsalJ;
	private JTextField textEquipoJ;
	private Jugador jugador;
	private String nombreE;


	public PVerJugadores(Jugador jugador, String nombreE) {
		
		this.jugador = jugador;
		this.nombreE = nombreE;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblNombreJ = new JLabel("JUGADOR");
		lblNombreJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJ.setBounds(77, 103, 115, 35);
		add(lblNombreJ);
		
		textNombreJ = new JTextField();
		textNombreJ.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreJ.setBounds(202, 106, 160, 28);
		add(textNombreJ);
		textNombreJ.setColumns(10);
		
		JLabel lblPaisJ = new JLabel("PAIS");
		lblPaisJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisJ.setBounds(77, 166, 115, 35);
		add(lblPaisJ);
		
		textPaisJ = new JTextField();
		textPaisJ.setHorizontalAlignment(SwingConstants.CENTER);
		textPaisJ.setColumns(10);
		textPaisJ.setBounds(202, 169, 160, 28);
		add(textPaisJ);
		
		JLabel lblPosicion = new JLabel("POSICION");
		lblPosicion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion.setBounds(383, 103, 115, 35);
		add(lblPosicion);
		
		textPosicionJ = new JTextField();
		textPosicionJ.setHorizontalAlignment(SwingConstants.CENTER);
		textPosicionJ.setColumns(10);
		textPosicionJ.setBounds(508, 106, 72, 28);
		add(textPosicionJ);
		
		JLabel lblDorsal = new JLabel("DORSAL");
		lblDorsal.setHorizontalAlignment(SwingConstants.CENTER);
		lblDorsal.setBounds(383, 166, 115, 35);
		add(lblDorsal);
		
		textDorsalJ = new JTextField();
		textDorsalJ.setHorizontalAlignment(SwingConstants.CENTER);
		textDorsalJ.setColumns(10);
		textDorsalJ.setBounds(507, 169, 73, 28);
		add(textDorsalJ);
		
		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBounds(77, 229, 115, 35);
		add(lblEquipo);
		
		textEquipoJ = new JTextField();
		textEquipoJ.setHorizontalAlignment(SwingConstants.CENTER);
		textEquipoJ.setColumns(10);
		textEquipoJ.setBounds(202, 232, 160, 28);
		add(textEquipoJ);
		
		cargarJugador();
		
	}
	
	private void cargarJugador() {
		
		textNombreJ.setText(jugador.getNombreJ());
		textPaisJ.setText(jugador.getPaisJ());
		textEquipoJ.setText(nombreE);
		textPosicionJ.setText(jugador.getPosicion());
		textDorsalJ.setText(String.valueOf(jugador.getDorsal()));
	
	}
	
}
