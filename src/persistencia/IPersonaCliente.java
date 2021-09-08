package persistencia;

import java.util.ArrayList;

import entidades.ClienteEntidad;


public interface IPersonaCliente {
	ArrayList<ClienteEntidad> obternerListaClientes();

	int agregarCliente();

	boolean eliminarCliente();

	int modificarCliente();
}
