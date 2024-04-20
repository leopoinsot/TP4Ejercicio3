package ar.unrn.database;
import ar.unrn.model.Concurso;
import ar.unrn.model.IApiRegistro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchivoRegistro implements IApiRegistro {
	private String pathInscripciones;
	private String pathConcursos;
	public ArchivoRegistro(String pathInscripciones, String pathConcursos){
		this.pathInscripciones = pathInscripciones;
		this.pathConcursos = pathConcursos;
		saveConcurso();
	}

	@Override
	public void saveInscription(String nombre, String apellido, String telefono, String email, String id) throws RuntimeException{
		String formatoRegistro = nombre + "," + apellido + "," + telefono + "," + email + "," + id;
		try {
			Files.write(
					Paths.get(pathInscripciones),
					formatoRegistro.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("error al escribir en el archivo de texto");
		}
	}

	@Override
	public List<Concurso> todosLosConcursos() {
		List<Concurso> concursos = new ArrayList<>();
		try {
			// Leemos todas las líneas del archivo
			List<String> lineas = Files.readAllLines(Paths.get(pathConcursos));
			// Iteramos sobre cada línea
			for (String linea : lineas) {
				// Dividimos la línea en sus componentes usando la coma como delimitador
				String[] partes = linea.split(",");

				// Creamos un objeto Concurso con la información de la línea y lo agregamos a la lista
				Concurso concurso = new Concurso(Integer.parseInt(partes[0]), partes[1], LocalDate.parse(partes[2]), LocalDate.parse(partes[3]));

				//Verificamos que el concurso aun siga vijente a inscripciones
				if(concurso.sigueVigenteFechaInscripcion()){
					concursos.add(concurso);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Error al leer el archivo de texto");
		}
		return concursos;
	}
	private void saveConcurso(){
		String concurso1 = "1" + "," + "Saltos" + "," + "2024/04/19" + "," + "2024/04/25";
		String concurso2 = "2" + "," + "Velocidad" + "," + "2024/04/18" + "," + "2024/04/24";
		String concurso3 = "3" + "," + "Inteligencia" + "," + "2024/04/17" + "," + "2024/04/22";
		String concurso4 = "4" + "," + "Resistencia" + "," + "2024/04/16" + "," + "2024/04/18";

		List<String> listadoConcurso = new ArrayList<>();

		listadoConcurso.add(concurso1);
		listadoConcurso.add(concurso2);
		listadoConcurso.add(concurso3);
		listadoConcurso.add(concurso4);

		for(String concurso : listadoConcurso){
			try {
				Files.write(
						Paths.get(pathConcursos),
						concurso.getBytes(),
						StandardOpenOption.APPEND);
			} catch (IOException e) {
				throw new RuntimeException("error al escribir en el archivo de texto");
			}
		}
	}
}