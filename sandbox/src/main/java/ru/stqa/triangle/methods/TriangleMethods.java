package ru.stqa.triangle.methods;

public class TriangleMethods {
    public static void printTrianglePerimeter(double a, double b, double c){
        var text = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", a, b, c, TrianglePerimeter(a, b, c));
        System.out.println(text);
    }

    public static double TrianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static void printTriangleArea(double a, double b, double c){
        System.out.println("Площадь треугольника со сторонами " + a + ", " + b + " и " + c + " = " + TriangleArea(a, b, c));
    }

    public static double TriangleArea(double a, double b, double c) {
        var P = TrianglePerimeter(a, b, c) / 2;
        return Math.sqrt(P*(P-a)*(P-b)*(P-c));
    }
}
