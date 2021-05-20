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

import javax.swing.LayoutStyle.ComponentPlacement;

public class VModificarPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VModificarPrincipal() {
		setBounds(100, 100, 600, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblModificar = new JLabel("MODIFICAR");
		lblModificar.setBounds(205, 47, 157, 37);
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JButton btnLiga = new JButton("LIGA");
		btnLiga.setBounds(104, 138, 82, 32);
		JButton btnEquipo = new JButton("EQUIPO");
		btnEquipo.setBounds(248, 202, 82, 33);
		JButton btnJugador = new JButton("JUGADOR");
		btnJugador.setBounds(385, 138, 81, 32);
		contentPanel.setLayout(null);
		contentPanel.add(lblModificar);
		contentPanel.add(btnEquipo);
		contentPanel.add(btnLiga);
		contentPanel.add(btnJugador);
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
