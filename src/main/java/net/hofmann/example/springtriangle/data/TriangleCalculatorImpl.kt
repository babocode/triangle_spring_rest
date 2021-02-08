package net.hofmann.example.springtriangle.data

import org.springframework.stereotype.Component
import java.awt.Point

@Component
class TriangleCalculatorImpl : TriangleCalculator {
    override fun triangleArea(A: Point, B: Point, C: Point): Float {
        val area = (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0f
        return Math.abs(area)
    }
}