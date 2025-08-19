package sistema_escolar.application.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import sistema_escolar.application.dtos.AlunoCadastroDTO;
import sistema_escolar.application.dtos.AvaliacaoCadastroDTO;
import sistema_escolar.application.dtos.CalcularFrequenciaDTO;
import sistema_escolar.application.dtos.CalcularNotaDTO;
import sistema_escolar.application.dtos.DisciplinaCadastroDTO;
import sistema_escolar.application.dtos.ProfessorCadastroDTO;
import sistema_escolar.application.dtos.ProfessorDetalhadoDTO;
import sistema_escolar.application.dtos.ProfessorResumoDTO;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Avaliacao;
import sistema_escolar.domain.entites.CalcularFrequencia;
import sistema_escolar.domain.entites.CalcularNota;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.entites.Professor;
import sistema_escolar.domain.services.ProfessorService;

@Component
public class ProfessorUC {
    
    @Autowired
    private ProfessorService professorService;

    public boolean professorValido(int id){
        return professorService.professorValido(id);
    }

    public boolean cadastrarProfessor(ProfessorCadastroDTO dto){
        Professor professor = toModel(dto);
        return professorService.cadastrarProfessor(professor);
    }

    public boolean deletarProfessorPorId(int id){
        return professorService.deletarProfessorPorId(id);
    }

    public Page<ProfessorResumoDTO> listarProfessores(Pageable pageable){
        return professorService.listarProfessores(pageable)
            .map(ProfessorResumoDTO::fromModel);
    }

    public Page<ProfessorDetalhadoDTO> buscarProfessorPorNome(String nome, Pageable pageable){
       return professorService.buscarProfessorPorNome(nome, pageable)
            .map(ProfessorDetalhadoDTO::fromModel);
    }

     public ProfessorDetalhadoDTO buscarProfessorPorId(int id){
        Professor professor = professorService.buscarProfessorPorId(id).get();
        return ProfessorDetalhadoDTO.fromModel(professor);
    }

    public double calcularNota(CalcularNotaDTO dto){

        CalcularNota model = toModel(dto);
        return professorService.calcularNota(model);
    }

    public boolean criarAvaliacao(AvaliacaoCadastroDTO dto){
        Avaliacao avaliacao = toModel(dto);
        return professorService.criarAvaliacao(avaliacao);
    }

    public double calcularFrequencia(CalcularFrequenciaDTO dto){
        CalcularFrequencia model = toModel(dto);

        return professorService.calcularFrequencia(model);
    }

    private CalcularNota toModel(CalcularNotaDTO dto){
        return new CalcularNota(
            dto.getAlunoCadastroDTO().toModel(),
            dto.getAvaliacaoCadastroDTO().toModel()
        );
    }

    private CalcularFrequencia toModel(CalcularFrequenciaDTO dto){
        return new CalcularFrequencia(
            dto.getAlunoCadastroDTO().toModel(),
            dto.getDisciplinaCadastroDTO().toModel()
        );
    }

    private Professor toModel(ProfessorCadastroDTO dto){
        return new Professor(
            dto.getId(),
            dto.getNome(),
            dto.getEmail(),
            dto.getFormacao()
        );
    }

    // private Aluno toModel(AlunoCadastroDTO dto){
    //     return new Aluno(
    //         dto.getId(),
    //         dto.getNome(),
    //         dto.getEmail()
    //     );
    // }

    private Avaliacao toModel(AvaliacaoCadastroDTO dto){
        return new Avaliacao(
            dto.getId(),
            dto.getDataAvaliacao()
        );
    }

    // private Disciplina toMdel(DisciplinaCadastroDTO dto){
    //     return new Disciplina(
    //         dto.getCodigo(),
    //         dto.getNome(),
    //         dto.getTotalAulas()
    //     );
    // }
}
