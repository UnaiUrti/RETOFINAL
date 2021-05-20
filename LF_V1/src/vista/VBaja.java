package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VBaja extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VBaja() {
		setBounds(100, 100, 600, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblPartido = new JLabel("Partido:");
		lblPartido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblGol = new JLabel("Gol:");
		lblGol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JComboBox cmbJugador = new JComboBox();
		JComboBox cmbEquipo = new JComboBox();
		JComboBox cmbLiga = new JComboBox();
		JComboBox cmbPartido = new JComboBox();
		JComboBox cmbGol = new JComboBox();
		JButton btnBaja = new JButton("BAJA");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(82)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblJugador)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cmbJugador, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEquipo)
								.addComponent(lblLiga))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbLiga, 0, 119, Short.MAX_VALUE)
								.addComponent(cmbEquipo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPartido)
								.addComponent(lblGol))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbGol, 0, 117, Short.MAX_VALUE)
								.addComponent(cmbPartido, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(btnBaja)
					.addGap(81))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(45)
					.addComponent(lblEliminar)
					.addContainerGap(457, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEliminar)
							.addGap(54)
							.addComponent(lblLiga))
						.addComponent(cmbLiga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEquipo)
						.addComponent(cmbEquipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador)
						.addComponent(cmbJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBaja))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPartido)
						.addComponent(cmbPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGol)
						.addComponent(cmbGol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(74, Short.MAX_VALUE))
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
