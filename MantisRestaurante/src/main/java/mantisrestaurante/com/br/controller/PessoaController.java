package mantisrestaurante.com.br.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Pessoa;
import mantisrestaurante.com.br.model.Role;
import mantisrestaurante.com.br.service.PessoaService;

@Controller
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping("/cadastrar")
	public ModelAndView paginaCadastroCliente() {

		ModelAndView mv = new ModelAndView("meus-dados");

		return mv;
	}

	@RequestMapping("/cadastrar/usuario-cadastrado")
	public ModelAndView cadastroCliente(Pessoa pessoa) {

		Role roleUser = new Role();

		String papelUser = "ROLE_USER";

		roleUser.setPapel(papelUser);

		List<Role> roles = new ArrayList<Role>();

		roles.add(roleUser);

		pessoa.setRoles(roles);

		pessoaService.cadastrarPessoa(pessoa);

		ModelAndView mv = new ModelAndView("redirect:/entrar");

		return mv;
	}

	@RequestMapping("/meus-dados/editar/{id}")
	public ModelAndView editarDadosCliente(@PathVariable Long id) {

		Pessoa pessoa = pessoaService.buscarPessoaPorId(id);

		ModelAndView mv = new ModelAndView("editar-dados");
		mv.addObject("pessoa", pessoa);

		return mv;
	}
}
