package mantisrestaurante.com.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mantisrestaurante.com.br.model.Prato;

@Repository
public interface GeralRepository extends JpaRepository<Prato, Long> {

	List<Prato> findByTipo(String tipo);
}
