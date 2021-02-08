package net.hofmann.example.springtriangle.data;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NumberCalculator {


    List<Integer> numbers();
}
