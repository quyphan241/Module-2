public class Shape {
    private Rectangle rect;
    private Square squ;
    private Circle circle;

    public Shape(Rectangle rect, Square squ, Circle circle) {
        this.rect = rect;
        this.squ = squ;
        this.circle = circle;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Square getSqu() {
        return squ;
    }

    public void setSqu(Square squ) {
        this.squ = squ;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void draw() {
        circle.draw();
        squ.draw();
        System.out.print("\n");
        rect.draw();
    }

    public double getArea() {
        return circle.getArea() + squ.getArea() + rect.getArea();
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4,5);
        Circle circle = new Circle(4);
        Square square = new Square(4);
        Shape shape = new Shape(rect, square, circle);
        shape.draw();
        System.out.println("\n Area: "+shape.getArea());
        System.out.println(shape.getRect().getArea());
    }
}
