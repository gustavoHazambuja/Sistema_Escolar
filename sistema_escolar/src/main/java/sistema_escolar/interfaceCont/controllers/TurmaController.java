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
import sistema_escolar.application.dtos.RegistrarAlunoDTO;
import sistema_escolar.application.dtos.TurmaCadastroDTO;
import sistema_escolar.application.dtos.TurmaDetalhadaDTO;
import sistema_escolar.application.dtos.TurmaResumidaDTO;
import sistema_escolar.application.usercases.TurmaUC;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
    

    @Autowired
    private TurmaUC turmaUC;

    @GetMapping(value = "/validaTurma/{numero}")
    public boolean turmaValida(@PathVariable int numero){
        return turmaUC.turmaValida(numero);
    }

    @PostMapping(value = "/cadastroTurma")
    public ResponseEntity<?> cadastrarTurma(@RequestBody TurmaCadastroDTO dto){
        boolean resposta = turmaUC.cadastrarTurma(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Turma cadastrada com sucesso."));
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro: númeor da turma já existente."));
        }
    }

    @DeleteMapping(value = "/deletarTurma/{numero}")
    public boolean deletarTurmaPorNumero(@PathVariable int numero){
        return turmaUC.deletarTurmaPorNumero(numero);
    }


    @GetMapping(value = "/listarTurmas")
    public ResponseEntity<Page<TurmaResumidaDTO>> listarTurmas(Pageable pageable){

        Page<TurmaResumidaDTO> result = turmaUC.listarTurmas(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTurmaPorNumero/{numero}")
    public ResponseEntity<TurmaDetalhadaDTO> buscarTurmaPorNumero(@PathVariable int numero){

        TurmaDetalhadaDTO result = turmaUC.buscarTurmaPorNumero(numero);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @PostMapping(value = "/registrarAlunoNaTurma")
    public boolean registarAlunoNaTurma(@RequestBody RegistrarAlunoDTO registrarAlunoDTO){
        return turmaUC.registarAlunoNaTurma(registrarAlunoDTO);
    }
}
