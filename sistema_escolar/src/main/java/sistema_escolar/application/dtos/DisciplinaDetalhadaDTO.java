package sistema_escolar.application.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Disciplina;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDetalhadaDTO {
    
    private int codigo;
    private String nome;
    private int totalAulas;
    private ProfessorResumoDTO professorResumoDTO;

    private List<AvaliacaoResumoDTO> avaliacoes = new ArrayList<>();
    private List<FrequenciaResumidaDTO> frequencias = new ArrayList<>();



    public static DisciplinaDetalhadaDTO fromModel(Disciplina disciplina){
        return new DisciplinaDetalhadaDTO(
            disciplina.getCodigo(),
            disciplina.getNome(),
            disciplina.getTotalAulas(),
            ProfessorResumoDTO.fromModel(disciplina.getProfessor()),

            disciplina.getAvaliacoes().stream()
                .map(AvaliacaoResumoDTO::fromModel)
                .toList(),

            disciplina.getFrequencias().stream()
                .map(FrequenciaResumidaDTO::frmoModel)
                .toList()    
         );
    }
}
