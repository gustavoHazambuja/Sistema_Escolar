package sistema_escolar.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import sistema_escolar.domain.contracts.ProfessorContract;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Avaliacao;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.entites.Frequencia;
import sistema_escolar.domain.entites.NotaAvaliacao;
import sistema_escolar.domain.entites.Professor;
import sistema_escolar.infrastructure.repositories.AvaliacaoJPARep;
import sistema_escolar.infrastructure.repositories.FrequenciaJPARep;
import sistema_escolar.infrastructure.repositories.NotaAvaliacaoJPARep;
import sistema_escolar.infrastructure.repositories.ProfessorJPARep;

@Repository
public class ProfessorRepository implements ProfessorContract{
    
    @Autowired
    private ProfessorJPARep professorJPARep;

    @Autowired
    private NotaAvaliacaoJPARep notaAvaliacaoJPARep;

    @Autowired
    private AvaliacaoJPARep avaliacaoJPARep;

    @Autowired
    private FrequenciaJPARep frequenciaJPARep;



    @Override
    public boolean professorValido(int id){
        return professorJPARep.existsById(id);
    }

    @Override
    public boolean cadastrarProfessor(Professor professor){
        if(professor == null){
            return false;
        }

        return professorJPARep.save(professor) != null;
    }

    @Override
    public boolean criarAvaliacao(Avaliacao avaliacao){
        if(avaliacao == null){
            return false;
        }

        return avaliacaoJPARep.save(avaliacao) != null;
    }

    @Override
    public boolean deletarProfessorPorId(int id){

        Optional<Professor> professor = professorJPARep.findById(id);

        if(professor.isEmpty()){
            return false;
        }

        professorJPARep.delete(professor.get());
        return true;
    }

    @Override
    public Page<Professor> listarProfessores(Pageable pageable){
        return professorJPARep.findAll(pageable);
    }

    @Override
    public Page<Professor> buscarProfessorPorNome(String nome, Pageable pageable){
        return professorJPARep.findByNomeContainingIgnoreCase(nome, pageable);
    }

    @Override
    public Optional<Professor> buscarProfessorPorId(int id){
        return professorJPARep.findById(id);
    }
    

    @Override
    public List<NotaAvaliacao> obterNotasDoAluno(Aluno aluno){
        return notaAvaliacaoJPARep.findByAluno(aluno);
    }

    @Override
    public List<Frequencia> obterFrequenciasDoAluno(Aluno aluno, Disciplina disciplina){
        return frequenciaJPARep.findByAlunoAndDisciplina(aluno, disciplina);
    }
}
