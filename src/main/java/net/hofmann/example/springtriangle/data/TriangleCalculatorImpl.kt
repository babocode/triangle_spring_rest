package net.hofmann.example.springtriangle.data;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class TriangleCalculatorImpl implements TriangleCalculator {

    @Override
    public Float triangleArea(Point A, Point B, Point C) {

        float area = (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0f;
        return Math.abs(area);
    }
}
