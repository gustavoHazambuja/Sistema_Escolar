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

import sistema_escolar.application.dtos.DisciplinaCadastroDTO;
import sistema_escolar.application.dtos.DisciplinaDetalhadaDTO;
import sistema_escolar.application.dtos.DisciplinaResumoDTO;
import sistema_escolar.application.usercases.DisciplinaUC;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaController {
    
    @Autowired
    DisciplinaUC disciplinaUC;

    @GetMapping(value = "/validaDisciplina/{codigo}")
    public boolean disciplinaValida(@PathVariable int codigo){
        return disciplinaUC.disciplinaValida(codigo);
    }

    @PostMapping(value = "cadastroDisciplina")
    public ResponseEntity<?> cadastrarDisciplina(@RequestBody DisciplinaCadastroDTO dto){
        boolean resposta = disciplinaUC.cadastrarDisciplina(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem", "Disciplina cadastrada com sucesso;"));
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro: código da disciplina já existente"));
        }
    }

    @DeleteMapping(value = "/deletarDisciplina/{codigo}")
    public boolean deletarDisciplinaPorCodigo(@PathVariable int codigo){
        return disciplinaUC.deletarDisciplinaPorCodigo(codigo);
    }

    @GetMapping(value = "/listarDisciplinas")
    public ResponseEntity<Page<DisciplinaResumoDTO>> listarDisciplinas(Pageable pageable){

        Page<DisciplinaResumoDTO> result = disciplinaUC.listarDisciplinas(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/buscarDisciplinaPorNome/{nome}")
    public ResponseEntity<Page<DisciplinaDetalhadaDTO>> buscarDisciplinaPorNome(@PathVariable String nome, Pageable pageable){

        Page<DisciplinaDetalhadaDTO> result = disciplinaUC.buscarDisciplinaPorNome(nome, pageable);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @GetMapping(value = "/buscarDisciplinaPorCodigo/{codigo}")
    public ResponseEntity<DisciplinaDetalhadaDTO> buscarDisciplinaPorId(@PathVariable int codigo){

        DisciplinaDetalhadaDTO result = disciplinaUC.buscarDisciplinaPorCodigo(codigo);

        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }
}
