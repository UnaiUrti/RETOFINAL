package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controlador.Main;
import modelo.entidades.Usuario;
import modelo.interfaces.UsuarioInterface;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.util.Map;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PAcceder extends JPanel {

	private JTextField textUsuario;
	private UsuarioInterface datosUsuario = Main.cargarUsuario();
	private Map<String, Usuario> usuarios;
	private JPasswordField textContraseña;
	private VPrincipalMenu ventanaPrincipal;
	
	/**
	 * Create the panel.
	 */
	public PAcceder(VPrincipalMenu ventanaPrincipal) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		usuarios = datosUsuario.todosUsuarios();
		
		this.setBounds(246, 11, 697, 403);
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblLogin.setBounds(34, 46, 166, 55);
		add(lblLogin);
		
		JLabel lblNomUsu = new JLabel("Nombre de Usuario:");
		lblNomUsu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomUsu.setBounds(85, 135, 188, 43);
		add(lblNomUsu);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsuario.setColumns(10);
		textUsuario.setBounds(312, 148, 238, 21);
		add(textUsuario);
		
		JLabel lblContra = new JLabel("Contrase\u00F1a: ");
		lblContra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContra.setBounds(85, 197, 188, 43);
		add(lblContra);
		
		textContraseña = new JPasswordField();
		textContraseña.setEchoChar('*');
		textContraseña.setBounds(312, 212, 238, 20);
		add(textContraseña);
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accederUsuario();
			}
		});
		btnAcceder.setBounds(318, 304, 111, 34);
		add(btnAcceder);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarPantalla();
			}
		});
		btnLimpiar.setBounds(478, 304, 111, 34);
		add(btnLimpiar);
		
	}
	
	private void limpiarPantalla() {
		textUsuario.setText("");
		textContraseña.setText("");
	}
	
	private void accederUsuario() {
		
		if (!usuarios.containsKey(textUsuario.getText())) {
			JOptionPane.showMessageDialog(this, "El usuario no esta en la BD.");
			textUsuario.setText("");
			textContraseña.setText("");
		}else if (textContraseña.getPassword().length == 0){
			JOptionPane.showMessageDialog(this, "Introduce la contraseña");
		} else {
			for (Usuario user: usuarios.values()) {
				if (user.getNombreU().equalsIgnoreCase(textUsuario.getText())) {
					if (user.getContrasenaU().equalsIgnoreCase(textContraseña.getText())) {
						JOptionPane.showMessageDialog(this, "Usuario y contraseña correctos");
						if (user.isAdmin()) {
							modoAdmin();
						} else {
							consultaPrincipal();
						}
					} else {
						JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
						textContraseña.setText("");
					}
				}
			}
		}
	}
	
	private void modoAdmin() {
		
		ventanaPrincipal.dispose();
		VAdminMenu adminMenu = new VAdminMenu();
		adminMenu.setVisible(true);

	}
	
	private void consultaPrincipal() {
		
		ventanaPrincipal.dispose();
		VUsuarioMenu usuarioMenu = new VUsuarioMenu();
		usuarioMenu.setVisible(true);
		
	}
	
}
