package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorForm {
    private String firstName;
    private String lastName;
    private String specialty;
}
