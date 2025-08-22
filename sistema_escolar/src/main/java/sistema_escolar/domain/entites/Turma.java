package sistema_escolar.domain.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    public Turma(int numero, int capacidade, int tamanho){
        this.numero = numero;
        this.capacidade = capacidade;
        this.tamanho = tamanho;
    }

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();
}
