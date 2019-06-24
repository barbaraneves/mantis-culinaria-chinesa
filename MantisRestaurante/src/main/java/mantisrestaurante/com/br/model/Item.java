package mantisrestaurante.com.br.model;

public class Item {
	
	private Prato prato;
	private int qtd;
	private String descricao;
	
	public Item(Prato prato, int qtd, String descricao) {
		this.prato = prato;
		this.qtd = qtd;
		this.descricao = descricao;
	}

	public Prato getPrato() {
		return prato;
	}
	
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public String getDescricao() {
		return descricao;
	}	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
