import java.util.Scanner;

public class TimUocLonNhat {
    public static int findGreatestDivisor(int number) {
        int greatestDivisor=1;
        for (int i = 2; i < number; i++) {
            if(number % i==0)
                greatestDivisor = i;
        }
        return greatestDivisor;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();
        System.out.println("Greatest divisor of number is: "+findGreatestDivisor(number));
    }
}
