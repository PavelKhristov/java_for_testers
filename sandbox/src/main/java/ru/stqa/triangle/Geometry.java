package ru.stqa.triangle;

import ru.stqa.triangle.methods.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Triangle.printTrianglePerimeter (new Triangle(3.0, 4.0, 5.0));
        Triangle.printTriangleArea (new Triangle(3.0, 4.0, 5.0));
    }

}
