package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Liga;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class VInsertarJugador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textPais;
	private JTextField textDorsal;

	/**
	 * Create the dialog.
	 */
	public VInsertarJugador() {
		setBounds(100, 100, 600, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblInsertarJugador = new JLabel("Insertar Jugador");
		lblInsertarJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JComboBox cmbLiga = new JComboBox();
		JLabel lblLiga = new JLabel("Liga: ");
		lblLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JComboBox cmbEquipo = new JComboBox();
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre = new JTextField();
		textNombre.setColumns(10);
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPais = new JTextField();
		textPais.setColumns(10);
		JLabel lblDorsal = new JLabel("Dorsal: ");
		lblDorsal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDorsal = new JTextField();
		textDorsal.setColumns(10);
		JLabel lblPosicion = new JLabel("Posicion: ");
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JComboBox cmbPosicion = new JComboBox();
		JButton btnAlta = new JButton("ALTA");
		JButton btnModificar = new JButton("MODIFICAR");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(59)
					.addComponent(lblInsertarJugador, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(49)
					.addComponent(lblLiga, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cmbLiga, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(49)
					.addComponent(lblEquipo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cmbEquipo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNombre)
					.addGap(4)
					.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(86)
					.addComponent(lblDorsal)
					.addGap(18)
					.addComponent(textDorsal, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(49)
					.addComponent(lblPais, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(textPais, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(117)
					.addComponent(lblPosicion)
					.addGap(10)
					.addComponent(cmbPosicion, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(115)
					.addComponent(btnAlta)
					.addGap(134)
					.addComponent(btnModificar))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblInsertarJugador)
					.addGap(47)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLiga)
						.addComponent(cmbLiga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEquipo)
						.addComponent(cmbEquipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDorsal)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(textDorsal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPais)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(textPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPosicion)
						.addComponent(cmbPosicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAlta)
						.addComponent(btnModificar)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Cancel");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
		
		cargarLigas();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
private void altaEquipo() {
			
			
			/*String  pos= Integer.toString(comboLiga.getSelectedIndex()+1);
			String codigoLiga = "";
			String codLigNum;
			
			for (Liga liga : ligas.values()) {
				
				if(liga.getCodL().substring(2).equals("0")) {
					if(liga.getCodL().substring(3, liga.getCodL().length()) == pos) {
						codigoLiga = liga.getCodL();
					}
				}
				else if(liga.getCodL().substring(2, liga.getCodL().length()) == pos) {
					codigoLiga = liga.getCodL();
				}
			}*/
			
			String  cadena= (String) comboLiga.getSelectedItem();
			int pos=cadena.indexOf(" ");
			String codigoLiga = cadena.substring(0, pos);
			
			datosEquipo.altaEquipo(textNombre.getText(), codigoLiga);
			
			//
			JOptionPane.showMessageDialog(this, "Equipo dado de alta correctamente");
			textNombre.setText("");
			comboLiga.setSelectedIndex(-1);
			
		}
		
		private void cargarEquipos() {
			
			equipos = datosEquipo.todasLiga();
			
			for (Liga liga : ligas.values()) {
				comboLiga.addItem(liga.getCodL() +"   "+ liga.getNombreL());
			}
			
			
		}
}
