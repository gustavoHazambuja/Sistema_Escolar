package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Aluno;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoCadastroDTO {
    
    private int id;
    private String nome;
    private String email;


    public Aluno toModel(){
        return new Aluno(id, nome, email);
    }
}
