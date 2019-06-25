package mantisrestaurante.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.repository.VisitanteRepository;

@Service
public class VisitanteService {
	
	@Autowired
	private VisitanteRepository visitanteRepository;

	public List<Prato> mostrarCardapio() {
		return visitanteRepository.findAll();
	}
	
	public List<Prato> tipo(String tipo) {
		return visitanteRepository.findByTipo(tipo);
	}
	
	public Prato buscarPratoPorId(Long id) {
		return visitanteRepository.getOne(id);
	}
}
