package mantisrestaurante.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.service.GerenteService;

@Controller
@RequestMapping("/area-gerente")
public class GerenteController {
	
	/*
	 * O Controller do gerente mostra as páginas que serão visitadas 
	 * apenas pelo gerente, já que a função dele na aplicação é de 
	 * cadastrar, editar e remover pratos do cardápio. 
	 */
	
	@Autowired
	private GerenteService gerenteService;
	
	//Para não precisar ir para uma página de sucesso 
		//sempre que um novo prato for cadastrado
	@RequestMapping("/cadastrar-pratos")
	public ModelAndView paginaCadastrarPratos() {
		
		ModelAndView mv = new ModelAndView("info-prato");
		
		mv.addObject("prato", new Prato());
		
		return mv;
	}
	
	@RequestMapping("/cadastrar-pratos/confirmacao")
	public ModelAndView cadastrarPratos(Prato prato, @RequestParam(value="imagem") MultipartFile imagem) {
		
		gerenteService.cadastrarPrato(prato, imagem);
		
		ModelAndView mv = new ModelAndView("redirect:/area-gerente/cardapio");
		
		return mv; 
	}
	
	@RequestMapping("/cardapio")
	public ModelAndView paginaCardapio() {

		List<Prato> cardapio = gerenteService.tipo("Entradas");

		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/cardapio/entradas")
	public ModelAndView paginaCardapioTipoEntradas() {
		
		List<Prato> cardapio = gerenteService.tipo("Entradas");

		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/cardapio/frango")
	public ModelAndView paginaCardapioTipoFrango() {
		
		List<Prato> cardapio = gerenteService.tipo("Frango");

		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/cardapio/carne")
	public ModelAndView paginaCardapioTipoCarne() {

		List<Prato> cardapio = gerenteService.tipo("Carne");

		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/cardapio/peixes-e-camaroes")
	public ModelAndView paginaCardapioTipoPeixesECamaroes() {

		List<Prato> cardapio = gerenteService.tipo("Peixes");

		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/cardapio/macarroes-e-arroz")
	public ModelAndView paginaCardapioTipoMacarroesEArroz() {

		List<Prato> cardapio = gerenteService.tipo("Macarroes");

		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/cardapio/sopas")
	public ModelAndView paginaCardapioTipoSopas() {

		List<Prato> cardapio = gerenteService.tipo("Sopas");

		ModelAndView mv = new ModelAndView("cardapio-gerente");
		mv.addObject("cardapio", cardapio);

		return mv;
	}

	@RequestMapping("/cardapio/sobremesas")
	public ModelAndView paginaCardapioTipoSobremesas() {

		List<Prato> cardapio = gerenteService.tipo("Sobremesas");

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
		
		Prato prato = gerenteService.buscarPratoPorId(id);
		
		ModelAndView mv = new ModelAndView("info-prato");
		mv.addObject("prato", prato);
		
		return mv;
	}
}
