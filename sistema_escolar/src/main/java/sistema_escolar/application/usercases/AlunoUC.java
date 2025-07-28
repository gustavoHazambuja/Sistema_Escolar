package sistema_escolar.application.usercases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_escolar.application.dtos.AlunoCadastroDTO;
import sistema_escolar.application.dtos.AlunoResumoDTO;
import sistema_escolar.domain.entites.Aluno;
import sistema_escolar.domain.services.AlunoService;

public class AlunoUC {
    
    @Autowired
    private AlunoService alunoService;

    
    public boolean alunoValido(int id){
        return alunoService.alunoValido(id);
    }

    public boolean cadastrarAluno(AlunoCadastroDTO dto){
        Aluno aluno = toModel(dto);
        return alunoService.cadastrarAluno(aluno);
    }

    public boolean deletarAlunoPorId(int id){
        return alunoService.deletarAlunoPorId(id);
    }

    public Page<AlunoResumoDTO> listarAlunos(Pageable pageable){

        return alunoService.listarAlunos(pageable)
            .map(AlunoResumoDTO::fromModel);
    }

    public AlunoResumoDTO buscarAlunoPorNome(String nome){
        Aluno aluno = alunoService.buscarAlunoPorNome(nome).get();
        return AlunoResumoDTO.fromModel(aluno);
    }

    public AlunoResumoDTO buscarAlunoPorId(int id){
        Aluno aluno = alunoService.buscarAlunoPorId(id).get();
        return AlunoResumoDTO.fromModel(aluno);
    }



    private Aluno toModel(AlunoCadastroDTO dto){
        return new Aluno(
            dto.getId(),
            dto.getNome(),
            dto.getEmail()
         );
    }
}
