package sistema_escolar.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema_escolar.domain.entites.Avaliacao;

public interface AvaliacaoJPARep extends JpaRepository<Avaliacao, Integer>{
    
}
