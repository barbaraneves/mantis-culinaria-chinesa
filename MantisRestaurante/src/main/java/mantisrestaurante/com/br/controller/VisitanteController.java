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
	public String paginaSobre() {

		return "sobre";
	}

	@RequestMapping("/contato")
	public String paginaContato() {

		return "contato";
	}

	@RequestMapping("/home")
	public String paginaHome() {

		return "home";
	}

	@RequestMapping("/entrar")
	public String paginaLogin() {

		return "entrar";
	}
}
