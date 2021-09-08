package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;

public class ListaClientesInternalFrame extends JInternalFrame {
	private JTable table;

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
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Lista Persona");
		setBounds(100, 100, 873, 800);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 63, 759, 400);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 509, 759, 100);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("TeamViewer15", Font.PLAIN, 15));
		btnAgregar.setBounds(29, 31, 200, 40);
		panel.add(btnAgregar);

	}
}
