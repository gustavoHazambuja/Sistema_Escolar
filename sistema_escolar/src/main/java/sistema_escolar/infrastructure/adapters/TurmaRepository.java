package sistema_escolar.infrastructure.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import sistema_escolar.domain.contracts.TurmaContract;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.RegistrarAluno;
import sistema_escolar.domain.entites.Turma;
import sistema_escolar.infrastructure.repositories.AlunoJPARep;
import sistema_escolar.infrastructure.repositories.TurmaJPARep;

@Repository
public class TurmaRepository implements TurmaContract {
    
    @Autowired
    private TurmaJPARep turmaJPARep;

    @Autowired
    private AlunoJPARep alunoJPARep;

    @Override
    public boolean turmaValida(int numero){
        return turmaJPARep.existsByNumero(numero);
    }

    @Override
    public boolean cadastrarTurma(Turma turma){
        if(turma == null){
            return false;
        }
        
        return turmaJPARep.save(turma) != null;
    }

    @Override
    public boolean deletarTurmaPorNumero(int numero){

        Optional<Turma> turma = turmaJPARep.findById(numero);

        if(turma.isEmpty()){
            return false;
        }

        turmaJPARep.delete(turma.get());
        return true;
    }

    @Override
    public Page<Turma> listarTurmas(Pageable pageable){
        return turmaJPARep.findAll(pageable);
    }

    @Override
    public Optional<Turma> buscarTurmaPorNumero(int numero){
        return turmaJPARep.findByNumero(numero);
    }

    @Override
    public boolean registrarAlunoNaTurma(RegistrarAluno registrarAluno){
        
        Optional<Aluno> alunoOpt = alunoJPARep.findById(registrarAluno.getIdAluno());
        Optional<Turma> turmaOpt = turmaJPARep.findByNumero(registrarAluno.getNumeroTurma());

        if(alunoOpt.isEmpty() || turmaOpt.isEmpty()){
            return false;
        }

       Aluno aluno = alunoOpt.get();
       Turma turma = turmaOpt.get();
       
       aluno.setTurma(turma);
       alunoJPARep.save(aluno);

       return true;
    }
}
