package net.hofmann.example.springtriangle.data

import org.springframework.stereotype.Component

@Component
interface NumberCalculator {
    fun numbers(): List<Int>
}