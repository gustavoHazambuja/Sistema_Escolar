package sistema_escolar.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema_escolar.domain.entites.Turma;

public interface TurmaJPARep extends JpaRepository<Turma, Integer> {
    
    boolean existsByNumero(int numero);
    Optional<Turma> findByNumero(int numero);
}
