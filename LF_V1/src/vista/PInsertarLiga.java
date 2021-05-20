package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controlador.Main;
import modelo.interfaces.LigaInterface;
import modelo.entidades.Liga;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PInsertarLiga extends JPanel {
	
	private JTextField textNombre;
	private JTextField textPais;
	private LigaInterface datosLiga = Main.cargarLiga();
	private Liga liga;

	public PInsertarLiga(boolean altaOculto, Liga liga) {
		
		this.liga = liga;
		
		setLayout(null);
		this.setBounds(246, 11, 697, 403);
		
		JLabel lblInsertarLiga = new JLabel("Insertar Liga");
		lblInsertarLiga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertarLiga.setBounds(54, 41, 160, 36);
		add(lblInsertarLiga);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(100, 125, 74, 36);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(205, 135, 137, 20);
		add(textNombre);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPais.setBounds(100, 189, 46, 14);
		add(lblPais);
		
		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setBounds(205, 188, 137, 20);
		add(textPais);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaLiga();
			}
		});
		btnAlta.setBounds(389, 327, 89, 23);
		add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarLiga();
			}
		});
		btnModificar.setBounds(521, 327, 89, 23);
		add(btnModificar);
		
	}
	
	private void modificarLiga() {
		
		if(textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN NOMBRE A LA LIGA");
		}else if(textPais.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN PAIS A LA LIGA");
		}else {
			datosLiga.modificaLiga(textNombre.getText(), textPais.getText(), liga.getCodL());
			JOptionPane.showMessageDialog(this, "Liga modificada correctamente");
		}
	}
	
	private void altaLiga() {

		if (textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN NOMBRE A LA LIGA");
		} else if (textPais.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "DEBES PONERLE UN PAIS A LA LIGA");
		} else {
			datosLiga.altaLiga(textNombre.getText(), textPais.getText());

			JOptionPane.showMessageDialog(this, "Liga dada de alta correctamente");
			textNombre.setText("");
			textPais.setText("");
		}

	}
	
}
