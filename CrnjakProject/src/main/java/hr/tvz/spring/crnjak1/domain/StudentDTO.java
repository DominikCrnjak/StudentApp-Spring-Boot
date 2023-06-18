package hr.tvz.spring.crnjak1.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
public class StudentDTO {
    private String jmbag;
    private Integer numberOfECTS;
    private boolean tuition;



}
