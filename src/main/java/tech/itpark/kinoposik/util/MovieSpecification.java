package tech.itpark.kinoposik.util;

import org.springframework.data.jpa.domain.Specification;
import tech.itpark.kinoposik.model.Movie;

import javax.persistence.criteria.*;

public class MovieSpecification implements Specification<Movie> {

    private MovieSearchCriteria criteria;

    public MovieSpecification(MovieSearchCriteria movieSearchCriteria) {
        this.criteria = movieSearchCriteria;
    }

    @Override
    public Predicate toPredicate
            (Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                    root.<String>get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String>get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                System.out.println("like");
                return builder.like(
                        root.<String>get(criteria.getKey()), (String) criteria.getValue());
            }
        }
        return null;
    }
}