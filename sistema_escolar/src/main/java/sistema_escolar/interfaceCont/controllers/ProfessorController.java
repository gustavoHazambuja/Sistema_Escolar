package sistema_escolar.interfaceCont.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema_escolar.application.dtos.AlunoCadastroDTO;
import sistema_escolar.application.dtos.AvaliacaoCadastroDTO;
import sistema_escolar.application.dtos.CalcularNotaDTO;
import sistema_escolar.application.dtos.DisciplinaCadastroDTO;
import sistema_escolar.application.dtos.ProfessorCadastroDTO;
import sistema_escolar.application.dtos.ProfessorDetalhadoDTO;
import sistema_escolar.application.dtos.ProfessorResumoDTO;
import sistema_escolar.application.usercases.ProfessorUC;

@RequestMapping
@RestController(value = "/professores")
public class ProfessorController {
    
    @Autowired
    private ProfessorUC professorUC;

    @GetMapping(value = "validaProfessor/{id}")
    public boolean professorValido(@PathVariable int id){
        return professorUC.professorValido(id);
    }

    @PostMapping(value = "/cadastroProfessor")
    public ResponseEntity<?> cadastrarProfessor(@RequestBody ProfessorCadastroDTO dto){
        boolean resposta = professorUC.cadastrarProfessor(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.FOUND)
                .body(Map.of("resposta:", resposta, "mensagem: ", "Professor cadastrado com sucesso."));
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro: id da turma já existente"));
        }
    }

    @DeleteMapping(value = "/deletarProfessor/{id}")
    public boolean deletarProfessorPorId(@PathVariable int id){
        return professorUC.deletarProfessorPorId(id);
    }

    @GetMapping(value = "/listarProfessores")
    public ResponseEntity<Page<ProfessorResumoDTO>> listarProfessores(Pageable pageable){

        Page<ProfessorResumoDTO> result = professorUC.listarProfessores(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/buscarProfessorPorNome/{nome}")
    public ResponseEntity<Page<ProfessorDetalhadoDTO>> buscarProfessorPorNome(@PathVariable String nome, Pageable pageable){

        Page<ProfessorDetalhadoDTO> result = professorUC.buscarProfessorPorNome(nome, pageable);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @GetMapping(value = "/buscarProfessorPorId{id}")
    public ResponseEntity<ProfessorDetalhadoDTO> buscarProfessorPorId(@PathVariable int id){

        ProfessorDetalhadoDTO resutl = professorUC.buscarProfessorPorId(id);

        return new ResponseEntity<>(resutl,HttpStatus.FOUND);
    }

    @PostMapping("/calcularNota")
    public double calcularNota(@RequestBody CalcularNotaDTO notaDTO){
        return professorUC.calcularNota(notaDTO);
    }

    @PostMapping("/criarAvaliacao")
    public boolean criarAvaliiacao(@RequestBody AvaliacaoCadastroDTO avaliacaoCadastroDTO){
        return professorUC.criarAvaliacao(avaliacaoCadastroDTO);
    }

    @GetMapping("/consultarFrequencia")
    public double calcularFrequencia(@RequestBody AlunoCadastroDTO alunoDTO, @RequestBody DisciplinaCadastroDTO disciplinaDTO){
        return professorUC.calcularFrequencia(alunoDTO, disciplinaDTO);
    }
}
