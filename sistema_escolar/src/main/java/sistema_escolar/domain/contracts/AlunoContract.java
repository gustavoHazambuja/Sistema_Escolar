package sistema_escolar.domain.contracts;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_escolar.domain.entites.Aluno;

public interface AlunoContract {
    
    boolean alunoValido(int id);
    boolean cadastrarAluno(Aluno aluno);
    boolean deletarAlunoPorId(int id);
    Page<Aluno> listarAlunos(Pageable pageable);
    Page<Aluno> buscarAlunoPorNome(String nome, Pageable pageable);
    Optional<Aluno> buscarAlunoPorId(int id);
    

}
