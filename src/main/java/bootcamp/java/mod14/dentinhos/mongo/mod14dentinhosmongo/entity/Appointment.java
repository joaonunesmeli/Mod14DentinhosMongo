package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    private String id;

    private LocalDate date;

    private Status status;

    private Patient patient;

    private Doctor doctor;

    public Appointment(LocalDate date, Status status, Patient patient, Doctor doctor) {
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.doctor = doctor;
    }

    public enum Status {
        CANCELED,
        ACTIVE
    }

}
