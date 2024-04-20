package org.example;


import ar.unrn.database.ArchivoRegistro;
import ar.unrn.model.IApiRegistro;
import ar.unrn.ui.RegistroCiudadano;

public class Main {
	public static void main(String[] args) {
		IApiRegistro api = new ArchivoRegistro("C:\\Users\\leonr\\OneDrive\\Escritorio\\Inscriptos.txt", "C:\\Users\\leonr\\OneDrive\\Escritorio\\Concursos.txt");
		var ventanaDeRegistroDeCiudadano = new RegistroCiudadano(api);

	}

}