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
public class AvaliacaoCadastroDTO{

    private int id;
    private LocalDate dataAvaliacao;

    public static AvaliacaoCadastroDTO fromModel(Avaliacao avaliacao){
        return new AvaliacaoCadastroDTO(
            avaliacao.getId(),
            avaliacao.getDataAvaliacao()
        );
    }
}
