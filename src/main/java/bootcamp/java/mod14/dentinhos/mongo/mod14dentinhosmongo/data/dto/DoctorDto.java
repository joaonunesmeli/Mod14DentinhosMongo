package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private String firstName;
    private String lastName;
    private String specialty;
}
