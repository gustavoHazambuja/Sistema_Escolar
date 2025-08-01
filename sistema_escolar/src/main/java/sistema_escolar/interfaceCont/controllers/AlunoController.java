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
import sistema_escolar.application.dtos.AlunoDetalhadoDTO;
import sistema_escolar.application.dtos.AlunoResumoDTO;
import sistema_escolar.application.usercases.AlunoUC;

@RequestMapping
@RestController(value = "/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoUC alunoUC;


    @GetMapping(value = "/validaAluno/{id}")
    public boolean alunoValido(@PathVariable int id){
        return alunoUC.alunoValido(id);
    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<?> cadastrarAluno(@RequestBody AlunoCadastroDTO dto){
        boolean resposta = alunoUC.cadastrarAluno(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Aluno cadastrado com sucesso." ));
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro: id do aluno já existente. "));
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public boolean deletarAlunoPorId(@PathVariable int id){
        return alunoUC.deletarAlunoPorId(id);
    }

    @GetMapping
   public ResponseEntity<Page<AlunoResumoDTO>> listarAlunos(Pageable pageable){

        Page<AlunoResumoDTO> result = alunoUC.listarAlunos(pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);  
   }

   @GetMapping(value = "/{nome}")
   public ResponseEntity<Page<AlunoDetalhadoDTO>> buscarAlunoPorNome(@PathVariable String nome, Pageable pageable){

        Page<AlunoDetalhadoDTO> result = alunoUC.buscarAlunoPorNome(nome, pageable);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
   }

   @GetMapping(value = "{id}")
   public ResponseEntity<AlunoDetalhadoDTO> buscarAlunoPorId(@PathVariable int id){

        AlunoDetalhadoDTO result = alunoUC.buscarAlunoPorId(id);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
   }
}
