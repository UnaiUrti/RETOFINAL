package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class pruebaVPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public pruebaVPrincipal() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRUEBA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(0,0,200,200);
		add(lblNewLabel);

	}

}
