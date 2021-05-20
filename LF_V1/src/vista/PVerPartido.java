package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Main;
import modelo.interfaces.PartidoInterface;

import javax.swing.JTextField;
import java.awt.Rectangle;

public class PVerPartido extends JPanel {
	
	private JTextField textFecha;
	private String codP;
	private String[][] partido;
	private String[][] goles;
	//private String[][] golL;
	//private String[][] golV;
	private PartidoInterface datosPartido=Main.cargarPartido();
	private JTable tablaPartido;
	private JTable tablaGoles;
	//private JTable tablaGolL;
	//private JTable tablaGolV;
	
	public PVerPartido(String codP) {

		this.codP = codP;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(159, 35, 111, 31);
		add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setBounds(263, 37, 167, 26);
		add(textFecha);
		textFecha.setColumns(10);
	
		String titulosPartido[] = {"FECHA","EQUIPO L","GOLES L","GOLES V","EQUIPO V" };
		partido = datosPartido.buscarPartido(codP);
		textFecha.setText(partido[0][0]);
		DefaultTableModel modelPartido = new DefaultTableModel(partido,titulosPartido);
		tablaPartido = new JTable(modelPartido)  {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollPartido = new JScrollPane(tablaPartido);
		scrollPartido.setBounds(new Rectangle(29, 94, 645, 48));
		add(scrollPartido);
		
		tablaPartido.getColumnModel().getColumn(0).setMinWidth(0);
		tablaPartido.getColumnModel().getColumn(0).setMaxWidth(0);
		
		tablaPartido.getTableHeader().setReorderingAllowed(false);
		
		// ALINEAR TEXTO
		DefaultTableCellRenderer alinearPartido = new DefaultTableCellRenderer();
		alinearPartido.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaPartido.getColumnCount(); i++) {
			tablaPartido.getColumnModel().getColumn(i).setCellRenderer(alinearPartido);
		}
		
		//TABLA GOLES
		String tituloGoles[] = {"MIN", "JUGADOR", "EQUIPO"};
		goles = datosPartido.partidoGoles(codP);
		DefaultTableModel modelGoles = new DefaultTableModel(goles,tituloGoles);
		tablaGoles = new JTable(modelGoles)  {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollGoles = new JScrollPane(tablaGoles);
		scrollGoles.setBounds(new Rectangle(110, 174, 457, 167));
		add(scrollGoles);
		
		tablaGoles.getTableHeader().setReorderingAllowed(false);
		
		DefaultTableCellRenderer alinearGoles = new DefaultTableCellRenderer();
		alinearGoles.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaGoles.getColumnCount(); i++) {
			tablaGoles.getColumnModel().getColumn(i).setCellRenderer(alinearGoles);
		}

		
	}
	
}
