package sistema_escolar.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_escolar.domain.contracts.DisciplinaContract;
import sistema_escolar.domain.entites.Disciplina;

@Service
public class DisciplinaService {
    
    @Autowired
    private DisciplinaContract disciplinaContract;

    public boolean disciplinaValida(int codigo){
        return disciplinaContract.disciplinaValida(codigo);
    }

    public boolean cadastrarDisciplina(Disciplina disciplina){
        if(disciplinaContract.disciplinaValida(disciplina.getCodigo())){
            return false;
        }

        return disciplinaContract.cadastrarDisciplina(disciplina);
    }

    public boolean deletarDisciplinaPorCodigo(int codigo){
        if(!disciplinaContract.disciplinaValida(codigo)){
            return false;
        }

        return disciplinaContract.deletarDisciplinaPorCodigo(codigo);
    }

    public Page<Disciplina> listarDisciplinas(Pageable pageable){
        return disciplinaContract.listarDisciplinas(pageable);
    }

    public Page<Disciplina> buscarDisciplinaPorNome(String nome, Pageable pageable){
        return disciplinaContract.buscarDisciplinaPorNome(nome, pageable);
    }

    public Optional<Disciplina> buscarDisciplinaPorCodigo(int codigo){
        return disciplinaContract.buscarDisciplinaPorCodigo(codigo);
    }
}
