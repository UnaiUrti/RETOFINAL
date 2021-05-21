package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Main;
import modelo.entidades.Liga;
import modelo.interfaces.PartidoInterface;

import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PVerPartido extends JPanel {
	
	private JTextField textFecha;
	private String codP;
	private String[][] partido;
	private String[][] goles;
	private PartidoInterface datosPartido=Main.cargarPartido();
	private JTable tablaPartido;
	private JTable tablaGoles;
	private VUsuarioMenu usuarioMenu;
	private Liga liga;
	private String codL;
	
	public PVerPartido(VUsuarioMenu usuarioMenu, Liga liga, String codL, String codP) {
		
		this.usuarioMenu = usuarioMenu;
		this.liga = liga;
		this.codL = codL;
		this.codP = codP;
		
		setLayout(null);
		this.setBounds(230, 23, 697, 403);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(159, 35, 111, 31);
		add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setBounds(263, 37, 167, 26);
		add(textFecha);
		textFecha.setColumns(10);
		textFecha.setEditable(false);
	
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
		scrollGoles.setBounds(new Rectangle(67, 205, 569, 136));
		add(scrollGoles);
		
		JLabel lblNewLabel = new JLabel("GOLES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 163, 268, 31);
		add(lblNewLabel);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setBounds(544, 355, 130, 37);
		add(btnVolver);
		
		tablaGoles.getTableHeader().setReorderingAllowed(false);
		
		DefaultTableCellRenderer alinearGoles = new DefaultTableCellRenderer();
		alinearGoles.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaGoles.getColumnCount(); i++) {
			tablaGoles.getColumnModel().getColumn(i).setCellRenderer(alinearGoles);
		}

		
	}
	
	private void volver() {
		
		PVerPartidosJornada verPartidosJornada = new PVerPartidosJornada(usuarioMenu,liga, codL);
		usuarioMenu.cambiarJPanel(verPartidosJornada);
		
	}
	
}
