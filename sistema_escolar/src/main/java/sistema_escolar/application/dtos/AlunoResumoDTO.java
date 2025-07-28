package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.EstadoAvaliacao;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResumoDTO{

    private int id;
    private String nome;
    private String email;
    private EstadoAvaliacao estadoAvaliacao;

    public static AlunoResumoDTO fromModel(Aluno aluno){
        return new AlunoResumoDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getEstadoAvaliacao()
        );
    }
}
