package net.hofmann.example.springtriangle.data;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public interface TriangleCalculator {

    Float triangleArea(Point p1, Point p2, Point p3);
}
