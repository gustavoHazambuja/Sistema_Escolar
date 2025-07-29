package sistema_escolar.application.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.EstadoAvaliacao;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDetalhadoDTO {
    
    private int id;
    private String nome;
    private String email;
    private EstadoAvaliacao estadoAvaliacao;
    private TurmaResumidaDTO turmaResumidaDTO;

    private List<DisciplinaResumoDTO> disciplinas = new ArrayList<>();
    private List<ProfessorResumoDTO> professores = new ArrayList<>();
    private List<FrequenciaResumidaDTO> frequencias = new ArrayList<>();


    public static AlunoDetalhadoDTO fromModel(Aluno aluno){
        return new AlunoDetalhadoDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getEstadoAvaliacao(),
            TurmaResumidaDTO.fromModel(aluno.getTurma()),

            aluno.getDisciplinas().stream()
                .map(DisciplinaResumoDTO::fromModel)
                .toList(),

            aluno.getProfessores().stream()
                .map(ProfessorResumoDTO::fromModel)
                .toList(),
                
            aluno.getFrequencias().stream()
                .map(FrequenciaResumidaDTO::frmoModel)
                .toList()    
        );
    }
}
