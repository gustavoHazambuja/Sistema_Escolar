package sistema_escolar.domain.contracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Avaliacao;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.entites.Frequencia;
import sistema_escolar.domain.entites.NotaAvaliacao;
import sistema_escolar.domain.entites.Professor;

public interface ProfessorContract {

    boolean professorValido(int id);
    boolean cadastrarProfessor(Professor professor);
    boolean deletarProfessorPorId(int id);
    Page<Professor> listarProfessores(Pageable pageable);
    Optional<Professor> buscarProfessorPorNome(String nome);
    Optional<Professor> buscarProfessorPorId(int id);
    double lancarNota(Aluno aluno, Avaliacao avaliacao);
    boolean criarAvaliacao(Avaliacao avaliacao);
    double consultarFrequencia(Aluno aluno, Disciplina disciplina);

    List<Frequencia> obterFrequenciasDoAluno(Aluno aluno, Disciplina disciplina);
    List<NotaAvaliacao> obterNotasDoAluno(Aluno aluno);
    
} 