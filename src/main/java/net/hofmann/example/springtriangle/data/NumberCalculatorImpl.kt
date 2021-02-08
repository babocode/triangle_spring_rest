package net.hofmann.example.springtriangle.data

import org.springframework.stereotype.Component
import java.util.*

@Component
class NumberCalculatorImpl : NumberCalculator {
    override fun numbers(): List<Int> {
        return tenNumbers
    }

    companion object {
        val tenNumbers = Collections.unmodifiableList(
                java.util.List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    }
}