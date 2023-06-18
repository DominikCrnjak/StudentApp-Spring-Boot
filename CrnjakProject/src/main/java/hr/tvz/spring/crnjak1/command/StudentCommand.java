package hr.tvz.spring.crnjak1.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class StudentCommand {

    @NotBlank(message = "First name must not be empty")
    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "username must be of 6 to 12 length with no special characters")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "username must be of 6 to 12 length with no special characters")
    private String lastName;

    @NotBlank(message = "JMBAG must not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "JMBAG must be numbers and max 10 in size")
    private String jmbag;

    @JsonFormat(pattern = "dd.MM.yyyy.")
    @NotNull(message = "Date of birth must be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer")
    @Max(message = "Number of ECTS can not be higher than 180", value = 180)
    private Integer numberOfECTS;

}
