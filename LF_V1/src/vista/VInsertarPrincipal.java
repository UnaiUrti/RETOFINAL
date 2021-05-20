package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.LigaInterface;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInsertarPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VInsertarPrincipal(LigaInterface datos) {
		setBounds(100, 100, 599, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTitulo = new JLabel("INSERTAR");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblTitulo.setBounds(213, 44, 144, 62);
			contentPanel.add(lblTitulo);
		}
		{
			JButton btnNuevaLiga = new JButton("Nueva Liga");
			btnNuevaLiga.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnNuevaLiga.setBounds(74, 135, 120, 40);
			contentPanel.add(btnNuevaLiga);
		}
		{
			JButton btnNuevoEquipo = new JButton("Nuevo Equipo");
			btnNuevoEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarEquipo(datos);
				}
			});
			btnNuevoEquipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnNuevoEquipo.setBounds(74, 211, 120, 40);
			contentPanel.add(btnNuevoEquipo);
		}
		{
			JButton btnNuevoJugador = new JButton("Nuevo Jugador");
			btnNuevoJugador.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnNuevoJugador.setBounds(378, 135, 120, 40);
			contentPanel.add(btnNuevoJugador);
		}
		{
			JButton btnNuevoPartido = new JButton("Nuevo Partido");
			btnNuevoPartido.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnNuevoPartido.setBounds(378, 211, 120, 40);
			contentPanel.add(btnNuevoPartido);
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
	
	private void insertarEquipo(LigaInterface datos) {
		VInsertarEquipo equipo = new VInsertarEquipo(datos);
		this.dispose();
		equipo.setVisible(true);
		
	}

}
