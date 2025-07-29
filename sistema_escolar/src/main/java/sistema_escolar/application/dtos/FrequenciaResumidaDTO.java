package sistema_escolar.application.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_escolar.domain.entites.Frequencia;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FrequenciaResumidaDTO {
    
    private int id;
    private LocalDate data = LocalDate.now();
    private boolean presente;

    
    public static FrequenciaResumidaDTO frmoModel(Frequencia frequencia){
        return new FrequenciaResumidaDTO(
            frequencia.getId(),
            frequencia.getData(),
            frequencia.isPresente()
        );
    }
}
