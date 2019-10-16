import java.util.Scanner;

public class TimGiaTriLonNhatMang2Chieu {
    public static int[] finMax(float[][] array, int width, int height){
        int[] location = {0,0};
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if ( array[location[0]][location[1]] < array[i][j]){
                    location[0] = i;
                    location[1] = j;
                }
            }
        }
        return location;
    }

    public static void main(String[] args) {
        float[][] arr = new float[20][20];
        Scanner enter = new Scanner(System.in);
        int width;
        do{
            System.out.print("Input matrix width: ");
            width = enter.nextInt();
        }while ((width<0) || (width>20));
        int height;
        do{
            System.out.print("Input matrix height: ");
            height = enter.nextInt();
        }while ((height<0) || (height>20));
        for (int i=0; i<height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("Input matrix [" + i + "][" + j + "]: ");
                arr[i][j] = enter.nextFloat();
            }
        }
        for (int i=0; i<height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.print("\n");
        }
        int[] result = finMax(arr, width, height);
        System.out.print("Max in matrix is [" + result[0] + "][" + result[1] + "] = " + arr[result[0]][result[1]]);
    }
}