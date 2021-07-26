package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto;

import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private String firstName;
    private String lastName;
    private Patient.Gender gender;
    private double age;
}
