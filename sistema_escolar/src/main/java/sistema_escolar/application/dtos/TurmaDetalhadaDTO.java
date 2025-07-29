package sistema_escolar.application.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Turma;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDetalhadaDTO {
    
    private int numero;
    private int capacidade;
    private int tamanho;

    private List<ProfessorResumoDTO> professores = new ArrayList<>();
    private List<AlunoResumoDTO> alunos = new ArrayList<>();
    private List<DisciplinaResumoDTO> disciplinas = new ArrayList<>();



    public static TurmaDetalhadaDTO fromModel(Turma turma){
        return new TurmaDetalhadaDTO(
            turma.getNumero(),
            turma.getCapacidade(),
            turma.getTamanho(),

            turma.getProfessores().stream()
                .map(ProfessorResumoDTO::fromModel)
                .toList(),

            turma.getAlunos().stream()
                .map(AlunoResumoDTO::fromModel)
                .toList(),
                
            turma.getDisciplinas().stream()
                .map(DisciplinaResumoDTO::fromModel)
                .toList()    
            
        );
    }
}
