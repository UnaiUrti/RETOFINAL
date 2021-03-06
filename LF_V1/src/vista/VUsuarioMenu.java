package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class VUsuarioMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	public VUsuarioMenu(boolean admin) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 487);

		// ICONO DEL JFRAME
		ImageIcon icono = new ImageIcon("Recursos/futboldehonor.png");
		this.setIconImage(icono.getImage());

		// CALCULAR DONDE ESTA EL CENTRO DE LA PANTALLA
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(layeredPane);
		layeredPane.setBounds(230, 23, 697, 403);
		layeredPane.setLayout(new CardLayout(0, 0));

		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("Recursos/campoDeFutbol.jpg"));
		layeredPane.add(lblImagen);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setToolTipText("");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblUsuario.setBounds(21, 36, 184, 73);
		contentPane.add(lblUsuario);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(21, 280, 192, 41);
		contentPane.add(btnSalir);

		JButton btnInicio = new JButton("INICIO");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguientePanel();
			}
		});
		btnInicio.setBounds(21, 155, 192, 41);
		contentPane.add(btnInicio);

		JButton btnVistaAdmin = new JButton("VOLVER");
		btnVistaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVistaAdmin.setBounds(21, 218, 192, 41);
		contentPane.add(btnVistaAdmin);

		if (admin) {
			btnVistaAdmin.setVisible(true);
		} else {
			btnVistaAdmin.setVisible(false);
		}

	}

	private void volver() {
		this.dispose();
		VAdminMenu adminMenu = new VAdminMenu();
		adminMenu.setVisible(true);
	}

	private void salir() {
		this.dispose();
	}

	public void siguientePanel() {
		PSeleccionarLiga seleccionarLiga = new PSeleccionarLiga(this);
		cambiarJPanel(seleccionarLiga);
	}

	public void cambiarJPanel(JPanel panel) {
		// REMUEVE TODOS LOS COMPONENTES
		layeredPane.removeAll();
		// A?ADE EL COMPONENTE PANEL
		layeredPane.add(panel);
		// VUELVE A "PINTAR" EL PANEL
		layeredPane.repaint();
		// VOLVEMOS A VALIDAR LOS COMPONENTES DEL JPANEL YA QUE HAN SIDO REMOVIDOS O SE HAN A?ADIDO NUEVOS COMPONENTES
		layeredPane.revalidate();
	}
}
