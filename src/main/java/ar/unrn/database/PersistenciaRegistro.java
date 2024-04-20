package ar.unrn.database;

import ar.unrn.model.Concurso;
import ar.unrn.model.IApiRegistro;

import java.util.List;

public class PersistenciaRegistro implements IApiRegistro {

	@Override
	public void saveInscription(String nombre, String apellido, String telefono, String email, String id) {

	}

	@Override
	public List<Concurso> todosLosConcursos() {
		return null;
	}
}
