package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private String firstName;
    private String lastName;
    private Gender gender;
    private double age;

    public enum Gender {
        FEMALE {
            @Override
            public String toString() {
                return "Female";
            }
        },

        MALE {
            @Override
            public String toString() {
                return "Male";
            }
        }
    }
}
