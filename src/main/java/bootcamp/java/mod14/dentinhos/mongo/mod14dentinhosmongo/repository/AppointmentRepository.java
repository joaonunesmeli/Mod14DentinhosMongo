package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.repository;

import bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    List<Appointment> findByDoctor_LastName(String name);

    List<Appointment> findByStatus(String status);

}
