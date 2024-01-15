package lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import lambda.models.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Consumer<String> consumer = System.out::print;
		
		consumer.accept("Hola mundo");
		
		
		List<String> nombres = Arrays.asList("Andres", "Pepe");
		
		nombres.forEach(System.out::println);
		
		Usuario usuario = new Usuario();
		
		BiConsumer<Usuario, String> asignarNombre = (persona, nombre) -> {
			persona.setNombre(nombre);
		};
		

		BiConsumer<Usuario, String> asignarNombreSimple = Usuario::setNombre;
		
		
		asignarNombre.accept(usuario, "Salvatore");
		asignarNombreSimple.accept(usuario, "Salvatore");
		
		Function<String, String> funo = param -> "Hola que tal"+ param;
		
		String resultado = funo.apply("Salvatore");
		
		BiFunction<String, String, String> f3 = (a,b)-> a.concat(b.toUpperCase());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca el texto");
		String texto = sc.nextLine();
		
		Function<String, String> whiteSpaceDelete= texto_ -> {
			return texto_.replace(" ","");
			};
			
		System.out.println(whiteSpaceDelete.apply(texto));	
		
		
		String frase = "Ciquero de gatos, todos son gatos";
		
		Function<String, String[]> palabraRepetida = frases -> {
			return frases.replace(",","").split(" ");
		};
		
		for(String e:palabraRepetida.apply(frase)) {
			System.out.println(e.toString());
		}
	}

}
