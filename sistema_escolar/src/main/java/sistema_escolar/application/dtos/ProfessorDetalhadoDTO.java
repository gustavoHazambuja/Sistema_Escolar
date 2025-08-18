package sistema_escolar.application.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Professor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDetalhadoDTO {
    
    private int id;
    private String nome;
    private String email;
    private String formacao;

    private DisciplinaResumoDTO disciplinaResumoDTO;
    private List<TurmaResumidaDTO> turmas = new ArrayList<>();


    public static ProfessorDetalhadoDTO fromModel(Professor professor){
        return new ProfessorDetalhadoDTO(
            professor.getId(),
            professor.getNome(),
            professor.getEmail(),
            professor.getFormacao(),
            
            DisciplinaResumoDTO.fromModel(professor.getDisciplina()),

            professor.getTurmas().stream()
                .map(TurmaResumidaDTO::fromModel)
                .toList()
        );
    }
}
