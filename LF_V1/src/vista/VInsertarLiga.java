package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VInsertarLiga extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textPais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInsertarLiga dialog = new VInsertarLiga();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VInsertarLiga() {
		setBounds(100, 100, 681, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInsertarLiga = new JLabel("Insertar Liga");
		lblInsertarLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertarLiga.setBounds(34, 33, 160, 36);
		contentPanel.add(lblInsertarLiga);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(45, 145, 74, 36);
		contentPanel.add(lblNombre);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPais.setBounds(45, 227, 46, 14);
		contentPanel.add(lblPais);
		
		textNombre = new JTextField();
		textNombre.setBounds(136, 155, 137, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textPais = new JTextField();
		textPais.setBounds(136, 227, 137, 20);
		contentPanel.add(textPais);
		textPais.setColumns(10);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(84, 312, 89, 23);
		contentPanel.add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(275, 312, 89, 23);
		contentPanel.add(btnModificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Cancel");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
	}
}
