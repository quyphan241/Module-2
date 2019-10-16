public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        System.out.println("Array: ");
        int arrLength = 7;
        for (int i=0; i<arrLength;i++){
            System.out.print(arr[i] + "  ");
        }
        pushArray(arr,arrLength,7,12);
        System.out.println("\nNew array:");
        for (int i=0; i<arrLength + 1;i++){
            System.out.print(arr[i] + "  ");
        }
    }
    public static void pushArray(int[] array, int arrLength ,int location, int value){
        if ((arrLength < array.length - 1) && (location>=0) && (location<arrLength)){
            for (int i=arrLength; i>location;i--){
                array[i] = array[i-1];
            }
            array[location] = value;
        }
    }
}

