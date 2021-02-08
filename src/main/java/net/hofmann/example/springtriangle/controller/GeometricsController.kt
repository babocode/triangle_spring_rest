package net.hofmann.example.springtriangle.controller

import net.hofmann.example.springtriangle.data.NumberCalculator
import net.hofmann.example.springtriangle.data.TriangleCalculator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.awt.Point

@RestController
class GeometricsController {
    @Autowired
    private val numberCalculator: NumberCalculator? = null

    @Autowired
    private val triangleCalculator: TriangleCalculator? = null

    @GetMapping("/numbers")
    fun numbers(): List<Int> {
        return numberCalculator!!.numbers()
    }

    @GetMapping("/triangleArea/{p1x}-{p1y}/{p2x}-{p2y}/{p3x}-{p3y}") //    @GetMapping("/triangleArea")
    fun triangleArea(@PathVariable p1x: Int?, @PathVariable p1y: Int?, @PathVariable p2x: Int?, @PathVariable p2y: Int?, @PathVariable p3x: Int?, @PathVariable p3y: Int?): Float {

        //Send location in response
        return triangleCalculator!!.triangleArea(Point(p1x!!, p1y!!), Point(p2x!!, p2y!!), Point(p3x!!, p3y!!))
    }
}