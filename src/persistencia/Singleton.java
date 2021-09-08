package persistencia;

import java.util.ArrayList;

import entidades.PersonaEntidad;
import modelo.Persona;

public class Singleton {
	private ArrayList<PersonaEntidad> listaPersonas;
	private static Singleton instancia = null;

	private Singleton() {
	}

	public static Singleton getInstancia() {
		if (instancia == null) {
			instancia = new Singleton();
			instancia.listaPersonas = new ArrayList<PersonaEntidad>();
			PersonaEntidad persona01 = new PersonaEntidad(15, "Juan", 25);
			PersonaEntidad persona02 = new PersonaEntidad(1, "Pedro", 27);
			PersonaEntidad persona03 = new PersonaEntidad(24, "Susana", 20);
			PersonaEntidad persona04 = new PersonaEntidad(3, "Maria", 45);
			PersonaEntidad persona05 = new PersonaEntidad(9, "Rossana", 18);
			PersonaEntidad persona06 = new PersonaEntidad(45, "Erick", 52);
			PersonaEntidad persona07 = new PersonaEntidad(4, "Maria", 45);
			PersonaEntidad persona08 = new PersonaEntidad(99, "Rossana", 18);
			PersonaEntidad persona09 = new PersonaEntidad(42, "Erick 02", 52);
			instancia.listaPersonas.add(persona01);
			instancia.listaPersonas.add(persona02);
			instancia.listaPersonas.add(persona03);
			instancia.listaPersonas.add(persona04);
			instancia.listaPersonas.add(persona05);
			instancia.listaPersonas.add(persona06);
			instancia.listaPersonas.add(persona07);
			instancia.listaPersonas.add(persona08);
			instancia.listaPersonas.add(persona09);
		}
		return instancia;
	}

	public ArrayList<PersonaEntidad> listarPersonas() {
		return listaPersonas;
	}
}
