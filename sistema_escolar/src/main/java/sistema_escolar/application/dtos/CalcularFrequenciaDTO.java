package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalcularFrequenciaDTO {
    
    private AlunoCadastroDTO alunoCadastroDTO;
    private DisciplinaCadastroDTO disciplinaCadastroDTO;
}
