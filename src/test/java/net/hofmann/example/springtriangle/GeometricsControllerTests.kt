package net.hofmann.example.springtriangle

import net.hofmann.example.springtriangle.controller.GeometricsController
import net.hofmann.example.springtriangle.log.LogMethodCall
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import java.awt.Point

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GeometricsControllerTests {

    private val log = mu.KotlinLogging.logger {}

    @Autowired
    private val geometricsController: GeometricsController? = null

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @LocalServerPort
    private val port = 0

    @Test
    @LogMethodCall
    fun contextLoads() {
        with(log) {
            info("contextLoads: $geometricsController")
        }
        Assertions.assertNotNull(geometricsController)
    }

    @Test
    fun testGeoNumbersTen() {
        val tenNumbersExpected = java.util.List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val tenNumbersResult = geometricsController!!.numbers()
        with(log) {
            info("Expected Numbers 1-10: $tenNumbersExpected")
            info("Result   Numbers 1-10: $tenNumbersResult")
        }
        Assertions.assertEquals(tenNumbersExpected, tenNumbersResult)
    }

    @Test
    fun testGeoNumbersTenREST() {
        val tenNumbersExpected = java.util.List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val tenNumbersResult: List<*> = restTemplate!!.getForObject("http://localhost:$port/numbers", MutableList::class.java)
        with(log) {
            info("REST Expected Numbers 1-10: $tenNumbersExpected")
            info("REST Result   Numbers 1-10: $tenNumbersResult")
        }
        Assertions.assertEquals(tenNumbersExpected, tenNumbersResult)
    }

    @Test
    fun testGeoTriangleCalc() {
        val p1 = Point(5, 20)
        val p2 = Point(10, 30)
        val p3 = Point(33, 42)
        val areaExpected = 85f
        val areaResult = geometricsController!!.triangleArea(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y)
        with(log) {
            info("Expected Triangle Area: 85")
            info("Result   Triangle Area: $areaResult")
        }
        Assertions.assertEquals(areaExpected, areaResult)
    }

    @Test
    fun testGeoTriangleCalcREST() {
        val p1 = Point(5, 20)
        val p2 = Point(10, 30)
        val p3 = Point(33, 42)
        val areaExpected = 85f
        val areaResult = restTemplate!!.getForObject(
                "http://localhost:" + port +
                        "/triangleArea/" +
                        p1.x + "-" + p1.y +
                        "/" + p2.x + "-" + p2.y +
                        "/" + p3.x + "-" + p3.y,
                Float::class.java)
        with(log) {
            info("REST Expected Triangle Area: 85")
            info("REST Result   Triangle Area: $areaResult")
        }

        Assertions.assertEquals(areaExpected, areaResult)
    }
}