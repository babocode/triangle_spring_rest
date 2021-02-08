package net.hofmann.example.springtriangle.data

import org.springframework.stereotype.Component
import java.awt.Point

@Component
interface TriangleCalculator {
    fun triangleArea(A: Point, B: Point, C: Point): Float
}