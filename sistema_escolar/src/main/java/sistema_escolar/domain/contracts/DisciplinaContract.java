package sistema_escolar.domain.contracts;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_escolar.domain.entites.Disciplina;

public interface DisciplinaContract {
    
    boolean disciplinaValida(int codigo);
    boolean cadastrarDisciplina(Disciplina disciplina);
    boolean deletarDisciplinaPorCodigo(int codigo);
    Page<Disciplina> listarDisciplinas(Pageable pageable);
    Optional<Disciplina> buscarDisciplinaPorNome(String nome);
    Optional<Disciplina> buscarDisciplinaPorCodigo(int codigo);
}
