package sistema_escolar.application.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Avaliacao;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoResumoDTO {
    
    private int id;
    private LocalDate dataAvaliacao;


    public static AvaliacaoResumoDTO fromModel(Avaliacao avaliacao){
        return new AvaliacaoResumoDTO(
            avaliacao.getId(),
            avaliacao.getDataAvaliacao()
        );
    }
}
