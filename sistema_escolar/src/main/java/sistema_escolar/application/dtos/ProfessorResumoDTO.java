package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Professor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResumoDTO{

    private int id;
    private String nome;
    private String email;
    private String formacao;


    public static ProfessorResumoDTO fromModel(Professor professor){
        return new ProfessorResumoDTO(
            professor.getId(),
            professor.getNome(),
            professor.getEmail(),
            professor.getFormacao()
        );
    }
}
