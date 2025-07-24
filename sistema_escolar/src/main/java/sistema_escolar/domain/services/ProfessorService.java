package sistema_escolar.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_escolar.domain.contracts.AlunoContract;
import sistema_escolar.domain.contracts.DisciplinaContract;
import sistema_escolar.domain.contracts.ProfessorContract;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Avaliacao;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.entites.EstadoAvaliacao;
import sistema_escolar.domain.entites.Frequencia;
import sistema_escolar.domain.entites.NotaAvaliacao;
import sistema_escolar.domain.entites.Professor;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorContract professorContract;

    @Autowired
    private AlunoContract alunoContract;

    @Autowired
    private DisciplinaContract disciplinaContract;

    public boolean professorValido(int id){
        return professorContract.professorValido(id);
    }

    public boolean cadastrarProfessor(Professor professor){
        if(professorContract.professorValido(professor.getId())){
            return false;
        }

        return professorContract.cadastrarProfessor(professor);
            
    }

    public boolean deletarProfessorPorId(int id){
        if(professorContract.professorValido(id)){
            return false;
        }

        return professorContract.deletarProfessorPorId(id);
    }

    public Page<Professor> listarProfessores(Pageable pageable){
        return professorContract.listarProfessores(pageable);
    }

    public Optional<Professor> buscarProfessorPorNome(String nome){
        return professorContract.buscarProfessorPorNome(nome);
    }

    public Optional<Professor> buscarProfessorPorId(int id){
        return professorContract.buscarProfessorPorId(id);
    }

    public double lancarNota(Aluno aluno, Avaliacao avaliacao){
        if(!alunoContract.alunoValido(aluno.getId())){
            return 0.0;
        }

        calcularMedia(aluno);
        
        return professorContract.lancarNota(aluno, avaliacao);
    }

    private double calcularMedia(Aluno aluno){
        List<NotaAvaliacao> notas = professorContract.obterNotasDoAluno(aluno);

        if(notas.isEmpty()) return 0.0;

        double soma = notas.stream()
            .mapToDouble(NotaAvaliacao::getNota)
            .sum();

        double media =  soma / notas.size();

        if(media >= 7.0){
            aluno.setEstadoAvaliacao(EstadoAvaliacao.APROVADO);
        }else if(media >=4.0 && media <=6.9){
            aluno.setEstadoAvaliacao(EstadoAvaliacao.EM_RECUPERACAO);
        }else{
            aluno.setEstadoAvaliacao(EstadoAvaliacao.REPROVADO);
        }

        return media;
     
    }

    public boolean criarAvaliacao(Avaliacao avaliacao){
        return professorContract.criarAvaliacao(avaliacao);
    }

    public double consultarFrequencia(Aluno aluno,Disciplina disciplina){
        if(!alunoContract.alunoValido(aluno.getId()) || !disciplinaContract.disciplinaValida(disciplina.getCodigo())){
            return 0.0;
        }

        List<Frequencia> presencas = professorContract.obterFrequenciasDoAluno(aluno, disciplina);

        int totalAulas = disciplina.getTotalAulas();
        if(totalAulas == 0) return 0.0;

        long diasPresentes = presencas.stream()
            .filter(Frequencia::isPresente)
            .count();

        return (diasPresentes / (double) totalAulas) * 100;

    }
}

