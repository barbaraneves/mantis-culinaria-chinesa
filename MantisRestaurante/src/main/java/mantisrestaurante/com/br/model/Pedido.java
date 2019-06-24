package mantisrestaurante.com.br.model;

public class Pedido {
	
	private Long id;
	private String nomePrato;
	private Double precoUnit;
	private Double precoTotal;
	private int qtd;
	private String comentario;
	
	public Pedido(Long id, String nomePrato, Double precoUnit, Double precoTotal, int qtd) {
		this.id = id;
		this.nomePrato = nomePrato;
		this.precoUnit = precoUnit;
		this.precoTotal = precoTotal;
		this.qtd = qtd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public Double getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(Double precoUnit) {
		this.precoUnit = precoUnit;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}
	
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}