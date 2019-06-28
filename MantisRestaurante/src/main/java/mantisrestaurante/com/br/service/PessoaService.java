package mantisrestaurante.com.br.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mantisrestaurante.com.br.model.Pessoa;
import mantisrestaurante.com.br.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	//Salvando uma pessoa no BD
	public void cadastrarPessoa(Pessoa pessoa) {
		
		//Encriptografando a senha da pessoa
		pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));
		
		pessoaRepository.save(pessoa);
	}

	public Pessoa buscarPessoaPorId(Long id) {
		return pessoaRepository.getOne(id);
	}
	
	public Pessoa buscarPessoaPorEmail(String email) {
		return pessoaRepository.findByEmail(email);
	}
	
	public List<Pessoa> mostrarPessoas() {
		return pessoaRepository.findAll();
	}
}
