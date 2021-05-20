package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PInsertarMenu extends JPanel {

	private VAdminMenu adminMenu;
	
	
	public PInsertarMenu(VAdminMenu adminMenu) {
		
		this.adminMenu = adminMenu;
		
		setLayout(null);
		this.setBounds(246, 11, 697, 403);
		
		JLabel lblInsertarMenu = new JLabel("INSERTAR MENU");
		lblInsertarMenu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInsertarMenu.setBounds(234, 45, 228, 62);
		add(lblInsertarMenu);
		
		JButton btnNuevaLiga = new JButton("Nueva Liga");
		btnNuevaLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarLiga();
			}
		});
		btnNuevaLiga.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevaLiga.setBounds(133, 141, 120, 40);
		add(btnNuevaLiga);
		
		JButton btnNuevoJugador = new JButton("Nuevo Jugador");
		btnNuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarJugador();
			}
		});
		btnNuevoJugador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoJugador.setBounds(441, 141, 120, 40);
		add(btnNuevoJugador);
		
		JButton btnNuevoEquipo = new JButton("Nuevo Equipo");
		btnNuevoEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarEquipo();
			}
		});
		btnNuevoEquipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoEquipo.setBounds(133, 265, 120, 40);
		add(btnNuevoEquipo);
		
		JButton btnNuevoPartido = new JButton("Nuevo Partido");
		btnNuevoPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPartido();
			}
		});
		btnNuevoPartido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoPartido.setBounds(441, 265, 120, 40);
		add(btnNuevoPartido);
		
	}
	
	private void insertarLiga() {
		PInsertarLiga insertarLiga = new PInsertarLiga(false, null);
		adminMenu.cambiarJPanel(insertarLiga);
	}
	
	private void insertarEquipo() {
		PInsertarEquipo insertarEquipo = new PInsertarEquipo(false, null);
		adminMenu.cambiarJPanel(insertarEquipo);
		
	}
	
	private void insertarJugador() {
		PInsertarJugador insertarJugadir = new PInsertarJugador(false, null);
		adminMenu.cambiarJPanel(insertarJugadir);
	}
	
	private void insertarPartido() {
		PInsertarPartido insertarPartida = new PInsertarPartido(adminMenu);
		adminMenu.cambiarJPanel(insertarPartida);
	}
	
}
