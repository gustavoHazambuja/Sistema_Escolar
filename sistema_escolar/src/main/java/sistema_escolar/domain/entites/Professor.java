package sistema_escolar.domain.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    
    @Id
    private int id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String formacao;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Turma> turmas = new ArrayList<>();
}
