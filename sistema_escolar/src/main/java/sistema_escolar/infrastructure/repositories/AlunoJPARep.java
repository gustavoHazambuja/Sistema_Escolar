package sistema_escolar.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sistema_escolar.domain.entites.Aluno;

public interface AlunoJPARep extends JpaRepository<Aluno, Integer> {
    
    boolean existsById(int id);
    boolean deleteById(int id);
    Page<Aluno> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Optional<Aluno> findById(int id);
}
