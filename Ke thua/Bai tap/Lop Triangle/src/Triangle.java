public class Triangle extends Shape {
    private double side1, side2, side3;
    public Triangle(){
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }
    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setSide123(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter() {
        double perimeter = this.side1 + this.side2 + this.side3;
        return perimeter;
    }

    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3)/2;
        return Math.sqrt(p*(p-this.side1)*(p-this.side2)*(p-this.side3));
    }

    @Override
    public String toString() {
        if( side1 + side2< side3||side2+side3<side1||side1+side3<side2||side1<0||side2<0||side3<0){
            return "You've entered a wrong input for a triangle.";
        }
        else {
            return "Triangle{" +
                    "side1=" + side1 +
                    ", side2=" + side2 +
                    ", side3=" + side3 +
                    ", Perimeter: " + getPerimeter() +
                    ", Area: " + getArea() +
                    ", color: " + getColor() +
                    ", filled: " + getFilled() +
                    '}';
        }
    }
}
