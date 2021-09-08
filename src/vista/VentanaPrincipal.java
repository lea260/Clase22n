package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private ListaClientesInternalFrame listaClientesInternalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		//hace que la ventana se vea en tamanio completo
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar");
		mntmListarClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormularioListaClientes();
			}
		});
		mnClientes.add(mntmListarClientes);
		
		JMenuItem mntmCrearCliente = new JMenuItem("Crear");
		mnClientes.add(mntmCrearCliente);
		
		JMenu mnEmpleado = new JMenu("Empleados");
		menuBar.add(mnEmpleado);
		
		JMenuItem mntmListarEmpleado = new JMenuItem("Listar");
		mnEmpleado.add(mntmListarEmpleado);
		
		JMenuItem mntmCrearEmpleado = new JMenuItem("Crear");
		mnEmpleado.add(mntmCrearEmpleado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormularioListaClientes();
			}
		});
		toolBar.add(btnListarClientes);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	
	
	public void verFormularioListaClientes() {
		// evalucaion en cirito corto de los condicional
		/*
		 * personaFormularioFrame.isClosed() va a ejecutarse si falla la primera
		 * condicion falla entonces personaFormularioFrame != null (cierto)
		 * 
		 */
		if (listaClientesInternalFrame == null || listaClientesInternalFrame.isClosed()) {
			listaClientesInternalFrame = new ListaClientesInternalFrame();
			listaClientesInternalFrame.setVisible(true);
			Dimension tfDimension = listaClientesInternalFrame.getSize();
			int anchoDP = desktopPane.getWidth();
			int anchoPersona = tfDimension.width;
			float margen = (anchoDP - anchoPersona) / 2;
			listaClientesInternalFrame.setLocation((int) margen, 0);
			desktopPane.add(listaClientesInternalFrame);
		}
	}
}
