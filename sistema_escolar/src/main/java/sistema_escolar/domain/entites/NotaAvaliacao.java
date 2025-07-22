package sistema_escolar.domain.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_nota_avaliacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaAvaliacao {
    
    @Id
    private int id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Avaliacao avaliacao;

    private double nota;
}
