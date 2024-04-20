package ar.unrn.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
	private int id;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaCierreInscripcion;

	public Concurso(int id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaCierreInscripcion) {
		this.id = id;
		this.nombre = nombre;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaCierreInscripcion = fechaCierreInscripcion;
	}

	public boolean sigueVigenteFechaInscripcion() {
		LocalDate fechaActual = LocalDate.now();
		return (fechaActual.equals(fechaInicioInscripcion) || fechaActual.isAfter(fechaInicioInscripcion)) &&
				(fechaActual.equals(fechaCierreInscripcion) || fechaActual.isBefore(fechaCierreInscripcion));
	}

	public String obtenerId(){
		return String.valueOf(this.id);
	}
}
