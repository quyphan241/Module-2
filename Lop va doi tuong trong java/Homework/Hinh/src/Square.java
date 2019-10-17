public class Square {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getArea(){
        return Math.pow(this.side,2);
    }

    public double getPerimeter() {
        return this.side*4;
    }

    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

    public void draw() {
        for (int i=1;i<=6;i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for (int i=1;i<=2;i++){
            System.out.println("*    *");
        }
        for (int i=1;i<=6;i++){
            System.out.print("*");
        }
    }

}
