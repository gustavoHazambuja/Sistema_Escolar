package sistema_escolar.domain.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "tb_aluno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    
    @Id
    private int id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private EstadoAvaliacao estadoAvaliacao;

    @ManyToOne
    @JoinColumn(name = "numero_turma")
    private Turma turma;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Professor> professores = new ArrayList<>();

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<Frequencia> frequencias = new ArrayList<>();
}
