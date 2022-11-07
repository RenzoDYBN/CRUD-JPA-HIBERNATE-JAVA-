package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/muestraFormActualizar")
	public String muestraFormActualizar(@RequestParam(value = "clienteId") int id, Model modelo) {
		
		//OBTENER CLIENTE
		Cliente elCliente = clientesDAO.getClientes(id);
		
		
		modelo.addAttribute("idCliente", elCliente);
		
		return "formEditar";
	}
	
	@PostMapping("/editarInfo")
	public String editarInfo(@ModelAttribute("cliente") Cliente elCliente, Model modelo) {
		
		clientesDAO.editarClie(elCliente);
		
		return "redirect:/cliente/listar";
	}
	
	
	@GetMapping("/eliminarInfo")
	public String eliminarInfo(@RequestParam(value = "clienteId") int id, Model modelo) {
		
		//OBTENER CLIENTE
		clientesDAO.eliminarClie(id);
				
		return "redirect:/cliente/listar";
	}
	
	
	
	@Autowired
	private ClienteDAO clientesDAO;
	
	
}
