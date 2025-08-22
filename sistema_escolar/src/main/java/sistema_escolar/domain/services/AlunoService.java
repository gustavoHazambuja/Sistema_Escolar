package sistema_escolar.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_escolar.domain.contracts.AlunoContract;
import sistema_escolar.domain.entites.Aluno;


@Service
public class AlunoService {
    

    @Autowired
    private AlunoContract alunoContract;

    public boolean alunoValido(int id){
        return alunoContract.alunoValido(id);
    }

    public boolean cadastrarAluno(Aluno aluno){
        if(alunoContract.alunoValido(aluno.getId())){
            return false;
        }

        return alunoContract.cadastrarAluno(aluno);
    }

    public boolean deletarAlunoPorId(int id){
        if(!alunoContract.alunoValido(id)){
            return false;
        }

        return alunoContract.deletarAlunoPorId(id);
    }

    public Page<Aluno> listarAlunos(Pageable pageable){
        return alunoContract.listarAlunos(pageable);
    }

    public Page<Aluno> buscarAlunoPorNome(String nome, Pageable pageable){
        return alunoContract.buscarAlunoPorNome(nome, pageable);
    }

    public Optional<Aluno> buscarAlunoPorId(int id){
        return alunoContract.buscarAlunoPorId(id);
    }

    public void atualizarAluno(Aluno aluno){
        if(alunoContract.alunoValido(aluno.getId())){
            alunoContract.atualizarAluno(aluno);
            
    }
}

}
