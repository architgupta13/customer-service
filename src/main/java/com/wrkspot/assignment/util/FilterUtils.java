package com.wrkspot.assignment.util;

import com.wrkspot.assignment.dao.Customer;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class FilterUtils {

    public static Specification<Customer> buildSpecification(final Map<String, String> filter) {
        return (root, query, criteriaBuilder) -> {
            // Initialize predicate with an always true condition
            var predicate = criteriaBuilder.conjunction();

            // Add conditions for each filter field
            if (filter.containsKey("firstName")) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("firstName"), filter.get("firstName")));
            }
            if (filter.containsKey("lastName")) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("lastName"), filter.get("lastName")));
            }
            if (filter.containsKey("city")) {
                predicate = criteriaBuilder.equal(criteriaBuilder.lower(root.get("address").get("city")), filter.get("city"));
            }
            if (filter.containsKey("state")) {
                predicate = criteriaBuilder.equal(criteriaBuilder.lower(root.get("address").get("state")), filter.get("state"));
            }

            return predicate;
        };
    }
}
