package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Main;
import modelo.interfaces.PartidoInterface;


import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PVerPartidosJornada extends JPanel {

	private JComboBox cbJornada;	
	private JTable tablaPartidos;
	private String[][] partidos;
	private int[] jornadasL;
	private PartidoInterface datosPartido=Main.cargarPartido();
	private String codL;
	private VUsuarioMenu usuarioMenu;
	
	public PVerPartidosJornada(VUsuarioMenu usuarioMenu, String codL) {

		this.usuarioMenu = usuarioMenu;
		this.codL = codL;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblJornada = new JLabel("JORNADA");
		lblJornada.setHorizontalAlignment(SwingConstants.CENTER);
		lblJornada.setBounds(215, 36, 131, 44);
		add(lblJornada);
		
		cbJornada = new JComboBox();
		cbJornada.setSelectedIndex(-1);
		cbJornada.setBounds(338, 47, 53, 22);
		add(cbJornada);
		
		jornadasL = datosPartido.jornadasLiga(codL);
		for (int i = 0; i < jornadasL.length; i++) {
			cbJornada.addItem(jornadasL[i]);
		}
		
		cbJornada.setSelectedIndex(jornadasL.length-1);
		
		//JTABLE
		String titulos[] = { "FECHA","EQUIPO L","GOLES L","GOLES V","EQUIPO V" };
		partidos = datosPartido.partidosJornada(codL,jornadasL[cbJornada.getSelectedIndex()]);
		
		DefaultTableModel modelPartidos = new DefaultTableModel(partidos,titulos);
		tablaPartidos = new JTable(modelPartidos)  {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollPartidos = new JScrollPane(tablaPartidos);
		scrollPartidos.setLocation(45, 91);
		scrollPartidos.setSize(607, 238);
		add(scrollPartidos);
		
		tablaPartidos.getTableHeader().setReorderingAllowed(false);
		
		//ALINEAR TEXTO
		DefaultTableCellRenderer alinearPartidos = new DefaultTableCellRenderer();
		alinearPartidos.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaPartidos.getColumnCount(); i++) {
			tablaPartidos.getColumnModel().getColumn(i).setCellRenderer(alinearPartidos);
		}
		
		JButton btnVerPartido = new JButton("VER PARTIDO");
		btnVerPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPartido();
			}
		});
		btnVerPartido.setBounds(496, 351, 146, 41);
		add(btnVerPartido);
		
		tablaPartidos.getColumnModel().getColumn(0).setMinWidth(100);
		tablaPartidos.getColumnModel().getColumn(1).setMinWidth(150);
		tablaPartidos.getColumnModel().getColumn(2).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(3).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(4).setMinWidth(150);
		
		//ITEM CAHNGED
		cbJornada.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				partidosJornada(modelPartidos, titulos);
			}
		});
		
	}
	
	private void partidosJornada(DefaultTableModel model, String titulos[]) {
		partidos = datosPartido.partidosJornada(codL,jornadasL[cbJornada.getSelectedIndex()]);
		model.setDataVector(partidos, titulos);
		tablaPartidos.setModel(model);
	}
	
	private void verPartido() {
		
		if (tablaPartidos.getSelectedRowCount()>1) {
			JOptionPane.showMessageDialog(this, "Selecciona solo un partido");
		} else if (tablaPartidos.getSelectedRowCount()==0) {
			JOptionPane.showMessageDialog(this, "Debes seleccionar un partido");
		} else {
			String codP = partidos[tablaPartidos.getSelectedRow()][5];
			PVerPartido verPartido = new PVerPartido(codP);
			usuarioMenu.cambiarJPanel(verPartido);
		}
		
	}
	
}
