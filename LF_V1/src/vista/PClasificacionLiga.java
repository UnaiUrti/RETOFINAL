package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Main;
import modelo.entidades.Liga;
import modelo.interfaces.LigaInterface;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PClasificacionLiga extends JPanel {
	
	private JTextField textNombreL;
	private JTextField textPaisL;
	private JTable tablaClasificacion;
	private LigaInterface datosLiga = Main.cargarLiga();
	private String[][] clasificacion;
	private VUsuarioMenu usuarioMenu;
	private Liga liga;
	private JButton btnVerEquipo;
	private JButton btnVerPartidos;
	private JButton btnVolver;

	
	/**
	 * Create the panel.
	 */
	public PClasificacionLiga(VUsuarioMenu usuarioMenu, Liga liga) {
		
		this.usuarioMenu = usuarioMenu;
		this.liga = liga;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblLigaNombre = new JLabel("Liga");
		lblLigaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblLigaNombre.setBounds(27, 29, 117, 29);
		add(lblLigaNombre);
		
		textNombreL = new JTextField();
		textNombreL.setText((String) null);
		textNombreL.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreL.setEditable(false);
		textNombreL.setColumns(10);
		textNombreL.setText(liga.getNombreL());
		textNombreL.setBounds(133, 29, 161, 29);
		add(textNombreL);
		
		JLabel lblLigaPais = new JLabel("Pais");
		lblLigaPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblLigaPais.setBounds(323, 29, 117, 29);
		add(lblLigaPais);
		
		textPaisL = new JTextField();
		textPaisL.setText((String) null);
		textPaisL.setHorizontalAlignment(SwingConstants.CENTER);
		textPaisL.setEditable(false);
		textPaisL.setColumns(10);
		textPaisL.setText(liga.getPaisL());
		textPaisL.setBounds(432, 29, 161, 29);
		add(textPaisL);
		

		String titulos[] = { "#","COD_EQ","EQUIPO","PJ","PG","PE","PE","GA","GE","PTS" };
		clasificacion = datosLiga.tablaClasificacion(liga.getCodL());
		
		DefaultTableModel model = new DefaultTableModel(clasificacion,titulos);
		tablaClasificacion = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tablaClasificacion.getTableHeader().setReorderingAllowed(false);
		//tablaClasificacion.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(tablaClasificacion);
		scrollPane.setBounds(26, 101, 636, 230);
		scrollPane.setVisible(true);
		tablaClasificacion.setVisible(true);
		
		// HACER INVISIBLE LA COUMNA DE CODIGO EQUIPO
		tablaClasificacion.getColumnModel().getColumn(1).setMinWidth(0);
		tablaClasificacion.getColumnModel().getColumn(1).setMaxWidth(0);

		tablaClasificacion.getColumnModel().getColumn(2).setMinWidth(180);
		// tablaClasificacion.getColumnModel().getColumnCount()
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaClasificacion.getColumnCount(); i++) {
			tablaClasificacion.getColumnModel().getColumn(i).setCellRenderer(alinear);
		}
		
		this.add(scrollPane);
		
		btnVerEquipo = new JButton("VER EQUIPO");
		btnVerEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEquipo();
			}
		});
		btnVerEquipo.setBounds(263, 356, 131, 34);
		add(btnVerEquipo);
		
		btnVerPartidos = new JButton("VER PARTIDOS");
		btnVerPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPartidos();
			}
		});
		btnVerPartidos.setBounds(404, 356, 131, 34);
		add(btnVerPartidos);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setBounds(545, 356, 117, 34);
		add(btnVolver);
		
	}
	
	private void volver() {
		
		PSeleccionarLiga seleccionarLiga = new PSeleccionarLiga(usuarioMenu);
		usuarioMenu.cambiarJPanel(seleccionarLiga);
		
	}
	
	private void verPartidos() {
		
		PVerPartidosJornada verPartidos = new PVerPartidosJornada(usuarioMenu, liga.getCodL());
		usuarioMenu.cambiarJPanel(verPartidos);
		
	}
	
	private void verEquipo() {
		
		if (tablaClasificacion.getSelectedRowCount()>1) {
			JOptionPane.showMessageDialog(this, "Selecciona solo un equipo");
		} else if (tablaClasificacion.getSelectedRowCount()==0) {
			JOptionPane.showMessageDialog(this, "Debes seleccionar un equipo");
		} else {
			String codE = tablaClasificacion.getModel().getValueAt(tablaClasificacion.getSelectedRow(), 1).toString();
			PVerEquipos verEquipos = new PVerEquipos(usuarioMenu, codE, liga);
			usuarioMenu.cambiarJPanel(verEquipos);
		}
		
	}
	
	
	
	
	
}
