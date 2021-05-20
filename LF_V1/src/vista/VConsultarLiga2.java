package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import aplicacion.Main;
import modelo.Liga;
import modelo.LigaInterface;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VConsultarLiga2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombreL;
	private JTextField textPaisL;
	private Liga liga;
	private VConsultaPrincipal vConsultaPrincipal;
	private String[][] clasificacion;
	private LigaInterface datosLiga = Main.cargarLiga();
	private JTable tablaClasificacion;

	public VConsultarLiga2(VConsultaPrincipal vConsultaPrincipal ,Liga liga) {
		
		this.vConsultaPrincipal = vConsultaPrincipal;
		this.liga = liga;
		
		setBounds(100, 100, 768, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBounds(new Rectangle(29, 18, 500, 500));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		JLabel lblLigaNombre = new JLabel("Nombre");
		lblLigaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblLigaNombre.setBounds(28, 38, 117, 29);
		contentPanel.add(lblLigaNombre);
		
		textNombreL = new JTextField();
		textNombreL.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreL.setBounds(155, 38, 161, 29);
		contentPanel.add(textNombreL);
		textNombreL.setColumns(10);
		textNombreL.setText(liga.getNombreL());
		textNombreL.setEditable(false);
		
		JLabel lblLigaPais = new JLabel("Pais");
		lblLigaPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblLigaPais.setBounds(326, 38, 117, 29);
		contentPanel.add(lblLigaPais);
		
		textPaisL = new JTextField();
		textPaisL.setHorizontalAlignment(SwingConstants.CENTER);
		textPaisL.setColumns(10);
		textPaisL.setBounds(445, 38, 161, 29);
		contentPanel.add(textPaisL);
		textPaisL.setText(liga.getPaisL());
		textPaisL.setEditable(false);
		
		String titulos[] = { "#","COD_EQ","EQUIPO","PJ","PG","PE","PE","GA","GE","PTS" };
		clasificacion = datosLiga.tabla(liga.getCodL());
	
		DefaultTableModel model = new DefaultTableModel(clasificacion,titulos);
		tablaClasificacion = new JTable(model);
		tablaClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tablaClasificacion);
		scrollPane.setBounds(28, 103, 690, 291);
		scrollPane.setVisible(true);
		tablaClasificacion.setVisible(true);
		
		//HACER INVISIBLE LA COUMNA DE CODIGO EQUIPO
		tablaClasificacion.getColumnModel().getColumn(1).setMinWidth(0);
		tablaClasificacion.getColumnModel().getColumn(1).setMaxWidth(0);
		
		tablaClasificacion.getColumnModel().getColumn(2).setMinWidth(180);
		//tablaClasificacion.getColumnModel().getColumnCount()
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaClasificacion.getColumnCount(); i++) {
			tablaClasificacion.getColumnModel().getColumn(i).setCellRenderer(alinear);
		}
		
		
		contentPanel.add(scrollPane);
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ver equipo");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						verEquipo();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnVolver = new JButton("Retroceder");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
	}
	
	private void verEquipo() {
		
		String codE = tablaClasificacion.getModel().getValueAt(tablaClasificacion.getSelectedRow(), 1).toString();
		
		VConsultarEquipo vConsultarEquipo = new VConsultarEquipo(this, codE);
		vConsultarEquipo.setVisible(true);
		
	}
	
}
