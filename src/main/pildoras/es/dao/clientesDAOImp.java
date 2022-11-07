package pildoras.es.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pildoras.es.controlador.entity.Cliente;

@Repository
public class clientesDAOImp implements ClienteDAO{

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		
		Session miSession = sessionfact.getCurrentSession();
		
		Query<Cliente> miCliente = miSession.createQuery("FROM Cliente", Cliente.class);
		
		List<Cliente> clientes = miCliente.getResultList();
		
		return clientes;
	}
	
	@Override
	@Transactional
	public void agregarClie(Cliente elCliente) {
		
		Session miSession = sessionfact.getCurrentSession();
		
		miSession.persist(elCliente);

	}

	@Autowired
	private SessionFactory sessionfact;
}
