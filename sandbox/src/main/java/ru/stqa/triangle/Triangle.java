package ru.stqa.triangle;

import ru.stqa.triangle.methods.TriangleMethods;

public class Triangle {
    public static void main(String[] args) {
        TriangleMethods.printTrianglePerimeter (new TriangleMethods(3.0, 4.0, 5.0));
        TriangleMethods.printTriangleArea (new TriangleMethods(3.0, 4.0, 5.0));
    }

}
