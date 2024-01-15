package poo_interfaces_repositorio.repositori;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import poo_interfaces_repositorio.modelo.Cliente;

public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio, PaginableRepositorio {

	private List<Cliente> dataSource;

	public ClienteListRepositorio() {
		this.dataSource = new ArrayList<Cliente>();
	}

	@Override
	public List<Cliente> listar() {
		return dataSource;
	}

	@Override
	public Cliente porId(Integer id) {
		Cliente cliente = listar().stream().filter((e) -> e.getId() == id).findFirst().get();
		return cliente;
	}

	@Override
	public void crear(Cliente cliente) {
		this.dataSource.add(cliente);

	}

	@Override
	public void editar(Cliente cliente) {
		Cliente c = this.porId(cliente.getId());
		c.setApellido(cliente.getApellido());
		c.setNombre(cliente.getNombre());
	}

	@Override
	public void eliminar(Integer id) {
		this.dataSource.remove(this.porId(id));
	}

	@Override
	public List<Cliente> listar(int desde, int hasta) {
		return dataSource.subList(desde, hasta);
	}

	@Override
	public List<Cliente> listar(String campo, Direccion dir) {
		
		List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
		listaOrdenada.sort(( o1,o2)-> {
						int resultado = 0;
						if (dir == Direccion.ASC) {
							resultado=this.ordenar(o1, o2 , campo);
						} else if (dir == Direccion.DESC) {
							resultado=this.ordenar(o2, o1 , campo);
							}
						
							return resultado;
					 });
		
		
		return listaOrdenada;
	}
	
	private int ordenar(Cliente o1, Cliente o2, String campo) {
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
