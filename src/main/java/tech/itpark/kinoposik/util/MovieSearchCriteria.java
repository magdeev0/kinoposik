package tech.itpark.kinoposik.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MovieSearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
