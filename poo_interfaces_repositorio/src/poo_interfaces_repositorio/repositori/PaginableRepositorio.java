package poo_interfaces_repositorio.repositori;

import java.util.List;

import poo_interfaces_repositorio.modelo.Cliente;

public interface PaginableRepositorio {
	
	List<Cliente> listar(int desde, int hasta);

}
