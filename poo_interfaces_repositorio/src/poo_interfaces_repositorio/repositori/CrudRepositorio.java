package poo_interfaces_repositorio.repositori;

import java.util.List;

import poo_interfaces_repositorio.modelo.Cliente;

public interface CrudRepositorio {
	
	List<Cliente> listar();
	
	Cliente porId(Integer id);
	
	void crear(Cliente cliente);
	
	void editar(Cliente cliente);
	
	void eliminar(Integer id);
}
