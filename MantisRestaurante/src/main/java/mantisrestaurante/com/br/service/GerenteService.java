package mantisrestaurante.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.repository.GerenteRepository;
import mantisrestaurante.com.br.util.MantisFileUtils;

@Service
public class GerenteService {
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	//Salvando um prato no BD
	public void cadastrarPrato(Prato prato, MultipartFile imagem) {
		
		String caminho = "imagens/" + prato.getNome() + ".png";
		MantisFileUtils.salvarImagem(caminho, imagem);
		
		gerenteRepository.save(prato);
	}

	//Retorna todos os pratos presentes no BD
	public List<Prato> mostrarCardapio() {
		return gerenteRepository.findAll();
	}
	
	//Mostrar os pratos a partir dos tipos
	public List<Prato> tipo(String tipo) {
		return gerenteRepository.findByTipo(tipo);
	}
	
	//Exclui um prato do BD
	public void excluirPrato(Long id) {
		gerenteRepository.deleteById(id);
	}

	public Prato buscarPratoPorId(Long id) {
		return gerenteRepository.getOne(id);
	}

}
