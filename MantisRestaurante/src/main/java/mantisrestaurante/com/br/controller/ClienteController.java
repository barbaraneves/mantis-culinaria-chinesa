package mantisrestaurante.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Cliente;
import mantisrestaurante.com.br.service.ClienteService;

@Controller
public class ClienteController {

	/*
	 * O Controller do cliente mostra as páginas que serão visitadas apenas pelo
	 * cliente, já que ele possui funções diferentes na aplicação, como se
	 * cadastrar, fazer pedido, confirmar pedido e fazer log out.
	 */

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/entrar/meus-dados")
	public ModelAndView paginaCadastroCliente() {

		ModelAndView mv = new ModelAndView("meus-dados");
		
		return mv;
	}
	
	@RequestMapping("/entrar/meus-dados/usuario-cadastrado")
	public ModelAndView cadastroCliente(Cliente cliente) {
		
		clienteService.cadastrar(cliente);
		
		//Redirecionar para uma página de sucesso
		//Colocar um modal ou ir para o carrinho
		ModelAndView mv = new ModelAndView("redirect:/entrar/meus-dados");
		
		return mv; 
	}
	
	//Edita os dados do cliente
}
