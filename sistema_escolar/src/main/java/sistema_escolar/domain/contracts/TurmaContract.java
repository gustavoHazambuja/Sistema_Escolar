package sistema_escolar.domain.contracts;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema_escolar.domain.entites.RegistrarAluno;
import sistema_escolar.domain.entites.Turma;

public interface TurmaContract {
    
    boolean turmaValida(int numero);
    boolean cadastrarTurma(Turma turma);
    boolean deletarTurmaPorNumero(int numero);
    Page<Turma> listarTurmas(Pageable pageable);
    Optional<Turma> buscarTurmaPorNumero(int numero);
    boolean registrarAlunoNaTurma(RegistrarAluno registarAluno);
}
