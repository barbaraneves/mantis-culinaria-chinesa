package mantisrestaurante.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Cliente;
import mantisrestaurante.com.br.service.ClienteService;

@RequestMapping("/meus-dados")
@Controller
public class ClienteController {

	/*
	 * O Controller do cliente mostra as páginas que serão visitadas apenas pelo
	 * cliente, já que ele possui funções diferentes na aplicação, como se
	 * cadastrar, fazer pedido, confirmar pedido e fazer log out.
	 */
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/cadastro")
	public ModelAndView paginaCadastroCliente() {

		ModelAndView mv = new ModelAndView("meus-dados");
		
		return mv;
	}
	
	@RequestMapping("/usuario-cadastrado")
	public ModelAndView cadastroCliente(Cliente cliente) {
		
		clienteService.cadastrar(cliente);
		
		//Redirecionar para uma página de sucesso
		//Colocar um modal ou ir para o carrinho
		ModelAndView mv = new ModelAndView("redirect:/meus-dados/cadastro");
		
		return mv; 
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editarDadosCliente(@PathVariable Long id) {
		
		Cliente cliente = clienteService.buscarPorId(id);
		
		ModelAndView mv = new ModelAndView("editar-dados");
		mv.addObject("cliente", cliente);
		
		return mv;
	}
}
