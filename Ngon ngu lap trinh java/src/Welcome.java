import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner enterName = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name= enterName.nextLine();
        System.out.println("Hello "+name);

    }
}
