package sistema_escolar.domain.entites;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "tb_turma")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    
    @Id
    private int numero;

    private int capacidade;
    private int tamanho;

    @ManyToMany(mappedBy = "turmas")
    private List<Professor> professores = new ArrayList<>();

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas = new ArrayList<>();

    @OneToMany(mappedBy = "turma", fetch = FetchType.LAZY)
    private List<Frequencia> frequencias = new ArrayList<>();
}
