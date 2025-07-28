package sistema_escolar.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.EstadoAvaliacao;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO{

    private int id;
    private String nome;
    private String email;
    private EstadoAvaliacao estadoAvaliacao;
}
