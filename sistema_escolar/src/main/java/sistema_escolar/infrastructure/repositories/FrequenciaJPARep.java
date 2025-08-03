package sistema_escolar.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.entites.Frequencia;

public interface FrequenciaJPARep extends JpaRepository<Frequencia,Integer>{
    
    List<Frequencia> findByAlunoAndDisciplina(Aluno aluno, Disciplina disciplina);
}
