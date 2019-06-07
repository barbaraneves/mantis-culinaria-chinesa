package mantisrestaurante.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.service.GerenteService;

@Controller
@RequestMapping("/area-gerente")
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;
	
	//Para não precisar ir para uma página de sucesso 
		//sempre que um novo prato for cadastrado
	@RequestMapping("/cadastrar-pratos")
	public ModelAndView formularioCadastrarPratos() {
		
		ModelAndView mv = new ModelAndView("info-prato");
		
		mv.addObject("prato", new Prato());
		
		return mv;
	}
	
	@RequestMapping("/cadastrar-pratos/confirmacao")
	public ModelAndView cadastrarPratos(Prato prato) {
		
		gerenteService.cadastrar(prato);
		
		ModelAndView mv = new ModelAndView("redirect:/area-gerente/cardapio");
		
		return mv; 
	}
	
	@RequestMapping("/cardapio")
	public ModelAndView mostrarCardapio() {
		
		List<Prato> cardapio = gerenteService.mostrarCardapio();
		
		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);
		
		return mv;
	}
	
	@RequestMapping("/excluir-prato/{id}")
	public ModelAndView excluirPrato(@PathVariable Long id) {
		
		gerenteService.excluirPrato(id);
		
		ModelAndView mv = new ModelAndView("redirect:/area-gerente/cardapio");
		
		return mv; 
	}
	
	@RequestMapping("/editar-prato/{id}")
	public ModelAndView editarPrato(@PathVariable Long id) {
		
		Prato prato = gerenteService.buscarPorId(id);
		
		ModelAndView mv = new ModelAndView("info-prato");
		mv.addObject("prato", prato);
		
		return mv;
	}
}
