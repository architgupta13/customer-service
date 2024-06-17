package com.wrkspot.assignment.util;

import com.wrkspot.assignment.dao.Customer;
import lombok.val;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerUtils {
    public List<Customer> getCustomersOnlyInFirst(final List<Customer> listA, final List<Customer> listB) {
        if (Objects.isNull(listA)) {
            return Collections.emptyList();
        }

        return listA.stream()
                .filter(obj -> !listB.contains(obj))
                .toList();
    }

    public List<Customer> getCustomersOnlyInSecond(final List<Customer> listA, final List<Customer> listB) {
        if (Objects.isNull(listB)) {
            return Collections.emptyList();
        }

        return listB.stream()
                .filter(obj -> !listA.contains(obj))
                .toList();
    }

    public List<Customer> getCustomersInBoth(final List<Customer> listA, final List<Customer> listB) {
        final Set<Customer> unionSet = listB.stream()
                .filter(listA::contains)
                .collect(Collectors.toSet());
        return unionSet.stream().toList();
    }
}
