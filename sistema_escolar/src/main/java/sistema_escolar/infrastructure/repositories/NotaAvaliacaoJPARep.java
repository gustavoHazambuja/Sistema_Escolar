package sistema_escolar.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.NotaAvaliacao;

public interface NotaAvaliacaoJPARep extends JpaRepository<NotaAvaliacao, Integer> {
    
    List<NotaAvaliacao> findByAluno(Aluno aluno);
}
