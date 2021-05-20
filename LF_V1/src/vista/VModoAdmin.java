package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.Main;
import modelo.LigaInterface;
import modelo.UsuarioInterface;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VModoAdmin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private UsuarioInterface datosUsuario = Main.cargarUsuario();

	/**
	 * Create the dialog.
	 */
	public VModoAdmin() {
		
		setBounds(100, 100, 604, 441);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("MODO ADMIN");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblNewLabel.setBounds(164, 51, 251, 53);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnInsertar = new JButton("INSERTAR");
			btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertar();
				}
			});
			btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnInsertar.setBounds(31, 176, 150, 59);
			contentPanel.add(btnInsertar);
		}
		{
			JButton btnModificar = new JButton("MODIFICAR");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificar();
				}
			});
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnModificar.setBounds(215, 176, 150, 59);
			contentPanel.add(btnModificar);
		}
		{
			JButton btnEliminar = new JButton("ELIMINAR");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					baja();
				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnEliminar.setBounds(399, 176, 150, 59);
			contentPanel.add(btnEliminar);
		}
		{
			JButton btnVistaUsuario = new JButton("VISTA DE \r\nUSUARIO");
			btnVistaUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultar();
				}

			});
			btnVistaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnVistaUsuario.setBounds(215, 278, 150, 59);
			contentPanel.add(btnVistaUsuario);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRetroceder = new JButton("RETROCEDER");
				btnRetroceder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volver();
					}
				});
				btnRetroceder.setActionCommand("Cancel");
				buttonPane.add(btnRetroceder);
			}
		}
	}
	
	private void insertar() {
		VInsertarPrincipal insertar = new VInsertarPrincipal();
		this.dispose();
		insertar.setVisible(true);
		
	}
	
	private void modificar() {
		VBaja modificar = new VBaja(true);
		this.dispose();
		modificar.setVisible(true);
		
	}
	
	private void baja() {
		VBaja baja = new VBaja(false);
		this.dispose();
		baja.setVisible(true);
		
	}
	
	private void consultar() {
		VConsultaPrincipal consultar = new VConsultaPrincipal();
		this.dispose();
		consultar.setVisible(true);
		
	}
	
	private void volver() {
		VPrincipal pricipal = new VPrincipal();
		this.dispose();
		pricipal.setVisible(true);
		
	}

}
