package sistema_escolar.application.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FrequenciaDTO {
    
    private int id;
    private LocalDate data = LocalDate.now();
}
