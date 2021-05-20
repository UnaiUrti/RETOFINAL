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
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class VConsultaMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	public VConsultaMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 425);
		
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
		layeredPane.setBounds(246, 11, 612, 364);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setToolTipText("");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblUsuario.setBounds(29, 35, 184, 73);
		contentPane.add(lblUsuario);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(29, 289, 192, 41);
		contentPane.add(btnSalir);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguientePanel();
			}
		});
		btnSiguiente.setBounds(29, 149, 192, 41);
		contentPane.add(btnSiguiente);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(29, 219, 192, 41);
		contentPane.add(btnAtras);
	}
	
	public void siguientePanel() {
		PConsultaPrincipal consultaPrincipal = new PConsultaPrincipal();
		cambiarJPanel(consultaPrincipal);
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
