package net.hofmann.example.springtriangle.controller;

import net.hofmann.example.springtriangle.data.NumberCalculator;
import net.hofmann.example.springtriangle.data.TriangleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class GeometricsController {


    @Autowired
    private NumberCalculator numberCalculator;

    @Autowired
    private TriangleCalculator triangleCalculator;


    @GetMapping("/numbers")
    public List<Integer> numbers() {
        return numberCalculator.numbers();
    }

    @GetMapping ("/triangleArea/{p1x}-{p1y}/{p2x}-{p2y}/{p3x}-{p3y}")
//    @GetMapping("/triangleArea")
    public Float triangleArea(@PathVariable Integer p1x, @PathVariable Integer p1y, @PathVariable Integer p2x, @PathVariable Integer p2y, @PathVariable Integer p3x, @PathVariable Integer p3y) {
        Float area = triangleCalculator.triangleArea(new Point(p1x, p1y), new Point(p2x, p2y), new Point(p3x, p3y));

        //Send location in response
        return area;
    }
}
