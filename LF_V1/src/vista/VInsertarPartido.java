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
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class VInsertarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textGolesL;
	private JTextField textGolesV;
	private JTextField textJornada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInsertarPartido dialog = new VInsertarPartido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VInsertarPartido() {
		setBounds(100, 100, 633, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblInsertarPartido = new JLabel("Insertar Partido");
		lblInsertarPartido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JComboBox cmbLiga = new JComboBox();
		cmbLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipoL = new JLabel("Equipo Local:");
		lblEquipoL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipoV = new JLabel("Equipo Visitante:");
		lblEquipoV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JComboBox cmbEquipoL = new JComboBox();
		JComboBox cmbEquipoV = new JComboBox();
		JLabel lblGolesL = new JLabel("Goles Local");
		lblGolesL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblGolesV = new JLabel("Goles Visitante");
		lblGolesV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textGolesL = new JTextField();
		textGolesL.setColumns(10);
		textGolesV = new JTextField();
		textGolesV.setColumns(10);
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblNewLabel_8 = new JLabel("");
		textJornada = new JTextField();
		textJornada.setColumns(10);
		JButton btnAlta = new JButton("ALTA");
		JButton btnModificar = new JButton("MODIFICAR");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInsertarPartido)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEquipoL)
										.addComponent(lblEquipoV))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(cmbEquipoV, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(cmbEquipoL, 0, 121, Short.MAX_VALUE))
										.addComponent(btnAlta))
									.addGap(83)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGolesV)
										.addComponent(lblGolesL)
										.addComponent(btnModificar, Alignment.TRAILING))
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textGolesV, 0, 0, Short.MAX_VALUE)
										.addComponent(textGolesL, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
									.addGap(39))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(208)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblJornada)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textJornada, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_8))))
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(170, Short.MAX_VALUE)
					.addComponent(lblLiga, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbLiga, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(289))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(lblInsertarPartido))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap(80, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLiga)
								.addComponent(cmbLiga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(41)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEquipoL)
						.addComponent(cmbEquipoL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGolesL)
						.addComponent(textGolesL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEquipoV)
						.addComponent(cmbEquipoV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGolesV)
						.addComponent(textGolesV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJornada)
						.addComponent(textJornada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblNewLabel_8)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar)
						.addComponent(btnAlta))
					.addGap(17))
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
