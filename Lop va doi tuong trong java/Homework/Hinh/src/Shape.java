public class Shape {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4,5);
        rect.draw();
        System.out.println("\n Area of the rectangle: " + rect.getArea());

        Circle circle = new Circle(4);
        circle.draw();
        System.out.println(" Area of the rectangle: " + circle.getArea());

        Square square = new Square(4);
        square.draw();
        System.out.println("\n Area of the square: " +square.getArea());
    }
}
