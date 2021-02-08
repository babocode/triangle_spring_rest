package net.hofmann.example.springtriangle


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
open class SpringtriangleApplication

fun main(args: Array<String>) {
    runApplication<SpringtriangleApplication>(*args)
}