package sistema_escolar.domain.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalcularFrequencia {
    
    private Aluno aluno;
    private Disciplina disciplina;

    public CalcularFrequencia(Aluno aluno, Disciplina disciplina){
        this.aluno = aluno;
        this.disciplina = disciplina;
    }
}
