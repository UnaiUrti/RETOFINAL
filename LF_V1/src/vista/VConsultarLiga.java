package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import aplicacion.Main;
import modelo.Clasificacion;
import modelo.Liga;
import modelo.LigaInterface;

public class VConsultarLiga extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textPais;
	private LigaInterface datosLiga = Main.cargarLiga();
	private ArrayList<Clasificacion> clasificacion;
	private Liga liga;
	private VConsultaPrincipal vConsultaPrincipal;
	private JTable tablaClasificacion;

	/**
	 * Create the dialog.
	 */
	public VConsultarLiga(VConsultaPrincipal vConsultaPrincipal ,Liga liga) {
		
		this.vConsultaPrincipal = vConsultaPrincipal;
		this.liga = liga;
		
		setBounds(100, 100, 600, 440);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setText(liga.getNombreL());
		textNombre.setEditable(false);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setText(liga.getPaisL());
		textPais.setEditable(false);
		
		JButton btnPartidos = new JButton("Partidos");
		
		//AÑADIR DATOS A LA TABLA
		String titulos[] = { "PUESTO","NOMBRE EQUIPO","PJ","PG","PE","PE","GA","GE","PTS" };
		String informacion[][] = obtenerDatosClasi();
		
		//CREAR LA TABLA CON LOS DATOS CREADOS
		tablaClasificacion = new JTable();
		tablaClasificacion.setModel(new DefaultTableModel(informacion,titulos));
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(tablaClasificacion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblPais)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPais, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(btnPartidos)))
					.addGap(31))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPais)
						.addComponent(textPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPartidos))
					.addGap(18)
					.addComponent(tablaClasificacion, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Volver");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
	}
	
	private String[][] obtenerDatosClasi() {
		
		clasificacion = datosLiga.tablaClasificacion(liga.getCodL());
		
		String informacion[][] = new String[clasificacion.size()][9];
		
		for (int i = 0; i < informacion.length; i++) {
			 informacion[i][0] = clasificacion.get(i).getPuesto() + ""; //EL +""; ES PARA HACER UN FAKE DE PARSEO A UN STRING
			 informacion[i][1] = clasificacion.get(i).getNombreE() + "";
			 informacion[i][2] = clasificacion.get(i).getpJugados() + "";
			 informacion[i][3] = clasificacion.get(i).getpGanados() + "";
			 informacion[i][4] = clasificacion.get(i).getpEmpatados() + "";
			 informacion[i][5] = clasificacion.get(i).getpPerdidos() + "";
			 informacion[i][6] = clasificacion.get(i).getgAFavor() + "";
			 informacion[i][7] = clasificacion.get(i).getgEnContra() + "";
			 informacion[i][8] = clasificacion.get(i).getPtsTotal() + "";
		}
		return informacion;
	}
	
}
