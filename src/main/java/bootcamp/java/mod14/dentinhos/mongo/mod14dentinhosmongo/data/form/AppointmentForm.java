package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form;

import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentForm {

    @NotNull(message = "Data é um campo obrigatório")
    @Future(message = "A data deve ser de um dia futuro")
    private LocalDate date;

    @NotNull(message = "Status é um campo obrigatório")
    private Appointment.Status status;

    @Valid
    @NotNull(message = "Paciente é um campo obrigatório")
    private PatientForm patient;

    @Valid
    @NotNull(message = "Doutor é um campo obrigatório")
    private DoctorForm doctor;

}
