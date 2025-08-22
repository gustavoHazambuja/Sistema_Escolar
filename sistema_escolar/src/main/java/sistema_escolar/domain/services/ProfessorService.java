package sistema_escolar.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_escolar.domain.contracts.AlunoContract;
import sistema_escolar.domain.contracts.DisciplinaContract;
import sistema_escolar.domain.contracts.ProfessorContract;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.entites.Avaliacao;
import sistema_escolar.domain.entites.CalcularFrequencia;
import sistema_escolar.domain.entites.CalcularNota;
import sistema_escolar.domain.entites.Disciplina;
import sistema_escolar.domain.entites.EstadoAvaliacao;
import sistema_escolar.domain.entites.Frequencia;
import sistema_escolar.domain.entites.NotaAvaliacao;
import sistema_escolar.domain.entites.Professor;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorContract professorContract;

    @Autowired
    private AlunoContract alunoContract;

    @Autowired
    private DisciplinaContract disciplinaContract;

    public boolean professorValido(int id){
        return professorContract.professorValido(id);
    }

    public boolean cadastrarProfessor(Professor professor){
        if(professorContract.professorValido(professor.getId())){
            return false;
        }

        return professorContract.cadastrarProfessor(professor);
            
    }

    public boolean deletarProfessorPorId(int id){
        if(!professorContract.professorValido(id)){
            return false;
        }

        return professorContract.deletarProfessorPorId(id);
    }

    public Page<Professor> listarProfessores(Pageable pageable){
        return professorContract.listarProfessores(pageable);
    }

    public Page<Professor> buscarProfessorPorNome(String nome, Pageable pageable){
        return professorContract.buscarProfessorPorNome(nome, pageable);
    }

    public Optional<Professor> buscarProfessorPorId(int id){
        return professorContract.buscarProfessorPorId(id);
    }


    public double calcularNota(CalcularNota nota){
        if(!alunoContract.alunoValido(nota.getAluno().getId())){
            return 0.0;
        }

        double media =  calcularMedia(nota.getAluno());
        double frequencia = calcularPorcentagem(nota.getAluno(), nota.getAvaliacao().getDisciplina());

        nota.getAluno().setEstadoAvaliacao(definirEstadoDoALuno(media, frequencia));
        alunoContract.atualizarAluno(nota.getAluno());
        
        return media;
    }

    private double calcularMedia(Aluno aluno){
        List<NotaAvaliacao> notas = professorContract.obterNotasDoAluno(aluno);

        if(notas.isEmpty()) return 0.0;

        double soma = notas.stream()
            .mapToDouble(NotaAvaliacao::getNota)
            .sum();

        return soma / notas.size();
     
    }

    public double calcularFrequencia(CalcularFrequencia calcFrequencia){
        if(!alunoContract.alunoValido(calcFrequencia.getAluno().getId()) || !disciplinaContract.disciplinaValida(calcFrequencia.getDisciplina().getCodigo())){
            return 0.0;
        }

        double frequencia = calcularPorcentagem(calcFrequencia.getAluno(),calcFrequencia.getDisciplina());
        double nota = calcularMedia(calcFrequencia.getAluno());


        calcFrequencia.getAluno().setEstadoAvaliacao(definirEstadoDoALuno(nota, frequencia));
        alunoContract.atualizarAluno(calcFrequencia.getAluno());

        return frequencia;

    }

    private double calcularPorcentagem(Aluno aluno, Disciplina disciplina){
         List<Frequencia> presencas = professorContract.obterFrequenciasDoAluno(aluno, disciplina);

        int totalAulas = disciplina.getTotalAulas();
        if(totalAulas == 0) return 0.0;

        long diasPresentes = presencas.stream()
            .filter(Frequencia::isPresente)
            .count();

        return (diasPresentes / (double) totalAulas) * 100;
    }

    private EstadoAvaliacao definirEstadoDoALuno(double media, double frequencia){

        if(media >= 7.0 && frequencia > 75.0){
            return EstadoAvaliacao.APROVADO;
        }else if(media >= 4.0 && media <= 6.9 && frequencia > 75.0){
            return EstadoAvaliacao.EM_RECUPERACAO;
        }else if(media >= 7.0 && frequencia < 75.0){
            return EstadoAvaliacao.REPROVADO_POR_FALTA;
        }else if(media < 4.0 && frequencia > 75.0){
            return EstadoAvaliacao.REPROVADO_POR_NOTA;
        }
        else{
            return EstadoAvaliacao.RECUPERADO;
        }
    }

    public boolean criarAvaliacao(Avaliacao avaliacao){
        return professorContract.criarAvaliacao(avaliacao);
    }
}

