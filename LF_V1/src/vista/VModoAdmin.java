package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.UsuarioInterface;

import javax.swing.JLabel;
import java.awt.Font;

public class VModoAdmin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private UsuarioInterface datosUsuario;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VModoAdmin dialog = new VModoAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public VModoAdmin(UsuarioInterface datosUsuario) {
		
		this.datosUsuario = datosUsuario;
		
		setBounds(100, 100, 604, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("MODO ADMIN");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblNewLabel.setBounds(164, 51, 251, 53);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnInsertar = new JButton("INSERTAR");
			btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnInsertar.setBounds(31, 176, 150, 59);
			contentPanel.add(btnInsertar);
		}
		{
			JButton btnModificar = new JButton("MODIFICAR");
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnModificar.setBounds(215, 176, 150, 59);
			contentPanel.add(btnModificar);
		}
		{
			JButton btnEliminar = new JButton("ELIMINAR");
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnEliminar.setBounds(399, 176, 150, 59);
			contentPanel.add(btnEliminar);
		}
		{
			JButton btnVistaUsuario = new JButton("VISTA DE \r\nUSUARIO");
			btnVistaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnVistaUsuario.setBounds(215, 278, 150, 59);
			contentPanel.add(btnVistaUsuario);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRetroceder = new JButton("RETROCEDER");
				btnRetroceder.setActionCommand("Cancel");
				buttonPane.add(btnRetroceder);
			}
		}
	}

}
