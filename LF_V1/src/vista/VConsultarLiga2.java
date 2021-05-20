package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import aplicacion.Main;
import modelo.Liga;
import modelo.LigaInterface;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;

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
		lblLigaNombre.setBounds(28, 38, 117, 29);
		contentPanel.add(lblLigaNombre);
		
		textNombreL = new JTextField();
		textNombreL.setBounds(155, 38, 161, 29);
		contentPanel.add(textNombreL);
		textNombreL.setColumns(10);
		
		JLabel lblLigaPais = new JLabel("Pais");
		lblLigaPais.setBounds(361, 38, 117, 29);
		contentPanel.add(lblLigaPais);
		
		textPaisL = new JTextField();
		textPaisL.setColumns(10);
		textPaisL.setBounds(445, 38, 161, 29);
		contentPanel.add(textPaisL);
		
		String titulos[] = { "PUESTO","COD_EQ","NOMBRE EQUIPO","PJ","PG","PE","PE","GA","GE","PTS" };
		clasificacion = datosLiga.tabla(liga.getCodL());
	
		DefaultTableModel model = new DefaultTableModel(clasificacion,titulos);
		tablaClasificacion = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tablaClasificacion);
		scrollPane.setBounds(28, 103, 690, 291);
		scrollPane.setVisible(true);
		tablaClasificacion.setVisible(true);
		
		//HACER INVISIBLE LA COUMNA DE CODIGO EQUIPO
		tablaClasificacion.getColumnModel().getColumn(1).setMinWidth(0);
		tablaClasificacion.getColumnModel().getColumn(1).setMaxWidth(0);
		
		contentPanel.add(scrollPane);
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
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
}
