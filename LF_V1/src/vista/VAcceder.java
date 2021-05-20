package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.Main;
import modelo.LigaInterface;
import modelo.Usuario;
import modelo.UsuarioInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Map;
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
	private UsuarioInterface datosUsuario = Main.cargarUsuario();
	private Map<String, Usuario> usuarios;
	
	/**
	 * Create the dialog.
	 */
	public VAcceder() {
		
		usuarios = datosUsuario.todosUsuarios();
		
		setBounds(100, 100, 604, 429);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
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
						accederUsuario();
					}
				});
				btnAcceder.setActionCommand("OK");
				buttonPane.add(btnAcceder);
				getRootPane().setDefaultButton(btnAcceder);
			}
			{
				JButton btnRetroceder = new JButton("RETROCEDER");
				btnRetroceder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volverVPrincipal();
					}
				});
				btnRetroceder.setActionCommand("Cancel");
				buttonPane.add(btnRetroceder);
			}
		}
		
	}
	
	private void accederUsuario() {
		if (usuarios.containsKey(textUsuario.getText())) {
			for (Usuario usuario : usuarios.values()) {
				if (usuario.getNombreU().equalsIgnoreCase(textUsuario.getText()) && usuario.getContrasenaU().equals(textContraseña.getText())) {
					if (usuario.isAdmin()) {
						modoAdmin();
					} else {
						consultaPrincipal();
					}
				} else if (usuario.getNombreU().equalsIgnoreCase(textUsuario.getText()) && !usuario.getContrasenaU().equals(textContraseña.getText())){
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
					textContraseña.setText("");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "El usuario no existe.");
			textUsuario.setText("");
			textContraseña.setText("");
		}
		
	}
	
	private void modoAdmin() {
		VModoAdmin modoAdmin = new VModoAdmin();
		this.dispose();
		modoAdmin.setVisible(true);
	}
	
	private void consultaPrincipal() {
		VConsultaPrincipal consultaPrincipal = new VConsultaPrincipal();
		this.dispose();
		consultaPrincipal.setVisible(true);
	}
	
	private void volverVPrincipal() {
		VPrincipal volverVPrincipal = new VPrincipal();
		this.dispose();
		volverVPrincipal.setVisible(true);
	}
	
}
