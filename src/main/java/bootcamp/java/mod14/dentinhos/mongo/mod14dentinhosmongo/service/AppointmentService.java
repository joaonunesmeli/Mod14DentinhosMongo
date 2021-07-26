package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.service;

import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.Convert;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto.AppointmentDto;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.AppointmentBatchForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.AppointmentForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Appointment;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private AppointmentRepository repository;

    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public IdDto create(AppointmentForm form) {
        Appointment a = Convert.form(form);
        return new IdDto(this.repository.save(a).getId());
    }

    public List<String> create(AppointmentBatchForm batch) {
        List<String> ids = new ArrayList<>(batch.getAppointments().size());
        for (AppointmentForm a : batch.getAppointments()) {
            String id = this.create(a).getId();
            ids.add(id);
        }
        return ids;
    }

    public List<AppointmentDto> getAll() {
        return Convert.entities(this.repository.findAll());
    }

    public List<AppointmentDto> getByDoctorLastName(String lastName) {
        return Convert.entities(this.repository.findByDoctor_LastName(lastName));
    }

    public List<AppointmentDto> getByStatus(String status) {
        return Convert.entities(this.repository.findByStatus(status));
    }

    public IdDto update(String id, AppointmentForm form) {
        Optional<Appointment> opt = this.repository.findById(id);
        if (opt.isEmpty()) {
            return this.create(form);
        }

        Appointment saved = opt.get();
        saved.setPatient(Convert.form(form.getPatient()));
        saved.setDoctor(Convert.form(form.getDoctor()));
        saved.setStatus(form.getStatus());
        saved.setDate(form.getDate());
        saved.setId(id);
        this.repository.save(saved);
        return new IdDto(id);
    }

    public IdDto remove(String id) {
        this.repository.deleteById(id);
        return new IdDto(id);
    }
}
