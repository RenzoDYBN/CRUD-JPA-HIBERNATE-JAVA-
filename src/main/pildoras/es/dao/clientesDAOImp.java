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

	@Override
	@Transactional
	public void editarClie(Cliente elCliente) {
		
		Session miSession = sessionfact.getCurrentSession();
		
		miSession.update(elCliente);

	}
	
	@Override
	@Transactional
	public Cliente getClientes(int id) {
		//OBTENER LA SESION
		Session miSession = sessionfact.getCurrentSession();
		
		//OBTENER LA INFO DEL CLIENTE
		Cliente obtCli = miSession.get(Cliente.class, id);
		
		return obtCli;
	}


	@Override
	@Transactional
	public void eliminarClie(int id) {
		
		//OBTENER LA SESION
				Session miSession = sessionfact.getCurrentSession();
				
				//ELIMINAR LA INFO DEL CLIENTE
				miSession.delete(miSession.get(Cliente.class, id));
				
				//Query consulta = miSession.createQuery("delete from Cliente where id=:IdDelCliente");
				
				//consulta.setParameter("IdDelCliente", id);
				
				//consulta.executeUpdate();
	}

	
	@Autowired
	private SessionFactory sessionfact;






	//MODELATTRIBUTE NO ESTA RELACIONADO CON @ModelAttribute ojo manito

}
