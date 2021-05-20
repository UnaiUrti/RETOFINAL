package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controlador.Main;
import modelo.entidades.Usuario;
import modelo.interfaces.UsuarioInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PRegistrar extends JPanel {
	

	private JTextField textUsuario;
	private JTextField textContrase�a;
	private JTextField textRepContrase�a;
	private UsuarioInterface datosUsuario = Main.cargarUsuario();

	/**
	 * Create the panel.
	 */
	public PRegistrar() {
		
		this.setBounds(246, 11, 612, 364);
		setLayout(null);
		
		JLabel lblRegistrarse = new JLabel("Resigtrarse");
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegistrarse.setBounds(57, 35, 203, 51);
		add(lblRegistrarse);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de usuario:");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreUsuario.setBounds(108, 118, 187, 25);
		add(lblNombreUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a: ");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasena.setBounds(108, 180, 187, 25);
		add(lblContrasena);
		
		JLabel lblRepetirContrasena = new JLabel("Repetir Contrase\u00F1a: ");
		lblRepetirContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRepetirContrasena.setBounds(108, 241, 187, 25);
		add(lblRepetirContrasena);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarUsuario();
			}
		});
		btnRegistrarse.setActionCommand("OK");
		btnRegistrarse.setBounds(448, 301, 119, 33);
		add(btnRegistrarse);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsuario.setColumns(10);
		textUsuario.setBounds(315, 122, 203, 20);
		add(textUsuario);
		
		textContrase�a = new JTextField();
		textContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textContrase�a.setColumns(10);
		textContrase�a.setBounds(315, 184, 203, 20);
		add(textContrase�a);
		
		textRepContrase�a = new JTextField();
		textRepContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textRepContrase�a.setColumns(10);
		textRepContrase�a.setBounds(315, 245, 203, 20);
		add(textRepContrase�a);
		
	}
	
	private void altaUsuario() {
		
		Usuario usuario = new Usuario();
			
		usuario.setNombreU(textUsuario.getText());
		usuario.setContrasenaU(textContrase�a.getText());
		usuario.setAdmin(false);
				
		datosUsuario.altaUsuario(usuario);

		//MENSAJE DE CONFIRMACION
		JOptionPane.showMessageDialog(this, "Usuario dado de alta");
				
		//LIMPIAMOS LA PANTALLA POR SI QUIERE REGISTRARSE DE NUEVO
		limpiarPantalla();
		
		//FALTA COMPROBAR QUE NO META UN NOMBRE DE USUARIO QUE YA EXISTE EN LA BD
		
	}
	
	private void comprobarUsuario() {
		if (textUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Introduce un nombre de usuario");
		} else if (textContrase�a.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Introduce una contrase�a");
		} else if (textRepContrase�a.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vuelve a introducir la contrase�a");
		} else if (!textContrase�a.getText().equalsIgnoreCase(textRepContrase�a.getText())) {
			JOptionPane.showMessageDialog(this, "La contrase�a no coincide");
			textContrase�a.setText("");
			textRepContrase�a.setText("");
		} else {
			altaUsuario();
		}
		
	}
	
	private void limpiarPantalla() {
		textUsuario.setText("");
		textContrase�a.setText("");
		textRepContrase�a.setText("");
	}
	
	
	
}