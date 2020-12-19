package tech.itpark.kinoposik.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MovieSearchCriteria {
    private String key;
    private String operation;
    private Object value;

    public MovieSearchCriteria(String key, String operation, Object value) {
        this.key = key.toLowerCase();
        this.operation = operation;
        this.value = value.toString().toLowerCase();
    }
}
