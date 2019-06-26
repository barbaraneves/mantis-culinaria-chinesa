package mantisrestaurante.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mantisrestaurante.com.br.model.Pedido;
import mantisrestaurante.com.br.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void cadastrarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido buscarPorId(Long id) {
		return pedidoRepository.getOne(id);
	}
	
	public void updatePedido(Long id, Long idCliente, String status) {
		Pedido p = pedidoRepository.getOne(id);
		p.setIdCliente(idCliente);
		p.setStatus(status);
		
		pedidoRepository.save(p);	
	}
}
