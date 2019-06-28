package mantisrestaurante.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mantisrestaurante.com.br.model.Prato;
import mantisrestaurante.com.br.repository.PratoRepository;
import mantisrestaurante.com.br.util.MantisFileUtils;

@Service
public class PratoService {
	
	@Autowired
	private PratoRepository pratoRepository;
	
	//Salvando um prato no BD
	public void cadastrarPrato(Prato prato, MultipartFile imagem) {
		
		String caminho = "imagens/" + prato.getNome() + ".png";
		MantisFileUtils.salvarImagem(caminho, imagem);
		
		pratoRepository.save(prato);
	}

	//Retorna todos os pratos presentes no BD
	public List<Prato> mostrarCardapio() {
		return pratoRepository.findAll();
	}
	
	//Mostrar os pratos a partir dos tipos
	public List<Prato> tipo(String tipo) {
		return pratoRepository.findByTipo(tipo);
	}
	
	//Exclui um prato do BD
	public void excluirPrato(Long id) {
		pratoRepository.deleteById(id);
	}

	public Prato buscarPratoPorId(Long id) {
		return pratoRepository.getOne(id);
	}

}
