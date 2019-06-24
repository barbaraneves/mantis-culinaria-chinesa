package mantisrestaurante.com.br.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mantisrestaurante.com.br.model.Carrinho;
import mantisrestaurante.com.br.model.Item;

@Controller
//@RequestMapping("/carrinho")
public class CarrinhoController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView paginaCarrinho() {
		
		ModelAndView mv = new ModelAndView("carrinho");
		
		return mv;
	}
	
	@RequestMapping("/vazio")
	public ModelAndView paginaCarrinhoVazio() {
		
		ModelAndView mv = new ModelAndView("carrinho-vazio");
		
		return mv;
	}
	
	@RequestMapping("/adicionar-prato/{id}")
	public ModelAndView adicionarPratoCarrinho(@PathVariable Long id) {
		
		
	}
	
	@RequestMapping("/excluir-prato/{id}")
	public ModelAndView exluirPratoCarrinho(@PathVariable("id") Long id, HttpSession session) {
		
		
	}


	private int exists(Long id, List<Item> cart) {
		
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getPrato().getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
}
