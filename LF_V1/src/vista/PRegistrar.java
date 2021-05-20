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
import java.util.Map;
import java.awt.event.ActionEvent;

public class PRegistrar extends JPanel {
	

	private JTextField textUsuario;
	private JTextField textContraseña;
	private JTextField textRepContraseña;
	private Map<String, Usuario> usuarios;
	private UsuarioInterface datosUsuario = Main.cargarUsuario();

	/**
	 * Create the panel.
	 */
	public PRegistrar() {
		
		this.usuarios = datosUsuario.todosUsuarios();
		
		this.setBounds(246, 11, 697, 403);
		setLayout(null);
		
		JLabel lblRegistrarse = new JLabel("Resigtrarse");
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegistrarse.setBounds(57, 35, 203, 51);
		add(lblRegistrarse);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de usuario:");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreUsuario.setBounds(127, 138, 187, 25);
		add(lblNombreUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a: ");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasena.setBounds(127, 196, 187, 25);
		add(lblContrasena);
		
		JLabel lblRepetirContrasena = new JLabel("Repetir Contrase\u00F1a: ");
		lblRepetirContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRepetirContrasena.setBounds(127, 257, 187, 25);
		add(lblRepetirContrasena);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarUsuario();
			}
		});
		btnRegistrarse.setActionCommand("OK");
		btnRegistrarse.setBounds(498, 321, 119, 33);
		add(btnRegistrarse);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsuario.setColumns(10);
		textUsuario.setBounds(357, 142, 203, 20);
		add(textUsuario);
		
		textContraseña = new JTextField();
		textContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textContraseña.setColumns(10);
		textContraseña.setBounds(357, 200, 203, 20);
		add(textContraseña);
		
		textRepContraseña = new JTextField();
		textRepContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textRepContraseña.setColumns(10);
		textRepContraseña.setBounds(357, 261, 203, 20);
		add(textRepContraseña);
		
	}
	
	private void altaUsuario() {
		
		Usuario usuario = new Usuario();
			
		usuario.setNombreU(textUsuario.getText());
		usuario.setContrasenaU(textContraseña.getText());
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
		} else if (textContraseña.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Introduce una contraseña");
		} else if (textRepContraseña.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vuelve a introducir la contraseña");
		} else if (!textContraseña.getText().equalsIgnoreCase(textRepContraseña.getText())) {
			JOptionPane.showMessageDialog(this, "La contraseña no coincide");
			textContraseña.setText("");
			textRepContraseña.setText("");
		} else if (usuarios.containsKey(textUsuario.getText())) {
			JOptionPane.showMessageDialog(this, "El nombre de usuario ya esta en la BD, introduzca otro nombre de usuario");
			textUsuario.setText("");
		} else {
			altaUsuario();
		}
		
	}
	
	private void limpiarPantalla() {
		textUsuario.setText("");
		textContraseña.setText("");
		textRepContraseña.setText("");
	}
	
	
	
}
