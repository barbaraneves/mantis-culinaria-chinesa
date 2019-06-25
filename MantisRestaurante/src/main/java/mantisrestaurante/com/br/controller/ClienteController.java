package mantisrestaurante.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Cliente;
import mantisrestaurante.com.br.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping("/meus-dados/cadastro")
	public ModelAndView paginaCadastroCliente() {

		ModelAndView mv = new ModelAndView("meus-dados");

		return mv;
	}

	@RequestMapping("/meus-dados/usuario-cadastrado")
	public ModelAndView cadastroCliente(Cliente cliente) {

		clienteService.cadastrar(cliente);

		// Redirecionar para uma página de sucesso
		// Colocar um modal ou ir para o carrinho
		ModelAndView mv = new ModelAndView("redirect:/meus-dados/cadastro");

		return mv;
	}

	@RequestMapping("/meus-dados/editar/{id}")
	public ModelAndView editarDadosCliente(@PathVariable Long id) {

		Cliente cliente = clienteService.buscarPorId(id);

		ModelAndView mv = new ModelAndView("editar-dados");
		mv.addObject("cliente", cliente);

		return mv;
	}
	
	@RequestMapping("/meus-pedidos")
	public ModelAndView paginaPedidos() {

		ModelAndView mv = new ModelAndView("meus-pedidos");

		return mv;
	}
}
