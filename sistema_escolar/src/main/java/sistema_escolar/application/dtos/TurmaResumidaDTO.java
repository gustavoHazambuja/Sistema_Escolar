package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Turma;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResumidaDTO{

    private int numero;
    private int capacidade;
    private int tamanho;


    public static TurmaResumidaDTO fromModel(Turma turma){
        return new TurmaResumidaDTO(
            turma.getNumero(),
            turma.getCapacidade(),
            turma.getTamanho()
        );
    }
}
