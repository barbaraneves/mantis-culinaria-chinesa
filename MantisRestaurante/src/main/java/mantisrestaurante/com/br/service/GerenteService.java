package mantisrestaurante.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.repository.GerenteRepository;

@Service
public class GerenteService {
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	//Salvando um prato no BD
	public void cadastrar(Prato prato) {
		gerenteRepository.save(prato);
	}

	//Retorna todos os pratos presentes no BD
	public List<Prato> mostrarCardapio() {
		return gerenteRepository.findAll();
	}

	//Exclui um prato do BD
	public void excluirPrato(Long id) {
		
		gerenteRepository.deleteById(id);
	}

	public Prato buscarPorId(Long id) {
		return gerenteRepository.getOne(id);
	}

}
