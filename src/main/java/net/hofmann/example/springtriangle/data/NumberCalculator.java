package net.hofmann.example.springtriangle.data;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public interface NumberCalculator {


    List<Integer> numbers();
}
