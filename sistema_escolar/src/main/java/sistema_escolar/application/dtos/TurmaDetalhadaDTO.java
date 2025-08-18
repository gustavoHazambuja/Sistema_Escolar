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


    private List<AlunoResumoDTO> alunos = new ArrayList<>();



    public static TurmaDetalhadaDTO fromModel(Turma turma){
        return new TurmaDetalhadaDTO(
            turma.getNumero(),
            turma.getCapacidade(),
            turma.getTamanho(),
            
            turma.getAlunos().stream()
                .map(AlunoResumoDTO::fromModel)
                .toList()
            
        );
    }
}
