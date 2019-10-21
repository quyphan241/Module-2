
public class test {
    public static void main(String[] args) {
//        Circle circle = new Circle(4);
//        System.out.println(circle);
//        double percent = Math.random()*99+1;
//        System.out.println("Resize number: " +percent);
//        circle.resize(percent);
//        System.out.println(circle);
//        }
        double percent = Math.random()*99+1;
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(4);
        shapes[1] = new Rectangle(2, 4);
        shapes[2] = new Square(1);
        System.out.println("Before: ");
        for (Shape shape: shapes) {
            System.out.println(shape);
        }
        System.out.println("Resize number: " +percent);
        for (int i=0;i<shapes.length;i++){
            shapes[i].resize(percent);
        }
        System.out.println("After: ");
        for (Shape i : shapes) {
            System.out.println(i);
        }
    }
}
