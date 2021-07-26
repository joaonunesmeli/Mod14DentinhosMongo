package bootcamp.java.mod14.dentinhos.mongo.mod14dentinhosmongo.data.dto;

import java.util.Map;

public class ValidationDto {
    private Map<String, String> errors;

    public ValidationDto(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
