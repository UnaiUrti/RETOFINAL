package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import modelo.entidades.Jugador;
import modelo.entidades.Liga;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PVerJugadores extends JPanel {
	
	private JTextField textNombreJ;
	private JTextField textPaisJ;
	private JTextField textPosicionJ;
	private JTextField textDorsalJ;
	private JTextField textEquipoJ;
	private Jugador jugador;
	private String nombreE;
	private VUsuarioMenu usuarioMenu;
	private String codE;
	private Liga liga;


	public PVerJugadores(VUsuarioMenu usuarioMenu, String codE, Liga liga,Jugador jugador, String nombreE) {
		
		this.usuarioMenu = usuarioMenu;
		this.codE = codE;
		this.liga = liga;
		
		this.jugador = jugador;
		this.nombreE = nombreE;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblNombreJ = new JLabel("JUGADOR");
		lblNombreJ.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombreJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJ.setBounds(39, 61, 178, 35);
		add(lblNombreJ);
		
		textNombreJ = new JTextField();
		textNombreJ.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textNombreJ.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreJ.setBounds(227, 55, 323, 48);
		add(textNombreJ);
		textNombreJ.setColumns(10);
		
		JLabel lblPaisJ = new JLabel("PAIS");
		lblPaisJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisJ.setBounds(77, 162, 115, 35);
		add(lblPaisJ);
		
		textPaisJ = new JTextField();
		textPaisJ.setHorizontalAlignment(SwingConstants.CENTER);
		textPaisJ.setColumns(10);
		textPaisJ.setBounds(213, 165, 160, 28);
		add(textPaisJ);
		
		JLabel lblPosicion = new JLabel("POSICION");
		lblPosicion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion.setBounds(383, 162, 115, 35);
		add(lblPosicion);
		
		textPosicionJ = new JTextField();
		textPosicionJ.setHorizontalAlignment(SwingConstants.CENTER);
		textPosicionJ.setColumns(10);
		textPosicionJ.setBounds(508, 165, 72, 28);
		add(textPosicionJ);
		
		JLabel lblDorsal = new JLabel("DORSAL");
		lblDorsal.setHorizontalAlignment(SwingConstants.CENTER);
		lblDorsal.setBounds(383, 227, 115, 35);
		add(lblDorsal);
		
		textDorsalJ = new JTextField();
		textDorsalJ.setHorizontalAlignment(SwingConstants.CENTER);
		textDorsalJ.setColumns(10);
		textDorsalJ.setBounds(508, 230, 73, 28);
		add(textDorsalJ);
		
		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBounds(77, 227, 115, 35);
		add(lblEquipo);
		
		textEquipoJ = new JTextField();
		textEquipoJ.setHorizontalAlignment(SwingConstants.CENTER);
		textEquipoJ.setColumns(10);
		textEquipoJ.setBounds(213, 230, 160, 28);
		add(textEquipoJ);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setBounds(494, 335, 138, 35);
		add(btnVolver);
		
		cargarJugador();
		
	}
	
	private void volver() {
		
		PVerEquipos verEquipos = new PVerEquipos(usuarioMenu, codE, liga);
		usuarioMenu.cambiarJPanel(verEquipos);
		
	}
	
	private void cargarJugador() {
		
		textNombreJ.setText(jugador.getNombreJ());
		textPaisJ.setText(jugador.getPaisJ());
		textEquipoJ.setText(nombreE);
		textPosicionJ.setText(jugador.getPosicion());
		textDorsalJ.setText(String.valueOf(jugador.getDorsal()));
	
		textNombreJ.setEditable(false);
		textPaisJ.setEditable(false);
		textEquipoJ.setEditable(false);
		textPosicionJ.setEditable(false);
		textDorsalJ.setEditable(false);
	}
}
