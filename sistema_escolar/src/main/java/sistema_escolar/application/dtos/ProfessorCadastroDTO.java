package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorCadastroDTO {
    
    private int id;
    private String nome;
    private String email;
    private String formacao;
}
