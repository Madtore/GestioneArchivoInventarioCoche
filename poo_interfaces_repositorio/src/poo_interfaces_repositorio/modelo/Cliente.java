package poo_interfaces_repositorio.modelo;

import java.util.Objects;

public class Cliente {
	private Integer id;
	private String nombre;
	private String apellido;
	
	private static int ultimoId;
	
	public Cliente(String nombre, String apellido) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Cliente() {
		this.id=++ultimoId;
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
