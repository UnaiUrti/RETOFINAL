package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.Main;
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
import javax.swing.JPasswordField;

public class VAcceder extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private UsuarioInterface datosUsuario = Main.cargarUsuario();
	private Map<String, Usuario> usuarios;
	private VPrincipal vPrincipal;
	private JPasswordField textContraseña;
	
	/**
	 * Create the dialog.
	 */
	public VAcceder(VPrincipal vPrincipal) {
		
		super(vPrincipal);
		this.vPrincipal = vPrincipal;
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
		
		textContraseña = new JPasswordField();
		textContraseña.setEchoChar('*');
		textContraseña.setBounds(248, 160, 238, 20);
		contentPanel.add(textContraseña);
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
					}
				}
			}
		}
		
	}
	
	private void modoAdmin() {
		VModoAdmin modoAdmin = new VModoAdmin();
		this.setVisible(false);
		modoAdmin.setVisible(true);
	}
	
	private void consultaPrincipal() {
		VConsultaPrincipal consultaPrincipal = new VConsultaPrincipal(this);
		this.setVisible(false);
		consultaPrincipal.setVisible(true);
	}
	
	private void volverVPrincipal() {
		this.dispose();
		vPrincipal.setVisible(true);
	}
}
