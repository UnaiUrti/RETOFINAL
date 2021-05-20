package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VConsultarEquipo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the dialog.
	 */
	public VConsultarEquipo() {
		setBounds(100, 100, 600, 439);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre = new JTextField();
		textNombre.setColumns(10);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(80)
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGap(43)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(119)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, GroupLayout.PREFERRED_SIZE))
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

}
