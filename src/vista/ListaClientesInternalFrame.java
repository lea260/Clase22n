package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ListaClientesInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaClientesInternalFrame frame = new ListaClientesInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaClientesInternalFrame() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Lista Persona");
		setBounds(100, 100, 873, 443);
		getContentPane().setLayout(null);

	}

}
