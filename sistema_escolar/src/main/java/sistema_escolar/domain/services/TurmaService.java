package sistema_escolar.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_escolar.domain.contracts.AlunoContract;
import sistema_escolar.domain.contracts.TurmaContract;
import sistema_escolar.domain.entites.RegistrarAluno;
import sistema_escolar.domain.entites.Turma;

@Service
public class TurmaService {
    
    @Autowired
    private TurmaContract turmaContract;

    @Autowired
    private AlunoContract alunoContract;

    public boolean turmaValida(int numero){
        return turmaContract.turmaValida(numero);
    }

    public boolean cadastrarTurma(Turma turma){
        if(turmaContract.turmaValida(turma.getNumero())){
            return false;
        }

        return turmaContract.cadastrarTurma(turma);
    }

    public boolean deletarTurmaPorNumero(int numero){
        if(!turmaContract.turmaValida(numero)){
            return false;
        }

        return turmaContract.deletarTurmaPorNumero(numero);
    }

    public Page<Turma> listarTurmas(Pageable pageable){
        return turmaContract.listarTurmas(pageable);
    }

    public Optional<Turma> buscarTurmaPorNumero(int numero){
        return turmaContract.buscarTurmaPorNumero(numero);
    }

    public boolean registarAlunoNaTurma(RegistrarAluno registrarAluno){
       if(!turmaContract.turmaValida(registrarAluno.getNumeroTurma()) || !alunoContract.alunoValido(registrarAluno.getIdAluno())){
        return false;
       }

        Optional<Turma> turmaOpt = turmaContract.buscarTurmaPorNumero(registrarAluno.getNumeroTurma());
        
        if(turmaOpt.isEmpty()){
            return false;
        }

        Turma turma = turmaOpt.get();

        if(turma.getTamanho() >= turma.getCapacidade()){ // Turma cheia
            return false;
        }

        turma.setTamanho(turma.getTamanho() + 1);
        return turmaContract.registrarAlunoNaTurma(registrarAluno);

        
    }
}
