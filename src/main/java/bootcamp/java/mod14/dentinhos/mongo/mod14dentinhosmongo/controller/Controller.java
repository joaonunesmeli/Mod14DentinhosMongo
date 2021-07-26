package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.controller;

import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto.AppointmentDto;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.AppointmentBatchForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.form.AppointmentForm;
import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {
    private AppointmentService service;

    @Autowired
    public Controller(AppointmentService service) {
        this.service = service;
    }

    @PostMapping("/appointments")
    public IdDto create(@Valid @RequestBody AppointmentForm form) {
        return this.service.create(form);
    }

    @PostMapping("/appointment_batch")
    public List<String> createAppointments(@Valid @RequestBody AppointmentBatchForm form) {
        return this.service.create(form);
    }

    @GetMapping("/appointments")
    public List<AppointmentDto> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/appointments_by_doctor/{lastName}")
    public List<AppointmentDto> getByDentistName(@PathVariable String lastName) {
        return this.service.getByDoctorLastName(lastName);
    }

    @GetMapping("/appointments_by_status/{status}")
    public List<AppointmentDto> getByStatus(@PathVariable String status) {
        return this.service.getByStatus(status);
    }

    @PutMapping("/appointments/{id}")
    public IdDto update(@PathVariable String id, @Valid @RequestBody AppointmentForm form) {
        return this.service.update(id, form);
    }

    @DeleteMapping("/appointments/{id}")
    public IdDto remove(@PathVariable String id) {
        return this.service.remove(id);
    }
}