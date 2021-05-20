package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VInsertarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInsertarEquipo dialog = new VInsertarEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VInsertarEquipo() {
		setBounds(100, 100, 673, 479);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Insertar Equipo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(49, 45, 157, 61);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Liga:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(38, 164, 81, 24);
			contentPanel.add(lblNewLabel_1);
		}
		
		JComboBox comboLiga = new JComboBox();
		comboLiga.setBounds(81, 167, 142, 22);
		contentPanel.add(comboLiga);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(38, 233, 72, 14);
		contentPanel.add(lblNewLabel_2);
		
		textNombre = new JTextField();
		textNombre.setBounds(120, 232, 103, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(81, 352, 89, 23);
		contentPanel.add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(207, 352, 89, 23);
		contentPanel.add(btnModificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
