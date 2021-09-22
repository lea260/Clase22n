package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import entidades.ClienteEntidad;
import modelo.Empresa;
import utilidades.GestionCeldas02;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;

public class ListaClientesInternalFrame extends JInternalFrame {
	private JTable tablaCLientes;
	private ArrayList<ClienteEntidad> listaClientes;
	private JScrollPane scrollPane;
	private ModeloTabla modelo;
	private Empresa empresa;

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
		setTitle("Lista Clientes");
		setBounds(100, 100, 885, 592);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 63, 759, 303);
		getContentPane().add(scrollPane);
		
		tablaCLientes = new JTable();
		scrollPane.setViewportView(tablaCLientes);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 427, 759, 100);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregar.setBounds(29, 31, 200, 40);
		panel.add(btnAgregar);
		construirTabla();
	}
	
	private void construirTabla() {
		// llamamos
		empresa = new Empresa();
		listaClientes   = empresa.mostrarDatosClientes();
		// utiliza el metodo compareTo implementado en personaEntidad
		//listaPersonas.sort(null);
		//listaPersonas.sort(new OrdenarPersonaEdad());
		//listaPersonas.sort(new OrdenarPersonaEdadId());
		/*listaPersonas.sort((p1, p2) -> {
			int valor = 0;
			if (p1.getEdad() < p2.getEdad()) {
				valor = -1;
			} else if (p1.getEdad() > p1.getEdad()) {
				valor = 1;
			} else if (p1.getId() < p1.getId()) {
				valor = -1;
			} else if (p1.getId() > p1.getId()) {
				valor = 1;
			} else {
				valor = 0;
			}
			return valor;
		});*/
		
		//listaPersonas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
		
		ArrayList<String> titulosList = new ArrayList<>();

		titulosList.add("ID");
		titulosList.add("Nombre");
		titulosList.add("Edad");
		
		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = titulosList.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz que luego se
		 * manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos(titulosList);
		construirTabla(titulos, data);
	}

	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde a todos los
		 * usuarios, mientras que las columnas son estaticas correspondiendo a las
		 * columnas definidas por defecto
		 */
		String informacion[][] = new String[listaClientes.size()][titulosList.size()];

		for (int x = 0; x < informacion.length; x++) {
			informacion[x][Utilidades.ID] = listaClientes.get(x).getId() + "";
			informacion[x][Utilidades.NOMBRE] = listaClientes.get(x).getNombre() + "";
			informacion[x][Utilidades.EDAD] = listaClientes.get(x).getEdad() + "";			
		}
		return informacion;
	}

	private void construirTabla(String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tablaCLientes.setModel(modelo);

		// filasTabla=tablaPersonas.getRowCount();
		// columnasTabla=tablaPersonas.getColumnCount();

		// se asigna el tipo de dato que tendrán las celdas de cada columna definida
		// respectivamente para validar su personalización

		// tablaPersonas.getColumnModel().getColumn(Utilidades.ID).setCellRenderer(new
		// GestionCeldas02("texto"));
		// tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setCellRenderer(new
		// GestionCeldas02("texto"));
		for (int i = 0; i < titulos.length ; i++) {// se resta 7 porque las ultimas 7 columnas se definen arriba
			// System.out.println(i);
			tablaCLientes.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas02("texto"));
		}
		

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto

		tablaCLientes.getTableHeader().setReorderingAllowed(false);
		tablaCLientes.setRowHeight(25);// tamaño de las celdas
		tablaCLientes.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tablaCLientes.getColumnModel().getColumn(Utilidades.ID).setPreferredWidth(100);// documento
		tablaCLientes.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(200);// nombre
		tablaCLientes.getColumnModel().getColumn(Utilidades.EDAD).setPreferredWidth(200);// direccion
		

		// personaliza el encabezado
		JTableHeader jtableHeader = tablaCLientes.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tablaCLientes.setRowSelectionAllowed(true);
		
		tablaCLientes.setTableHeader(jtableHeader);

		// limitar seleccion a una fila
		tablaCLientes.setRowSelectionAllowed(true);
		tablaCLientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// se asigna la tabla al scrollPane
		
		

		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}
}
