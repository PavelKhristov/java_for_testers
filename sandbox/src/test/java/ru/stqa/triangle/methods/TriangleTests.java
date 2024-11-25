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

    @Test
    void canNotCreateTriangleWithNegativeSideA(){
        try {
            new Triangle(-3,4,5);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
            //Ok
        }
    }

    @Test
    void canNotCreateTriangleWithNegativeSideB(){
        try {
            new Triangle(3,-4,5);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
            //Ok
        }
    }

    @Test
    void canNotCreateTriangleWithNegativeSideC(){
        try {
            new Triangle(3,4,-5);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
            //Ok
        }
    }

    @Test
    void canNotCreateTriangleWithTooLongSidesA(){
        try {
            new Triangle(5,2,2);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
            //Ok
        }
    }

    @Test
    void canNotCreateTriangleWithTooLongSidesB(){
        try {
            new Triangle(2,5,2);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
            //Ok
        }
    }

    @Test
    void canNotCreateTriangleWithTooLongSidesC(){
        try {
            new Triangle(2,2,5);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
            //Ok
        }
    }

    @Test
    void testEquality(){
        var t1 = new Triangle(3, 4, 5);
        var t2 = new Triangle(5, 3, 4);
        Assertions.assertEquals(t1, t2);
    }


}
