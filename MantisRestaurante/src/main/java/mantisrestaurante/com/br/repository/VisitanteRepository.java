package mantisrestaurante.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mantisrestaurante.com.br.model.Prato;

@Repository
public interface VisitanteRepository extends JpaRepository<Prato, Long> {

}
