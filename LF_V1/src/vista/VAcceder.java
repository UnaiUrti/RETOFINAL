package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;
import modelo.UsuarioInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAcceder extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JTextField textContraseña;
	private UsuarioInterface datosUsuario;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VAcceder dialog = new VAcceder(datosUsuario);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public VAcceder(UsuarioInterface datosUsuario) {
		
		this.datosUsuario = datosUsuario;
		Map<String, Usuario> usuarios = datosUsuario.todosUsuarios();
		
		setBounds(100, 100, 604, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblLogin = new JLabel("Login");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblLogin.setBounds(50, 11, 116, 69);
			contentPanel.add(lblLogin);
		}
		{
			JLabel lblNomUsu = new JLabel("Nombre de Usuario:");
			lblNomUsu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNomUsu.setBounds(50, 114, 188, 20);
			contentPanel.add(lblNomUsu);
		}
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsuario.setBounds(248, 114, 238, 20);
		contentPanel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblContra = new JLabel("Contrase\u00F1a: ");
		lblContra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContra.setBounds(50, 156, 188, 21);
		contentPanel.add(lblContra);
		
		textContraseña = new JTextField();
		textContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textContraseña.setBounds(248, 157, 238, 20);
		contentPanel.add(textContraseña);
		textContraseña.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAcceder = new JButton("ACCEDER");
				btnAcceder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (buscarUsuario(usuarios)) {
							if (comprobarContrasena(usuarios)) {
								System.out.println(esAdmin(usuarios));
								if (!esAdmin(usuarios)) {
									consultaPrincipal();
								} else if (esAdmin(usuarios)) {
									modoAdmin();
								}
							} else {
								JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecto.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "El usuario no existe.");
						}
					}
				});
				btnAcceder.setActionCommand("OK");
				buttonPane.add(btnAcceder);
				getRootPane().setDefaultButton(btnAcceder);
			}
			{
				JButton btnRetroceder = new JButton("RETROCEDER");
				btnRetroceder.setActionCommand("Cancel");
				buttonPane.add(btnRetroceder);
			}
		}
		
	}
	
	private boolean buscarUsuario(Map<String, Usuario> usuarios) {
		
		boolean encontrado=false;
		
			if (usuarios.containsKey(textUsuario.getText())) {
				encontrado=true;
			}
		
		return encontrado;
	}
	
	private boolean comprobarContrasena(Map<String, Usuario> usuarios) {
		
		boolean encontrado=false;
		
		for (Usuario usuario : usuarios.values()) {
			if (buscarUsuario(usuarios) && usuario.getContrasenaU().equals(textContraseña.getText())) {
				encontrado=true;
			}
		}
		
		return encontrado;
		
	}
	
	private boolean esAdmin(Map<String, Usuario> usuarios) {
		
		for (Usuario usuario : usuarios.values()) {
			if (buscarUsuario(usuarios) && usuario.isAdmin()) {
				return true;
			}
		}
		
		return false;
		
	}
	
	private void modoAdmin() {
		VModoAdmin modoAdmin = new VModoAdmin(datosUsuario);
		modoAdmin.setVisible(true);
	}
	
	private void consultaPrincipal() {
		VConsultaPrincipal consultaPrincipal = new VConsultaPrincipal(datosUsuario);
		consultaPrincipal.setVisible(true);
	}
	
}
