package mantisrestaurante.com.br.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Cliente;
import mantisrestaurante.com.br.model.Pedido;
import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.service.ClienteService;
import mantisrestaurante.com.br.service.GerenteService;

@Controller
public class ClienteController {

	/** ÁREA PADRÃO DO CLIENTE **/

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private GerenteService gerenteService;

	private List<Pedido> carrinho = new ArrayList<Pedido>();

	@RequestMapping("/meus-dados/cadastro")
	public ModelAndView paginaCadastroCliente() {

		ModelAndView mv = new ModelAndView("meus-dados");

		return mv;
	}

	@RequestMapping("/meus-dados/usuario-cadastrado")
	public ModelAndView cadastroCliente(Cliente cliente) {

		clienteService.cadastrar(cliente);

		// Redirecionar para uma página de sucesso
		// Colocar um modal ou ir para o carrinho
		ModelAndView mv = new ModelAndView("redirect:/meus-dados/cadastro");

		return mv;
	}

	@RequestMapping("/meus-dados/editar/{id}")
	public ModelAndView editarDadosCliente(@PathVariable Long id) {

		Cliente cliente = clienteService.buscarPorId(id);

		ModelAndView mv = new ModelAndView("editar-dados");
		mv.addObject("cliente", cliente);

		return mv;
	}

	/** ÁREA DO CARRINHO **/

	@RequestMapping("/carrinho")
	public ModelAndView paginaCarrinho() {

		ModelAndView mv = new ModelAndView("carrinho");

		double subTotal = 0;
		int qtd = 0;

		for (Pedido p : carrinho) {
			subTotal += p.getPrecoTotal();
			qtd = p.getQtd();
		}
		
		if (!carrinho.isEmpty()) {
			mv.addObject("carrinho", this.carrinho);
			mv.addObject("subTotal", subTotal);
			mv.addObject("qtd", qtd);
		} else {
			return mv = new ModelAndView("redirect:/carrinho-vazio");
		}

		return mv;
	}

	@RequestMapping("/carrinho-vazio")
	public ModelAndView paginaCarrinhoVazio() {

		ModelAndView mv = new ModelAndView("/carrinho-vazio");

		return mv;
	}

	@RequestMapping("/carrinho/adicionar-prato/{id}")
	public ModelAndView adicionarPratoCarrinho(@PathVariable Long id, @RequestParam(defaultValue="1") int quantidade) {
		
		System.out.println("qtd: " + quantidade);
		
		Prato prato = gerenteService.buscarPratoPorId(id);

		Pedido pedido = new Pedido(prato.getId(), prato.getNome(), prato.getPreco(), quantidade * prato.getPreco(), quantidade);

		carrinho.add(pedido);

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		return mv;
	}

	@RequestMapping("/carrinho/excluir-prato/{id}")
	public ModelAndView excluirCarrinho(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		for (Pedido p : carrinho) {
			if (p.getId().equals(id)) {

				carrinho.remove(p);

				if (carrinho.isEmpty()) {
					return mv = new ModelAndView("redirect:/carrinho-vazio");
				} else {
					return mv = new ModelAndView("redirect:/carrinho");
				}
			}
		}
		return mv;
	}

	@RequestMapping("/carrinho/prato/aumentar-quantidade/{id}")
	public ModelAndView aumentarQtdPratoCarrinho(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		int qtd = 0;
		double precoTotal = 0;

		for (Pedido p : carrinho) {
			if (p.getId().equals(id)) {
				qtd = p.getQtd() + 1;
				precoTotal = qtd * p.getPrecoUnit();
				p.setQtd(qtd);
				p.setPrecoTotal(precoTotal);
			}	
		}

		return mv;
	}

	@RequestMapping("/carrinho/prato/diminuir-quantidade/{id}")
	public ModelAndView diminuirQtdPratoCarrinho(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView("redirect:/carrinho");

		int qtd = 0;
		double precoTotal = 0;
		
		for (Pedido p : carrinho) {
			if (p.getId().equals(id)) {
				qtd = p.getQtd() - 1;
				
				if (qtd >= 1) {
					precoTotal = qtd * p.getPrecoUnit();
					p.setQtd(qtd);
					p.setPrecoTotal(precoTotal);
				}
			}	
		}

		return mv;
	}

}
