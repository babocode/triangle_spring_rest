package net.hofmann.example.springtriangle;

import net.hofmann.example.springtriangle.controller.GeometricsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.awt.*;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeometricsControllerTests {

    @Autowired
    private GeometricsController geometricsController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(geometricsController);
    }

    @Test
    void testGeoNumbersTen() {
        List<Integer> tenNumbersExpected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> tenNumbersResult = geometricsController.numbers();

        System.out.println("Expected Numbers 1-10: " + tenNumbersExpected);
        System.out.println("Result   Numbers 1-10: " + tenNumbersResult);

        Assertions.assertEquals(tenNumbersExpected, tenNumbersResult);
    }

    @Test
    void testGeoNumbersTenREST() {
        List<Integer> tenNumbersExpected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List tenNumbersResult = restTemplate.getForObject("http://localhost:" + port + "/numbers", List.class);


        System.out.println("REST Expected Numbers 1-10: " + tenNumbersExpected);
        System.out.println("REST Result   Numbers 1-10: " + tenNumbersResult);

        Assertions.assertEquals(tenNumbersExpected, tenNumbersResult);
    }

    @Test
    void testGeoTriangleCalc() {
        Point p1 = new Point(5, 20);
        Point p2 = new Point(10, 30);
        Point p3 = new Point(33, 42);

        Float areaExpected = 85f;
        Float areaResult = geometricsController.triangleArea(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);

        System.out.println("Expected Triangle Area: 85");
        System.out.println("Result   Triangle Area: " + areaResult);

        Assertions.assertEquals(areaExpected, areaResult);
    }

    @Test
    void testGeoTriangleCalcREST() {
        Point p1 = new Point(5, 20);
        Point p2 = new Point(10, 30);
        Point p3 = new Point(33, 42);

        Float areaExpected = 85f;
        Float areaResult = restTemplate.getForObject(
                "http://localhost:" + port +
                        "/triangleArea/" +
                        p1.x + "-" + p1.y +
                        "/" + p2.x + "-" + p2.y +
                        "/" + p3.x + "-" + p3.y,
                Float.class);


        System.out.println("REST Expected Triangle Area: 85");
        System.out.println("REST Result   Triangle Area: " + areaResult);

        Assertions.assertEquals(areaExpected, areaResult);
    }
}
