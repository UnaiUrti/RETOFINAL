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
		lblEliminar.setBounds(50, 39, 72, 25);
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblLiga = new JLabel("Liga:");
		lblLiga.setBounds(87, 160, 30, 19);
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(87, 211, 47, 19);
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setBounds(87, 262, 56, 19);
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JComboBox cmbJugador = new JComboBox();
		cmbJugador.setBounds(153, 262, 118, 22);
		JComboBox cmbEquipo = new JComboBox();
		cmbEquipo.setBounds(152, 211, 119, 22);
		JComboBox cmbLiga = new JComboBox();
		cmbLiga.setBounds(152, 160, 119, 22);
		JButton btnBaja = new JButton("BAJA");
		btnBaja.setBounds(441, 195, 57, 23);
		contentPanel.setLayout(null);
		contentPanel.add(lblJugador);
		contentPanel.add(cmbJugador);
		contentPanel.add(lblEquipo);
		contentPanel.add(lblLiga);
		contentPanel.add(cmbLiga);
		contentPanel.add(cmbEquipo);
		contentPanel.add(btnBaja);
		contentPanel.add(lblEliminar);
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
