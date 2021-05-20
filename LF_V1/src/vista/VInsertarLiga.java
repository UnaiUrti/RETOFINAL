package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.Main;
import modelo.EquipoInterface;
import modelo.Liga;
import modelo.LigaInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInsertarLiga extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textPais;
	private LigaInterface datosLiga = Main.cargarLiga();

	/**
	 * Create the dialog.
	 */
	public VInsertarLiga(boolean altaOculto, Liga liga) {
		setBounds(100, 100, 681, 455);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInsertarLiga = new JLabel("Insertar Liga");
		lblInsertarLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertarLiga.setBounds(34, 33, 160, 36);
		contentPanel.add(lblInsertarLiga);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(45, 145, 74, 36);
		contentPanel.add(lblNombre);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPais.setBounds(45, 227, 46, 14);
		contentPanel.add(lblPais);
		
		textNombre = new JTextField();
		textNombre.setBounds(136, 155, 137, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textPais = new JTextField();
		textPais.setBounds(136, 227, 137, 20);
		contentPanel.add(textPais);
		textPais.setColumns(10);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaLiga();
			}
		});
		btnAlta.setBounds(84, 312, 89, 23);
		contentPanel.add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificaLiga(liga);
			}
		});
		btnModificar.setBounds(275, 312, 89, 23);
		contentPanel.add(btnModificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("RETROCEDER");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volverAtras();
					}
				});
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
		
		if(altaOculto) {
			btnAlta.setEnabled(false);
			textNombre.setText(liga.getNombreL());
			textPais.setText(liga.getPaisL());
		}else {
			btnModificar.setEnabled(false);
		}
	}
	
	private void altaLiga() {
		
		if(textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN NOMBRE A LA LIGA");
		}else if(textPais.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN PAIS A LA LIGA");
		}else {
			datosLiga.altaLiga(textNombre.getText(), textPais.getText());
			
			//
			JOptionPane.showMessageDialog(this, "Liga dada de alta correctamente");
			textNombre.setText("");
			textPais.setText("");
		}
		
	}
	
	private void modificaLiga(Liga liga) {
		
		if(textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN NOMBRE A LA LIGA");
		}else if(textPais.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN PAIS A LA LIGA");
		}else {
			datosLiga.modificaLiga(textNombre.getText(), textPais.getText(), liga.getCodL());
			JOptionPane.showMessageDialog(this, "Liga modificada correctamente");
		}
	}
	
	
	
	private void volverAtras() {
		this.dispose();
		VInsertarPrincipal  ventanaInsertarPrincipal = new VInsertarPrincipal();
		ventanaInsertarPrincipal.setVisible(true);
		
	}
}
