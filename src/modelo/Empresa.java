package modelo;

import java.util.ArrayList;

import entidades.ClienteEntidad;
import persistencia.FakeClientePersistencia;
import persistencia.IPersonaCliente;

public class Empresa {
	public Empresa () {
		
	}
	public ArrayList<ClienteEntidad> mostrarDatosClientes(){
		IPersonaCliente rep = new FakeClientePersistencia();
		ArrayList<ClienteEntidad> lista = rep.obternerListaClientes();
		return lista;
	}
	
	

}
