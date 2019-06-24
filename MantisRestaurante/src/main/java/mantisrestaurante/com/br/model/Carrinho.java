package mantisrestaurante.com.br.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Prato> carrinho;

	public Carrinho() {
		this.carrinho = new ArrayList<Prato>();
	}
	
	public List<Prato> findAll() {
		return this.carrinho;
	}
	
	public Prato find(Long id) {
		
		for (Prato prato : this.carrinho) {
			if (prato.getId().equals(id)) {
				return prato;
			}
		}
		return null;
	}
	

}
