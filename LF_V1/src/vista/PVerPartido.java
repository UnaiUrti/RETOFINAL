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
	private String[][] golL;
	private String[][] golV;
	private PartidoInterface datosPartido=Main.cargarPartido();
	private JTable tablaPartido;
	private JTable tablaGolL;
	private JTable tablaGolV;
	
	public PVerPartido(String codP) {

		this.codP = codP;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(159, 35, 111, 31);
		add(lblFecha);
		
		textFecha = new JTextField();
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
		scrollPartido.setBounds(new Rectangle(29, 94, 645, 36));
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
		
		//TABLA GOL LOCAL
		String tituloGolL[] = {"MIN", "JUGADOR"};
		
		DefaultTableModel modelGolL = new DefaultTableModel(goles,tituloGolL);
		tablaGolL = new JTable(modelGolL)  {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollGolL = new JScrollPane(tablaGolL);
		scrollGolL.setBounds(new Rectangle(29, 154, 200, 200));
		add(scrollGolL);
		
		
		//TABLA GOL VISITANTE
		String tituloGolV[] = {"MIN", "JUGADOR"};
	
		DefaultTableModel modelGolV = new DefaultTableModel(goles,tituloGolV);
		tablaGolV = new JTable(modelGolV)  {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollGolV = new JScrollPane(tablaGolV);
		scrollGolV.setBounds(new Rectangle(474, 154, 200, 200));
		add(scrollGolV);
		
		cargarGoles();
		
	}
	
	private void cargarGoles() {
		
		goles = datosPartido.partidoGoles(codP);
		
        for (int i=0;i<goles.length;i++){
        	if (goles[i][2].equalsIgnoreCase(partido[0][1])) {
        		golL[i][0] = goles[0][0];
        		golL[i][2] = goles[0][1];
        	} else {
        		golV[i][0] = goles[0][0];
        		golV[i][2] = goles[0][1];
        	}
        }
		
	}
	
	
}
