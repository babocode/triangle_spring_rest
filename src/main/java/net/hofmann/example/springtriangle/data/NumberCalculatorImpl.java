package net.hofmann.example.springtriangle.data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class NumberCalculatorImpl implements NumberCalculator {

    final static List<Integer> tenNumbers = Collections.unmodifiableList(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    @Override
    public List<Integer> numbers() {
        return tenNumbers;
    }
}
