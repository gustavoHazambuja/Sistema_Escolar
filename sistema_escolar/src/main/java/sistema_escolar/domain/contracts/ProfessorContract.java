package sistema_escolar.domain.contracts;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Avaliacao;
import sistema_escolar.domain.entites.Professor;
import sistema_escolar.domain.entites.Turma;

public interface ProfessorContract {

    boolean professorValido(int id);
    boolean cadastrarProfessor(Professor professor);
    boolean deletarProfessor(int id);
    Page<Professor> listarProfessores(Pageable pageable);
    Optional<Professor> buscarProfessorPorNome(String nome);
    Optional<Professor> buscarProfessorPorId(int id);
    double lancarNota(Aluno aluno, Avaliacao avaliacao, double nota);
    boolean criarAvaliacao(Avaliacao avaliacao,LocalDate data);
    double consultarFrequencia(Aluno aluno, Turma turma);
    
} 