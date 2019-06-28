package mantisrestaurante.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Pessoa;
import mantisrestaurante.com.br.service.PessoaService;

@Controller
@RequestMapping("/meus-dados")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping("/cadastro")
	public ModelAndView paginaCadastroCliente() {

		ModelAndView mv = new ModelAndView("meus-dados");

		return mv;
	}

	@RequestMapping("/usuario-cadastrado")
	public ModelAndView cadastroCliente(Pessoa pessoa) {

		pessoaService.cadastrarPessoa(pessoa);

		ModelAndView mv = new ModelAndView("redirect:/cardapio");

		return mv;
	}

	@RequestMapping("/editar/{id}")
	public ModelAndView editarDadosCliente(@PathVariable Long id) {

		Pessoa pessoa = pessoaService.buscarPessoaPorId(id);

		ModelAndView mv = new ModelAndView("editar-dados");
		mv.addObject("pessoa", pessoa);

		return mv;
	}
	
	public ModelAndView buscarClientePorEmail(@PathVariable String email) {
	
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
				
		Pessoa pessoa = pessoaService.buscarPessoaPorEmail(user.getUsername());
		
		ModelAndView mv = new ModelAndView("editar-dados");
		mv.addObject("pessoa", pessoa);

		return mv;

	}
}
