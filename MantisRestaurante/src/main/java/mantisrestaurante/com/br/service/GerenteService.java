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
	
	//Cadastrando um prato no banco
	public void cadastrar(Prato prato) {
		gerenteRepository.save(prato);
	}

	//Retorna todos os pratos presentes no banco
	public List<Prato> mostrarCardapio() {
		return gerenteRepository.findAll();
	}

	//Exclui um prato do banco
	public void excluirPrato(Long id) {
		
		gerenteRepository.deleteById(id);
	}

	public Prato buscarPorId(Long id) {
		return gerenteRepository.getOne(id);
	}

}
