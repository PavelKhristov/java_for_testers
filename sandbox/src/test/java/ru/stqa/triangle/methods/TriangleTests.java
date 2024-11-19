package ru.stqa.triangle.methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter(){
        var P = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(12.0, P.Perimeter());
    }



    @Test
    void canCalculateArea(){
        Assertions.assertEquals(6.0, new Triangle(3.0, 4.0, 5.0).Area());
    }
}
