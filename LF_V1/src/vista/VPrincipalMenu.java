package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class VPrincipalMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JButton btnAcceder;
	private JButton btnRegistrarse;
	private JLabel lblTitulo;
	private JButton btnSalir;

	public VPrincipalMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 487);
		
		ImageIcon icono = new ImageIcon("Recursos/balon de furbo.png");
		this.setIconImage(icono.getImage());
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.setBounds(230, 23, 697, 403);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		btnAcceder = new JButton("INICIAR SESION");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accederUsuario();
			}
		});
		btnAcceder.setBounds(28, 149, 192, 41);
		contentPane.add(btnAcceder);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		btnRegistrarse.setBounds(28, 231, 192, 41);
		contentPane.add(btnRegistrarse);
		
		lblTitulo = new JLabel("FutLiga");
		lblTitulo.setToolTipText("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblTitulo.setBounds(28, 40, 184, 73);
		contentPane.add(lblTitulo);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(28, 307, 192, 41);
		contentPane.add(btnSalir);
	}
	
	public void registrarse() {
		PRegistrar registrarse = new PRegistrar();
		cambiarJPanel(registrarse);
	}
	
	public void salir() {
		this.dispose();
	}
	
	public void accederUsuario() {
		PAcceder acceder = new PAcceder(this);
		cambiarJPanel(acceder);
	}
	
	public void cambiarJPanel(JPanel panel) {
		//REMUEVE TODOS LOS COMPONENTES
		layeredPane.removeAll();
		//AÑADE EL COMPONENTE PANEL
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	
}
