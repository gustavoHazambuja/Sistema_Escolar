package sistema_escolar.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sistema_escolar.domain.entites.Professor;

public interface ProfessorJPARep extends JpaRepository<Professor,Integer>{
    
    boolean existsById(int id);
    boolean deleteById(int id);
    Page<Professor> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Optional<Professor> findById(int id);

}
