package lecturafichero.ejercicio1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestoraArchivo {

	public void copiarArchivo() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese la ruta del archivo multimedia origen:");
		String origenPath = null;
		String destinoPath = null;

		try {
			origenPath = br.readLine();
			System.out.println("Ingrese la ruta del archivo multimedia destino:");
			destinoPath = br.readLine();
		} catch (IOException e) {
			System.out.println("Error al leer la entrada del usuario: " + e.getMessage());
			return;
		}

		File origenFile = new File(origenPath);
		File destinoFile = new File(destinoPath);

		if (destinoFile.exists()) {
			System.out.println("El archivo destino ya existe. ¿Desea sobrescribirlo? (s/n)");

			try {
				String respuesta = br.readLine();
				if (!respuesta.equalsIgnoreCase("s")) {
					System.out.println("Operación cancelada por el usuario.");
					return;
				}
			} catch (IOException e) {
				System.out.println("Error al leer la entrada del usuario: " + e.getMessage());
				return;
			}
		}

		try (FileInputStream fis = new FileInputStream(origenFile);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(destinoFile);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {

			System.out.println("Iniciando copia segura...");

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}

			System.out.println("Copia segura completada.");

		} catch (IOException e) {
			System.out.println("Error al cerrar los streams: " + e.getMessage());
		}
	}
}
