package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.TipoDisciplina;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaCadastroDTO {
    
    private int codigo;
    private TipoDisciplina tipoDisciplina;
    private int totalAulas;
}
