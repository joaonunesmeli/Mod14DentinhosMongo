package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto;

import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private String id;
    private LocalDate date;
    private Appointment.Status status;
    private PatientDto patient;
    private DoctorDto doctor;
}
