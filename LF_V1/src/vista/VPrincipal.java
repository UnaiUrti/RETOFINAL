
package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.Main;
import modelo.LigaInterface;
import modelo.UsuarioInterface;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioInterface datosUsuario = Main.cargarUsuario();
	
	/**
	 * Create the frame.
	 */
	public VPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 440);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("FutLiga");
		lblTitulo.setToolTipText("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Playbill", Font.PLAIN, 70));
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accederUsuario();
			}
		});
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarUsuario();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(219)
					.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(234))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(btnAcceder, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(130)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(44))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAcceder, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
					.addGap(52))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void registrarUsuario() {
		VRegistrarse registrar = new VRegistrarse();
		this.dispose();
		registrar.setVisible(true);
	}
	
	private void accederUsuario() {
		VAcceder acceder = new VAcceder();
		this.dispose();
		acceder.setVisible(true);
	}
	
}
