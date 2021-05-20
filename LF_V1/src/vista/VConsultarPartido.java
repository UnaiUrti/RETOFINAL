package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import aplicacion.Main;
import modelo.EquipoInterface;
import modelo.Partido;
import modelo.PartidoInterface;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VConsultarPartido extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaPartidos;
	private String[][] partidos;
	private int[] jornadasL;
	private PartidoInterface datosPartido=Main.cargarPartido();
	VConsultarEquipo vConsultarEquipo;
	private String codL;
	private JComboBox cbJornada;
	
	/**
	 * Create the dialog.
	 */
	public VConsultarPartido(String codL) {
		
		this.codL = codL;
		
		setBounds(100, 100, 601, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Selecciona una jornada");
		lblNewLabel.setBounds(127, 34, 111, 14);
		
		jornadasL = datosPartido.jornadasLiga(codL);
		
		
		
		cbJornada = new JComboBox();
		
		
		
		for (int i = 0; i < jornadasL.length; i++) {
			cbJornada.addItem(jornadasL[i]);
		}
		
		cbJornada.setSelectedIndex(jornadasL.length-1);
		cbJornada.setBounds(308, 34, 170, 22);
		String titulos[] = { "FECHA","EQUIPO L","GOLES L","GOLES V","EQUIPO V" };
		partidos = datosPartido.partidosJornada(codL,jornadasL[cbJornada.getSelectedIndex()]);
		DefaultTableModel model = new DefaultTableModel(partidos,titulos);
		tablaPartidos = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tablaPartidos);
		tablaPartidos.setBounds(542, 103, 209, 48);
		scrollPane.setVisible(true);
		tablaPartidos.setVisible(true);
		scrollPane.setLocation(59, 86);
		scrollPane.setSize(442, 231);
		tablaPartidos.setEnabled(false);
		
		cbJornada.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				partidosJornada(model, titulos);
			}
		});
		
		
		tablaPartidos.getColumnModel().getColumn(0).setMinWidth(100);
		tablaPartidos.getColumnModel().getColumn(1).setMinWidth(150);
		tablaPartidos.getColumnModel().getColumn(2).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(3).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(4).setMinWidth(150);
		
		contentPanel.setLayout(null);
		contentPanel.add(lblNewLabel);
		contentPanel.add(cbJornada);
		contentPanel.add(scrollPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Volver\r\n");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
	}
	
	private void partidosJornada(DefaultTableModel model, String titulos[]) {
		partidos = datosPartido.partidosJornada(codL,jornadasL[cbJornada.getSelectedIndex()]);
		model.setDataVector(partidos, titulos);
		tablaPartidos.setModel(model);
	}
	
}
