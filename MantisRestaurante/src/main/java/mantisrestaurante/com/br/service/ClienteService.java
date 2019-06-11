package mantisrestaurante.com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mantisrestaurante.com.br.model.Cliente;
import mantisrestaurante.com.br.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	//Salvando um cliente no BD
	public void cadastrar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.getOne(id);
	}
}
