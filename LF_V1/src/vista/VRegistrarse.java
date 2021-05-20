package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;
import modelo.UsuarioInterface;
import modelo.UsuarioMySQLImplementation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VRegistrarse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JTextField textContraseña;
	private JTextField textRepContraseña;
	private UsuarioInterface datosUsuario;

	/**
	 * Create the dialog.
	 */
	public VRegistrarse(UsuarioInterface datosUsuario) {
		
		this.datosUsuario = datosUsuario;
		
		setBounds(100, 100, 602, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRegistrarse = new JLabel("Resigtrarse");
			lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblRegistrarse.setBounds(59, 39, 203, 51);
			contentPanel.add(lblRegistrarse);
		}
		{
			JLabel lblNewLabel = new JLabel("Nombre de usuario:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(59, 145, 187, 25);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a: ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(59, 206, 187, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Repetir Contrase\u00F1a: ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(59, 271, 187, 25);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textUsuario = new JTextField();
			textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textUsuario.setBounds(256, 151, 203, 20);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		}
		{
			textContraseña = new JTextField();
			textContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textContraseña.setBounds(256, 212, 203, 20);
			contentPanel.add(textContraseña);
			textContraseña.setColumns(10);
		}
		{
			textRepContraseña = new JTextField();
			textRepContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textRepContraseña.setBounds(256, 277, 203, 20);
			contentPanel.add(textRepContraseña);
			textRepContraseña.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrarse = new JButton("REGISTRARSE");
				btnRegistrarse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						altaUsuario();
					}
				});
				btnRegistrarse.setActionCommand("OK");
				buttonPane.add(btnRegistrarse);
				getRootPane().setDefaultButton(btnRegistrarse);
			}
			{
				JButton btnRetroceder = new JButton("RETROCEDER");
				btnRetroceder.setActionCommand("Cancel");
				buttonPane.add(btnRetroceder);
			}
		}
	}

	private void altaUsuario() {
		Usuario usuario = new Usuario();
		
		usuario.setNombreU(textUsuario.getText());
		usuario.setContrasenaU(textContraseña.getText());
		usuario.setAdmin(false);
		
		datosUsuario.altaUsuario(usuario);

		//Mensaje de confirmación
		JOptionPane.showMessageDialog(this, "Usuario dado de alta");
	}
	
}
