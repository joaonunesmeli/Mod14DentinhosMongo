package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data;

import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto.DoctorDto;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto.PatientDto;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto.AppointmentDto;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.AppointmentBatchForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.DoctorForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.PatientForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.AppointmentForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Doctor;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Patient;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Appointment;

import java.util.List;
import java.util.stream.Collectors;

public final class Convert {
    private Convert() {}

    public static Doctor form(DoctorForm doc) {
        return new Doctor(doc.getFirstName(), doc.getLastName(), doc.getSpecialty());
    }

    public static DoctorDto entity(Doctor doc) {
        return new DoctorDto(doc.getFirstName(), doc.getLastName(), doc.getSpecialty());
    }

    public static Patient form(PatientForm p) {
        return new Patient(p.getFirstName(), p.getLastName(), p.getGender(), p.getAge());
    }

    public static PatientDto entity(Patient p) {
        return new PatientDto(p.getFirstName(), p.getLastName(), p.getGender(), p.getAge());
    }

    public static Appointment form(AppointmentForm turn) {
        Patient p = Convert.form(turn.getPatient());
        Doctor doc = Convert.form(turn.getDoctor());
        return new Appointment(turn.getDate(), turn.getStatus(), p, doc);
    }

    public static AppointmentDto entity(Appointment a) {
        PatientDto p = Convert.entity(a.getPatient());
        DoctorDto doc = Convert.entity(a.getDoctor());
        return new AppointmentDto(a.getId(), a.getDate(), a.getStatus(), p, doc);
    }

    public static List<AppointmentDto> entities(List<Appointment> as) {
        return as.stream().map(Convert::entity).collect(Collectors.toList());
    }

    public static List<Appointment> form(AppointmentBatchForm batch) {
        return batch.getAppointments().stream().map(Convert::form).collect(Collectors.toList());
    }
}
