package mantisrestaurante.com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.repository.GerenteRepository;

@Service
public class GerenteService {
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	//Cadastrando um prato no banco
	public void cadastrar(Prato prato) {
		gerenteRepository.save(prato);
	}

}
