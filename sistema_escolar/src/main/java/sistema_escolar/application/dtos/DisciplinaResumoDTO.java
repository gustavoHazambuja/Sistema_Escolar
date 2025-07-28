package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.entites.TipoDisciplina;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaResumoDTO{

    private int codigo;
    private TipoDisciplina tipoDisciplina;
    private int totalAulas;

    public static DisciplinaResumoDTO fromModel(Disciplina disciplina){
        return new DisciplinaResumoDTO(
            disciplina.getCodigo(),
            disciplina.getTipoDisciplina(),
            disciplina.getTotalAulas()
        );
    }
}
