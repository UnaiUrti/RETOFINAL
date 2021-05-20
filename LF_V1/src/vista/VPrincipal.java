package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class VPrincipal extends JFrame {

	private JPanel contentPane;
	
	public VPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 440);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("FutLiga");
		lblTitulo.setBounds(248, 112, 200, 100);
		lblTitulo.setToolTipText("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Playbill", Font.PLAIN, 70));
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBounds(122, 240, 192, 79);
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accederUsuario();
			}
		});
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.setBounds(384, 240, 197, 79);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarUsuario();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.setLayout(null);
		contentPane.add(lblTitulo);
		contentPane.add(btnAcceder);
		contentPane.add(btnNewButton);
	}
	
	private void registrarUsuario() {
		VRegistrarse registrar = new VRegistrarse(this,true);
		/*
		this.setVisible(false);
		*/
		registrar.setVisible(true);
	}
	
	private void accederUsuario() {
		/*
		Container contain = getContentPane();
        contain.removeAll();
        pruebaVPrincipal pv = new pruebaVPrincipal();
        contain.add(pv);
        pv.setBounds(0,0,200,200);
		validate();
		repaint();
		setVisible(true);
		*/
		
		VAcceder acceder = new VAcceder(this);
		this.setVisible(false);
		acceder.setVisible(true);
		
	}
	
}
