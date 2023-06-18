package hr.tvz.spring.crnjak1.domain;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    private String jmbag;
    @NonNull
    private Integer numberOfECTS;

    public Student(Long id, @NonNull String firstName, @NonNull String lastName, @NonNull LocalDate dateOfBirth, @NonNull String jmbag, @NonNull Integer numberOfECTS) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
    }

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> courses;

}
