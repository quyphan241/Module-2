import java.util.Scanner;
public class IllegalTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter side 1: ");
        double a = scanner.nextDouble();
        System.out.println("Enter side 2: ");
        double b = scanner.nextDouble();
        System.out.println("Enter side 3: ");
        double c = scanner.nextDouble();

        try {
            if (a > 0 && b > 0 && c > 0 &&
                    a + b > c && a + c > b && b + c > a) {
                System.out.println("Right input");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("An triangle must have sumary of two sides always greater than the left over side");
        }
    }
}


