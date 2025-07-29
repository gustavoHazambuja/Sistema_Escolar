package sistema_escolar.application.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_escolar.application.dtos.DisciplinaCadastroDTO;
import sistema_escolar.application.dtos.DisciplinaDetalhadaDTO;
import sistema_escolar.application.dtos.DisciplinaResumoDTO;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.services.DisciplinaService;

public class DisciplinaUC {
    
    @Autowired
    private DisciplinaService disciplinaService;

    public boolean disciplinaValida(int codigo){
        return disciplinaService.disciplinaValida(codigo);
    }

    public boolean cadastrarDisciplina(DisciplinaCadastroDTO dto){
        Disciplina disciplina = toModel(dto);
        return disciplinaService.cadastrarDisciplina(disciplina);
    }

    public boolean deletarDisciplinaPorCodigo(int codigo){
        return disciplinaService.deletarDisciplinaPorCodigo(codigo);
    }

    public Page<DisciplinaResumoDTO> listarDisciplinas(Pageable pageable){
        return disciplinaService.listarDisciplinas(pageable)
            .map(DisciplinaResumoDTO::fromModel);
    }

    public DisciplinaDetalhadaDTO buscarDisciplinaPorNome(String nome){
        Disciplina disciplina = disciplinaService.buscarDisciplinaPorNome(nome).get();
        return DisciplinaDetalhadaDTO.fromModel(disciplina);
    }

    public DisciplinaDetalhadaDTO buscarDisciplinaPorCodigo(int codigo){
        Disciplina disciplina = disciplinaService.buscarDisciplinaPorCodigo(codigo).get();
        return DisciplinaDetalhadaDTO.fromModel(disciplina);
    }



    private Disciplina toModel(DisciplinaCadastroDTO dto){
        return new Disciplina(
            dto.getCodigo(),
            dto.getTipoDisciplina(),
            dto.getTotalAulas()
        );
    }

}

