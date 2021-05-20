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

public class VConsultarPartido extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaPartidos;
	private String[][] partidos;
	private PartidoInterface datosPartido=Main.cargarPartido();
	VConsultarEquipo vConsultarEquipo;
	private String codL;
	private int jornada;

	/**
	 * Create the dialog.
	 */
	public VConsultarPartido(VConsultarEquipo vConsultarEquipo, String codL) {
		
		this.vConsultarEquipo = vConsultarEquipo;
		this.codL = codL;
		
		setBounds(100, 100, 601, 430);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		String titulos[] = { "FECHA","EQUIPO L","GOLES L","GOLES V","EQUIPO V" };
		partidos = datosPartido.partidosJornada(codL, jornada);
		
		DefaultTableModel model = new DefaultTableModel(partidos,titulos);
		tablaPartidos = new JTable();
		JScrollPane scrollPane = new JScrollPane(tablaPartidos);
		tablaPartidos.setBounds(542, 103, 209, 48);
		scrollPane.setVisible(true);
		tablaPartidos.setVisible(true);
		scrollPane.setLocation(271, 103);
		scrollPane.setSize(508, 200);
		
		tablaPartidos.setEnabled(false);
		
		tablaPartidos.getColumnModel().getColumn(0).setMinWidth(100);
		tablaPartidos.getColumnModel().getColumn(1).setMinWidth(150);
		tablaPartidos.getColumnModel().getColumn(2).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(3).setMinWidth(20);
		tablaPartidos.getColumnModel().getColumn(4).setMinWidth(150);
		
		JComboBox cbJornada = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(235, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(342))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cbJornada, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tablaPartidos, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(cbJornada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
					.addComponent(tablaPartidos, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(223, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(127))
		);
		contentPanel.setLayout(gl_contentPanel);
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
}
