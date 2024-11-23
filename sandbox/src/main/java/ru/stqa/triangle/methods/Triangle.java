package ru.stqa.triangle.methods;

public class Triangle {

    private double a;
    private double b;
    private double c;


    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Сторона треугольника не может быть отрицательной");
        }
        if (a + b < c || a + c < b || b + c < a){
            throw new IllegalArgumentException("Не правильный треугольник, сумма двух сторон меньше третей");
        }
    }


    public static void printTrianglePerimeter(Triangle p){
        var text = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", p.a, p.b, p.c, p.Perimeter());
        System.out.println(text);
    }


    public static void printTriangleArea(Triangle s){
        System.out.println("Площадь треугольника со сторонами " + s.a + ", " + s.b + " и " + s.c + " = " + s.Area());
    }


    public double Perimeter() {
        return this.a + this.b + this.c;
    }

    public double Area() {
        var Per = Perimeter() / 2;
        return Math.sqrt(Per*(Per-this.a)*(Per-this.b)*(Per-this.c));
    }
}
