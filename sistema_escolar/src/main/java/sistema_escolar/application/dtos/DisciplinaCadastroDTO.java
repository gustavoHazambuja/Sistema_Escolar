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
public class DisciplinaCadastroDTO {
    
    private int codigo;
    private String nome;
    private int totalAulas;


    public Disciplina toModel(){
        return new Disciplina(codigo, nome, totalAulas);
    }
}
