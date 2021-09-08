package persistencia;

import java.util.ArrayList;
import java.util.Iterator;

import entidades.ClienteEntidad;
import entidades.PersonaEntidad;
import vista.*;

public class FakeClientePersistencia implements IPersonaCliente {

	@Override
	public ArrayList<ClienteEntidad> obternerListaClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int agregarCliente() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean eliminarCliente() {
		// TODO Auto-generated method stub
		return false;
	}

	/*@Override
	public ArrayList<ClienteEntidad> obternerListaPersonas() {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<PersonaEntidad> lista = singleton.listarPersonas();
		return lista;
	}

	@Override
	public int agregarPersona() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean eliminarPersona() {
		// TODO Auto-generated method stub
		return false;
	}

	public void editarPersona(PersonaEntidad persona) {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<ClienteEntidad> lista = singleton.listarPersonas();
		Iterator<ClienteEntidad> nombreIterator = lista.iterator();
		while(nombreIterator.hasNext()){
			ClienteEntidad elemento = nombreIterator.next();
			if (elemento.getId()==persona.getId()) {
				nombreIterator.remove();
			}
		}		
		lista.add(persona);
	}*/

}
