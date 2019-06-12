package mantisrestaurante.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.service.VisitanteService;

@Controller
public class VisitanteController {

	/*
	 * O Controller do visitante mostra as páginas que serão visitadas tanto pelo
	 * usuário visitante como pelo usuário cliente. 
	 */

	@Autowired
	private VisitanteService visitanteService;

	@RequestMapping("/cardapio")
	public ModelAndView paginaCardapio() {

		List<Prato> cardapio = visitanteService.mostrarCardapio();

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/sobre")
	public ModelAndView paginaSobre() {

		ModelAndView mv = new ModelAndView("sobre");

		return mv;
	}

	@RequestMapping("/contato")
	public ModelAndView paginaContato() {

		ModelAndView mv = new ModelAndView("contato");

		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView paginaHome() {

		ModelAndView mv = new ModelAndView("home");

		return mv;
	}

	@RequestMapping("/entrar")
	public ModelAndView paginaLogin() {

		ModelAndView mv = new ModelAndView("entrar");

		return mv;
	}
	
	@RequestMapping("/carrinho")
	public ModelAndView paginaCarrinho() {

		ModelAndView mv = new ModelAndView("carrinho");

		return mv;
	}
}
