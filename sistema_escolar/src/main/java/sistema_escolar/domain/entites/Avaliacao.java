package sistema_escolar.domain.entites;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_avaliacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {
    
    @Id
    private int id;

    private LocalDate dataAvaliacao;

    public Avaliacao(int id, LocalDate dataAvaliacao){
        this.id = id;
        this.dataAvaliacao = dataAvaliacao;
    }

    @ManyToOne
    @JoinColumn(name = "codigo_disciplina")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipoAvaliacao;
}
