package mantisrestaurante.com.br.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long idCliente;
	
	private String nomePrato;
	private Double precoPrato;
	private int qtdPrato;
	
	private Double precoTotalPedido;
	
	private String estado;
	private String cidade;
	private String endereco;
	private String cep;
	private String numero;
	private String bairro;
	private String complemento;
	private String referencia;
	
	private Date dataPedido;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public Double getPrecoPrato() {
		return precoPrato;
	}

	public void setPrecoPrato(Double precoPrato) {
		this.precoPrato = precoPrato;
	}

	public int getQtdPrato() {
		return qtdPrato;
	}

	public void setQtdPrato(int qtdPrato) {
		this.qtdPrato = qtdPrato;
	}

	public Double getPrecoTotalPedido() {
		return precoTotalPedido;
	}

	public void setPrecoTotalPedido(Double precoTotalPedido) {
		this.precoTotalPedido = precoTotalPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}