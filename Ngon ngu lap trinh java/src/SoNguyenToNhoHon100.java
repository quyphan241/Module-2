
public class SoNguyenToNhoHon100 {
    public static boolean isPrime(int number) {
        int i = 2;
        boolean check = true;
        if (number < 2) {
            check = false;
        } else {
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
            i++;
        }
        return check;
    }

    public static void main(String[] args) {
        for (int i=1;i<=100;i++){
            if(isPrime(i))
                System.out.println(i);
        }
    }
}

