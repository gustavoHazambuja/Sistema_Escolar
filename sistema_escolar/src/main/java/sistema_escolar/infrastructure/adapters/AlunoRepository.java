package sistema_escolar.infrastructure.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import sistema_escolar.domain.contracts.AlunoContract;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.infrastructure.repositories.AlunoJPARep;

@Repository
public class AlunoRepository implements AlunoContract {
    
    @Autowired
    private AlunoJPARep alunoJPARep;

    @Override
    public boolean alunoValido(int id){
        return alunoJPARep.existsById(id);
    }

    @Override
    public boolean cadastrarAluno(Aluno aluno){
        if(aluno == null){
            return false;
        }

        return alunoJPARep.save(aluno) != null;
    }

    @Override
    public boolean deletarAlunoPorId(int id){
        return alunoJPARep.deleteById(id);
    }

    @Override
    public Page<Aluno> listarAlunos(Pageable pageable){
        return alunoJPARep.findAll(pageable);
    }

    @Override
    public Page<Aluno> buscarAlunoPorNome(String nome, Pageable pageable){
        return alunoJPARep.findByNomeContainingIgnoreCase(nome, pageable);
    }

    @Override
    public Optional<Aluno> buscarAlunoPorId(int id){
        return alunoJPARep.findById(id);
    }

    @Override
    public void atualizarAluno(Aluno aluno){
        if(alunoValido(aluno.getId())){
            alunoJPARep.save(aluno);
        }
        
    }
}
