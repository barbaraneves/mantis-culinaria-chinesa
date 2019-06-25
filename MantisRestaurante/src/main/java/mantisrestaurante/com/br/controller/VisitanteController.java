package mantisrestaurante.com.br.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Item;
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

	private List<Item> carrinho = new ArrayList<Item>();

	/** ÁREA GERAL DO VISITANTE **/

	@RequestMapping("/cardapio")
	public ModelAndView paginaCardapio() {

		List<Prato> cardapio = visitanteService.tipo("Entradas");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/cardapio/{tipo}")
	public ModelAndView paginaCardapioTipoEntradas() {
		
		List<Prato> cardapio = visitanteService.tipo("Entradas");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/cardapio/frango")
	public ModelAndView paginaCardapioTipoFrango() {

		List<Prato> cardapio = visitanteService.tipo("Frango");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/cardapio/carne")
	public ModelAndView paginaCardapioTipoCarne() {

		List<Prato> cardapio = visitanteService.tipo("Carne");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/cardapio/peixes-e-camaroes")
	public ModelAndView paginaCardapioTipoPeixesECamaroes() {

		List<Prato> cardapio = visitanteService.tipo("Peixes");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/cardapio/macarroes-e-arroz")
	public ModelAndView paginaCardapioTipoMacarroesEArroz() {

		List<Prato> cardapio = visitanteService.tipo("Macarroes");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/cardapio/sopas")
	public ModelAndView paginaCardapioTipoSopas() {

		List<Prato> cardapio = visitanteService.tipo("Sopas");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/cardapio/sobremesas")
	public ModelAndView paginaCardapioTipoSobremesas() {

		List<Prato> cardapio = visitanteService.tipo("Sobremesas");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("cardapio");
		mv.addObject("cardapio", cardapio);
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	// Fazer essa parte se der tempo
	/*
	 * @RequestMapping("/cardapio/pesquisar") public ModelAndView
	 * pesquisarCardapio() {
	 * 
	 * List<Prato> cardapio = visitanteService.tipo("Sobremesas");
	 * 
	 * ModelAndView mv = new ModelAndView("cardapio"); mv.addObject("cardapio",
	 * cardapio);
	 * 
	 * return mv; }
	 */

	@RequestMapping("/sobre")
	public ModelAndView paginaSobre() {

		ModelAndView mv = new ModelAndView("sobre");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/contato")
	public ModelAndView paginaContato() {

		ModelAndView mv = new ModelAndView("contato");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView paginaHome() {

		ModelAndView mv = new ModelAndView("home");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/entrar")
	public ModelAndView paginaLogin() {

		ModelAndView mv = new ModelAndView("entrar");

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	/** ÁREA DO CARRINHO **/

	@RequestMapping("/carrinho")
	public ModelAndView paginaCarrinho() {

		ModelAndView mv = new ModelAndView("carrinho");

		double subTotal = 0;
		int qtdItens = 0;

		for (Item item : carrinho) {
			subTotal += item.getPrecoTotal();
			qtdItens += item.getQtd();
		}

		if (!carrinho.isEmpty()) {
			mv.addObject("carrinho", this.carrinho);
			mv.addObject("subTotal", subTotal);
			mv.addObject("qtdItens", qtdItens);
		} else {
			return mv = new ModelAndView("redirect:/carrinho/vazio");
		}

		return mv;
	}

	@RequestMapping("/carrinho/vazio")
	public ModelAndView paginaCarrinhoVazio() {

		int qtdItens = 0;

		for (Item item : carrinho) {
			qtdItens += item.getQtd();
		}

		ModelAndView mv = new ModelAndView("carrinho-vazio");
		mv.addObject("qtdItens", qtdItens);

		return mv;
	}

	@RequestMapping("/carrinho/adicionar-prato/{id}")
	public ModelAndView adicionarPratoCarrinho(@PathVariable Long id) {

		Prato prato = visitanteService.buscarPratoPorId(id);

		Item item = new Item(prato.getId(), prato.getNome(), prato.getPreco(), 1 * prato.getPreco(), 1, null);

		int index = this.exists(id);

		if (index == -1) {
			carrinho.add(item);
		} else {
			int qtd = carrinho.get(index).getQtd() + 1;
			carrinho.get(index).setQtd(qtd);
		}

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		return mv;
	}

	@RequestMapping("/carrinho/remover-prato/{id}")
	public ModelAndView exluirPratoCarrinho(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		int index = this.exists(id);

		if (index > -1) {
			carrinho.remove(index);

			if (carrinho.isEmpty()) {
				return mv = new ModelAndView("redirect:/carrinho/vazio");
			} else {
				return mv = new ModelAndView("redirect:/carrinho");
			}
		}

		return mv;
	}

	@RequestMapping("/carrinho/prato/aumentar-quantidade/{id}")
	public ModelAndView aumentarQtdPratoCarrinho(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		int qtd = 0;
		double precoTotal = 0;

		for (Item item : carrinho) {
			if (item.getId().equals(id)) {
				qtd = item.getQtd() + 1;
				precoTotal = qtd * item.getPrecoUnit();

				item.setQtd(qtd);
				item.setPrecoTotal(precoTotal);
			}
		}

		return mv;
	}

	@RequestMapping("/carrinho/prato/diminuir-quantidade/{id}")
	public ModelAndView diminuirQtdPratoCarrinho(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		int qtd = 0;
		double precoTotal = 0;

		for (Item item : carrinho) {
			if (item.getId().equals(id)) {
				qtd = item.getQtd() - 1;

				if (qtd >= 1) {
					precoTotal = qtd * item.getPrecoUnit();
					item.setQtd(qtd);
					item.setPrecoTotal(precoTotal);
				}
			}
		}

		return mv;
	}

	// Fazer essa parte se der tempo
	/*
	 * @RequestMapping("/prato/adicionar-comentario/{coment}") public ModelAndView
	 * adicionarComentarioPratoCarrinho(@PathVariable String coment, @RequestParam
	 * Long id) {
	 * 
	 * ModelAndView mv = new ModelAndView("redirect:/carrinho/index");
	 * 
	 * for (Item item : carrinho) { if (item.getId().equals(id)) { if
	 * (item.getComentario() == null) { item.setComentario(coment); } } }
	 * 
	 * return mv; }
	 */

	private int exists(Long id) {

		for (int i = 0; i < this.carrinho.size(); i++) {
			if (carrinho.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

}
