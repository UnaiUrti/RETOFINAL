package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class VInsertarGol extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textEquipo;
	private JTextField textGol;
	private JTextField textMinuto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInsertarGol dialog = new VInsertarGol();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VInsertarGol() {
		setBounds(100, 100, 600, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblInsertarGol = new JLabel("Insertar Gol");
		lblInsertarGol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEquipo = new JTextField();
		textEquipo.setColumns(10);
		JLabel lblGol = new JLabel("Gol num");
		lblGol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textGol = new JTextField();
		textGol.setColumns(10);
		JLabel lblGoleador = new JLabel("Goleador (dorsal):");
		lblGoleador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JComboBox cmbGoleador = new JComboBox();
		JLabel lblMinuto = new JLabel("Minuto (entre 0 - 90):");
		lblMinuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMinuto = new JTextField();
		textMinuto.setColumns(10);
		JButton btnAlta = new JButton("ALTA");
		JButton btnModificar = new JButton("MODIFICAR");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInsertarGol)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblEquipo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(textEquipo, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addGap(76)
											.addComponent(lblGol)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textGol, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblGoleador)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cmbGoleador, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblMinuto)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textMinuto, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(69)
							.addComponent(btnAlta)
							.addGap(167)
							.addComponent(btnModificar)))
					.addContainerGap(192, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(lblInsertarGol)
					.addGap(42)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEquipo)
						.addComponent(textEquipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGol)
						.addComponent(textGol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGoleador)
						.addComponent(cmbGoleador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMinuto)
						.addComponent(textMinuto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlta)
						.addComponent(btnModificar))
					.addGap(27))
		);
		contentPanel.setLayout(gl_contentPanel);
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
