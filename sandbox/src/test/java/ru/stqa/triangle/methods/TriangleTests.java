package ru.stqa.triangle.methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(12, TriangleMethods.TrianglePerimeter(3, 4, 5));
    }

    @Test
    void canCalculateArea(){
        Assertions.assertEquals(6, TriangleMethods.TriangleArea(3, 4, 5));
    }
}
