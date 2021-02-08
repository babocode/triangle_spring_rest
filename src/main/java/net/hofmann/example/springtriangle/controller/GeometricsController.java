package net.hofmann.example.springtriangle.controller;

import net.hofmann.example.springtriangle.data.NumberCalculator;
import net.hofmann.example.springtriangle.data.TriangleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
class GeometricsController {


    @Autowired
    private NumberCalculator numberCalculator;

    @Autowired
    private TriangleCalculator triangleCalculator;


    @GetMapping("/numbers")
    List<Integer> numbers() {
        return numberCalculator.numbers();
    }

    @GetMapping("/triangleArea")
    Double numbers(Point p1, Point p2, Point p3) {
        return triangleCalculator.triangleArea(p1, p2, p3);
    }
}
