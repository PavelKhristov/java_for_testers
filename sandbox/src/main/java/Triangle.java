public class Triangle {
    public static void main(String[] args) {
        printTrianglePerimeter (3, 4, 5);
        printTriangleArea (3, 4, 5);
    }
    static void printTrianglePerimeter(double a, double b, double c){
        System.out.println("Периметр треугольника со сторонами " + a + ", " + b + " и " + c + " = " + TrianglePerimeter(a, b, c));
    }

    private static double TrianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    static void printTriangleArea(double a, double b, double c){
        System.out.println("Площадь треугольника со сторонами " + a + ", " + b + " и " + c + " = " + TriangleArea(a, b, c));
    }

    private static double TriangleArea(double a, double b, double c) {
        var P = TrianglePerimeter(a, b, c) / 2;
        return Math.sqrt(P*(P-a)*(P-b)*(P-c));
    }
}
