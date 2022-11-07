package pildoras.es.dao;

import java.util.List;

import pildoras.es.controlador.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getClientes();
	
	public void agregarClie(Cliente elCliente);

	public Cliente getClientes(int id);

	public void editarClie(Cliente elCliente);

	public void eliminarClie(int id);
	
	}
