package persistencia;

import java.util.ArrayList;

import entidades.ClienteEntidad;
import entidades.PersonaEntidad;

public interface IPersonaCliente {
	ArrayList<ClienteEntidad> obternerListaClientes();

	int agregarCliente();

	boolean eliminarCliente();
}
