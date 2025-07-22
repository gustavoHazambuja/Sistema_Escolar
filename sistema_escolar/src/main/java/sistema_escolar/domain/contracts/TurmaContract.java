package sistema_escolar.domain.contracts;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Turma;

public interface TurmaContract {
    
    boolean turmaValida(int codigo);
    boolean cadastrarTurma(Turma turma);
    boolean deletarTurma(int codigo);
    Page<Turma> listarTurmas(Pageable pageable);
    Optional<Turma> buscarTurmaPorCodigo(int codigo);
    boolean registrarAlunoNaTurma(Aluno aluno, Turma turma);
}
