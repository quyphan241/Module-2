import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        int length;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width of the array: ");
        int width = input.nextInt();
        System.out.println("Enter the height of the array: ");
        int height = input.nextInt();
        double[][] arr = new double[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                System.out.println("Enter element (" + (i+1) + "," + (j+1)+ ")");
                arr[i][j] = input.nextInt();
            }
        }
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                System.out.print(arr[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("Enter the column want to sum: ");
        int column = input.nextInt();
        double sum = 0;
        if (column<=height&&column>= 0){
            for (int i=0;i<height;i++){
                sum+=arr[i][column -1];
            }
            System.out.println(sum);
        }
        else {
            System.out.println("Please enter a number is smaller than the width of the array");
        }
    }
}
