package ar.unrn.model;

import java.util.List;

public interface ConcursoDAO {
	void create(Concurso concurso);
	List<Concurso> findAll();
}
