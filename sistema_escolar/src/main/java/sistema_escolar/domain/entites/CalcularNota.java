package sistema_escolar.domain.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalcularNota {
    
    private Aluno aluno;
    private Avaliacao avaliacao;


    public CalcularNota(Aluno aluno, Avaliacao avaliacao){
        this.aluno = aluno;
        this.avaliacao = avaliacao;
    }
}
