package sistema_escolar.application.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import sistema_escolar.application.dtos.AlunoCadastroDTO;
import sistema_escolar.application.dtos.TurmaCadastroDTO;
import sistema_escolar.application.dtos.TurmaDetalhadaDTO;
import sistema_escolar.application.dtos.TurmaResumidaDTO;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Turma;
import sistema_escolar.domain.services.TurmaService;

@Component
public class TurmaUC {
    
    @Autowired
    private TurmaService turmaService;

    public boolean turmaValida(int numero){
        return turmaService.turmaValida(numero);
    }

    public boolean cadastrarTurma(TurmaCadastroDTO dto){
        Turma turma = toModel(dto);
        return turmaService.cadastrarTurma(turma);
    }

    public boolean deletarTurmaPorNumero(int numero){
        return turmaService.deletarTurmaPorNumero(numero);
    }

    public Page<TurmaResumidaDTO> listarTurmas(Pageable pageable){
        return turmaService.listarTurmas(pageable)
            .map(TurmaResumidaDTO::fromModel);
    }

    public TurmaDetalhadaDTO buscarTurmaPorNumero(int numero){
        Turma turma = turmaService.buscarTurmaPorNumero(numero).get();
        return TurmaDetalhadaDTO.fromModel(turma);
    }

    public boolean registarAlunoNaTurma(AlunoCadastroDTO alunoCadastroDTO, TurmaCadastroDTO turmaCadastroDTO){
        Aluno aluno = toModel(alunoCadastroDTO);
        Turma turma = toModel(turmaCadastroDTO);

        return turmaService.registarAlunoNaTurma(aluno, turma);
    }


    private Turma toModel(TurmaCadastroDTO dto){
        return new Turma(
            dto.getNumero(),
            dto.getCapacidade(),
            dto.getTamanho()
        );
    }

    private Aluno toModel(AlunoCadastroDTO dto){
        return new Aluno(
            dto.getId(),
            dto.getNome(),
            dto.getEmail()
        );
    }
}
