package sistema_escolar.infrastructure.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import sistema_escolar.domain.contracts.DisciplinaContract;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.infrastructure.repositories.DisciplinaJPARep;

@Repository
public class DisciplinaRepository implements DisciplinaContract{
    
    @Autowired
    private DisciplinaJPARep disciplinaJPARep;

    @Override
    public boolean disciplinaValida(int codigo){
        return disciplinaJPARep.existsByCodigo(codigo);
    }

    @Override
    public boolean cadastrarDisciplina(Disciplina disciplina){
        if(disciplina == null){
            return false;
        }

        return disciplinaJPARep.save(disciplina) != null;
    }

    @Override
    public boolean deletarDisciplinaPorCodigo(int codigo){

        Optional<Disciplina> disciplina = disciplinaJPARep.findByCodigo(codigo);

        if(disciplina.isEmpty()){
            return false;
        }

         disciplinaJPARep.delete(disciplina.get());
         return true;

    }

    @Override
    public Page<Disciplina> listarDisciplinas(Pageable pageable){
        return disciplinaJPARep.findAll(pageable);
    }

    @Override
    public Page<Disciplina> buscarDisciplinaPorNome(String nome, Pageable pageable){
        return disciplinaJPARep.findByNomeContainingIgnoreCase(nome, pageable);
    }

    @Override
    public Optional<Disciplina> buscarDisciplinaPorCodigo(int codigo){
        return disciplinaJPARep.findByCodigo(codigo);
    }
}
