package sistema_escolar.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sistema_escolar.domain.entites.Disciplina;

public interface DisciplinaJPARep extends JpaRepository<Disciplina, Integer>{
    
    boolean existsByCodigo(int codigo);
    Page<Disciplina> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Optional<Disciplina> findByCodigo(int codigo);
}
