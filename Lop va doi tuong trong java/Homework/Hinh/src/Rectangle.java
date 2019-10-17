public class Rectangle {
    private double width, height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return this.width*this.height;
    }

    public double getPerimeter() {
        return (this.height+this.width)*2;
    }

    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public void draw() {
        for (int i=1;i<=15;i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for (int i=1;i<=2;i++){
            System.out.println("*             *");
        }
        for (int i=1;i<=15;i++){
            System.out.print("*");
        }
    }
}
