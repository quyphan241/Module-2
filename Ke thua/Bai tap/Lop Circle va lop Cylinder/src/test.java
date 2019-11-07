public class test {
    public static void main(String[] args) {
        Circle circle = new Circle(3, "red", "tron");
        System.out.println(circle);

        Cylinder cylinder = new Cylinder(3,"blue",6, "tru");
        System.out.println(cylinder);
        System.out.println(cylinder.getVolume());
    }

}
