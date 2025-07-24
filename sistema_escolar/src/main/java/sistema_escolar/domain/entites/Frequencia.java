package sistema_escolar.domain.entites;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_frequencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Frequencia {
    
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "codigo_disciplina")
    private Disciplina disciplina;

    private LocalDate data = LocalDate.now();

    private boolean presente;
}
