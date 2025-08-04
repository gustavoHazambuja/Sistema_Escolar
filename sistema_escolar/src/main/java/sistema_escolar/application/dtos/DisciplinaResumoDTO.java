package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Disciplina;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaResumoDTO{

    private int codigo;
    private String nome;
    private int totalAulas;

    public static DisciplinaResumoDTO fromModel(Disciplina disciplina){
        return new DisciplinaResumoDTO(
            disciplina.getCodigo(),
            disciplina.getNome(),
            disciplina.getTotalAulas()
        );
    }
}
