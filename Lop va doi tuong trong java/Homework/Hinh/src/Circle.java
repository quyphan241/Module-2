public class Circle {
    double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }

    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public void draw(){
        System.out.println("This is circle: O");
    }
}
