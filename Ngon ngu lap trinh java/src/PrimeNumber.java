import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        int i=2;
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = scanner.nextInt();
        if (number < 2){
            System.out.println("Number " + number +" is not prime number");
        }
        else{
                while (i<= Math.sqrt(number)){
                    if (number%i==0) {
                        check = false;
                        break;
                    }
                }
                i++;
        }
        if (check)
            System.out.println("Number " + number +" is prime number");
        else
            System.out.println("Number " + number +" is not prime number");
    }

}
