package poo_interfaces_repositorio;

import java.util.List;

import poo_interfaces_repositorio.modelo.Cliente;
import poo_interfaces_repositorio.repositori.ClienteListRepositorio;
import poo_interfaces_repositorio.repositori.CrudRepositorio;
import poo_interfaces_repositorio.repositori.Direccion;
import poo_interfaces_repositorio.repositori.OrdenableRepositorio;
import poo_interfaces_repositorio.repositori.PaginableRepositorio;

public class EjemploRepositorio {
	public static void main(String[] args) {
		
		CrudRepositorio repo = new ClienteListRepositorio();
		
		repo.crear(new Cliente("Jano", "Perez"));
		repo.crear(new Cliente("Bea", "Gonzalez"));
		repo.crear(new Cliente("Luz", "Martinez"));
		repo.crear(new Cliente("Andres", "Guzman"));
		
		
		List<Cliente> clientes = repo.listar();
		
		clientes.forEach(System.out::println);
		System.out.println("==========paginable========");
		List<Cliente> paginable = ((PaginableRepositorio)repo).listar(2,3);
		
		paginable.forEach(System.out::println);
		
		System.out.println("==========ordenar========");
		List<Cliente> ordenable = ((OrdenableRepositorio)repo).listar("nombre",Direccion.ASC);
		
		ordenable.forEach(System.out::println);
		
		

		System.out.println("==========ordenar========");
		List<Cliente> ordenable1 = ((OrdenableRepositorio)repo).listar("id",Direccion.DESC);
		
		ordenable1.forEach(System.out::println);
		
		System.out.println("==========ordenar========");
		List<Cliente> ordenable2 = ((OrdenableRepositorio)repo).listar("apellido",Direccion.DESC);
		
		ordenable2.forEach(System.out::println);
	}
	
	public static void imprimirClientes(List<? extends Cliente> clientes) {
		clientes.forEach(System.out::println);
	}
	
	
	public static <T extends Comparable<T>> T maximo (T a, T b, T c) {
		T max = a;
		if(b.compareTo(max)> 0) {
			max = b;
		}
		if(c.compareTo(max) > 0) {
			max = c;
		}
		return max;
	}
	
}
