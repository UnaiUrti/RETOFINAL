package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAdminMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	public VAdminMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 487);
		
		ImageIcon icono = new ImageIcon("Recursos/balon de furbo.png");
		this.setIconImage(icono.getImage());
		
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
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setToolTipText("");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblAdmin.setBounds(21, 32, 184, 73);
		contentPane.add(lblAdmin);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarMenu();
			}
		});
		btnInsertar.setBounds(21, 116, 184, 48);
		contentPane.add(btnInsertar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(21, 175, 184, 48);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(21, 234, 184, 48);
		contentPane.add(btnEliminar);
		
		JButton btnVistaUsuario = new JButton("VISTA DE USUARIO");
		btnVistaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaUsuario();
			}
		});
		btnVistaUsuario.setBounds(21, 293, 184, 48);
		contentPane.add(btnVistaUsuario);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(21, 352, 184, 48);
		contentPane.add(btnSalir);
		
	}
	
	private void eliminar() {
		PEliminarModificarMenu bajaMenu = new PEliminarModificarMenu(this, false);
		cambiarJPanel(bajaMenu);
	}
	
	private void modificar() {
		PEliminarModificarMenu bajaMenu = new PEliminarModificarMenu(this, true);
		cambiarJPanel(bajaMenu);
	}
	
	private void insertarMenu() {
		PInsertarMenu insertarMenu = new PInsertarMenu(this);
		cambiarJPanel(insertarMenu);
	}
	
	public void cambiarJPanel(JPanel panel) {
		//REMUEVE TODOS LOS COMPONENTES
		layeredPane.removeAll();
		//AÑADE EL COMPONENTE PANEL
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private void vistaUsuario() {
		this.dispose();
		VUsuarioMenu usuarioMenu = new VUsuarioMenu();
		usuarioMenu.setVisible(true);
	}
	
	private void salir() {
		this.dispose();
	}
	
}
