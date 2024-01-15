package poo_interfaces_repositorio.repositori;

import java.util.List;

import poo_interfaces_repositorio.modelo.Cliente;

public interface OrdenableRepositorio {
	
	List<Cliente> listar(String campo, Direccion dir);
	
	public static int ordenar(Cliente o1, Cliente o2, String campo) {
		int resultado = 0;
		switch (campo) {
		case "id": {
			resultado = o1.getId().compareTo(o2.getId());
		}
			break;
		case "nombre": {
			resultado = o1.getNombre().compareTo(o2.getNombre());
		}
			break;
		case "apellido": {
			resultado = o1.getApellido().compareTo(o2.getApellido());
		}
			break;
		}
		return resultado;
	}
	
	
}
