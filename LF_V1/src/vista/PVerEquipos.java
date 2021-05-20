package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;

import modelo.entidades.Jugador;
import modelo.entidades.Partido;

public class PVerEquipos extends JPanel {
	
	private JTextField textNombreE;

	public PVerEquipos(VUsuarioMenu usuarioMenu, String codE) {

		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(50, 27, 82, 33);
		add(lblNombre);
		
		textNombreE = new JTextField();
		textNombreE.setText((String) null);
		textNombreE.setEditable(false);
		textNombreE.setColumns(10);
		textNombreE.setBounds(134, 35, 132, 20);
		add(textNombreE);
		
	}
}
