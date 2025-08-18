package sistema_escolar.domain.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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

    public Professor(int id, String nome, String email, String formacao){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;
    }

    @OneToOne
    @JoinColumn(name = "codigo_disicplina")
    private Disciplina disciplina;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Turma> turmas = new ArrayList<>();
}
