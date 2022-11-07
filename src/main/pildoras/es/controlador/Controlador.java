package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@RequestMapping("/listar")
	public String listarClientes(Model modelo) {
		
		List<Cliente> listClii = clientesDAO.getClientes();
		
		modelo.addAttribute("clientes",listClii);
		
		return "listar-clientes";
	}
	
	@RequestMapping("/btnagregar")
	public String agregarClie(Model modelo) {
		
		Cliente addcli = new Cliente();
		
		modelo.addAttribute("cliente", addcli);
		
		return "formAgregar";
	}
	
	@PostMapping("/procesarInfo")
	public String procesarInfo(@ModelAttribute("cliente") Cliente elCliente, Model modelo) {
		
		clientesDAO.agregarClie(elCliente);
		
		return "redirect:/cliente/listar";
	}
	
	
	@Autowired
	private ClienteDAO clientesDAO;
	
	
}
