package mantisrestaurante.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.service.GerenteService;

@Controller
@RequestMapping("/area-gerente")
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;
	
	@RequestMapping("/cadastrar-pratos")
	public String formularioCadastrarPratos() {
		
		return "cadastrar-pratos";
	}
	
	@RequestMapping("/cardapio")
	public String cadastrarPratos(Prato prato) {
		
		gerenteService.cadastrar(prato);
		
		return "cardapio-gerente";
	}
}
