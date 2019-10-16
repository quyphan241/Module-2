import java.lang.reflect.Array;
import java.util.Random;

public class TinhTongMaTranDuongCheoChinhMaTranVuong {
    public static void main(String[] args) {
        Random rd = new Random();
        int length = rd.nextInt(10);
        System.out.println("length = "+length);
        int[][] arr = new int[length][length];
        for (int i=0; i<length;i++){
            for (int j=0;j<length;j++){
                arr[i][j] = rd.nextInt(100);
            }
        }
        for (int i=0; i<length;i++){
            for (int j=0;j<length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        int sum = 0;
        for (int i = 0; i<length; i++){
            sum+= arr[i][i];
        }
        System.out.println("Sum= " + sum);
    }
}
