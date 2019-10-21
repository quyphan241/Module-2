public class ColorTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(3);
        shapes[1] = new Rectangle(2,4);
        shapes[2] = new Circle(1);
        for (int i=0;i<shapes.length;i++){
            System.out.println("Area of shape " + i + " is :" + shapes[i].getArea());
            if (shapes[i] instanceof Colorable){
                Square square = (Square) shapes[i];
                square.howToColor();
            }
        }
    }
}
