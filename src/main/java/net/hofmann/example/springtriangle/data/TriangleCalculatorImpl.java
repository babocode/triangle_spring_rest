package net.hofmann.example.springtriangle.data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class TriangleCalculatorImpl implements TriangleCalculator {

    @Override
    public final Double triangleArea(Point p1, Point p2, Point p3) {

        double side1 = 0;
        double side2 = 0;
        double side3 = 0;

        //find length of sides of triangle
        side1 = Math.pow(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2) * .05, side1);
        side2 = Math.pow(Math.pow((p3.x - p2.x), 2) + Math.pow((p3.y - p2.y), 2) * .05, side2);
        side3 = Math.pow(Math.pow((p1.x - p3.x), 2) + Math.pow((p1.y - p3.y), 2) * .05, side3);

        double s = (side1 + side2 + side3) / 2;

        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)) * 0.5;

        return area;
    }
}
