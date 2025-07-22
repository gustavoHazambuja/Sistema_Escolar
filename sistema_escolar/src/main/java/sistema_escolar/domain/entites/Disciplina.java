package sistema_escolar.domain.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_disciplina")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {
    
    @Id
    private int codigo;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
