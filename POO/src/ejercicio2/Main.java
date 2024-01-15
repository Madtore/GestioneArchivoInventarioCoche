package ejercicio2;

import java.io.IOException;

/*2.- Clase para Simulación de un Reloj

Contexto y Requerimientos:

Se busca desarrollar un programa para simular el funcionamiento de un reloj. Los aspectos a tener en cuenta son:

· Configuración de Hora: El reloj debe permitir establecer la hora actual.

· Visualización de Hora: Debe ser posible visualizar la hora que marca el reloj en cualquier momento.

· Gestión de Alarmas: El reloj debe ser capaz de configurar y activar alarmas.

Tarea:

Crear una clase en Java que simule el comportamiento de un reloj. 
Esta clase debe incluir funcionalidades para ajustar la hora, mostrar la hora y manejar alarmas. 
Considerar qué atributos son necesarios para representar el estado del reloj y qué métodos se requieren para las operaciones mencionadas.
*/



public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		Reloj reloj = new Reloj();
		
		
		while(true) {
			reloj.addOneSecond();
			System.out.println(reloj.toString());
			Thread.sleep(1000);
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		
	}

}
