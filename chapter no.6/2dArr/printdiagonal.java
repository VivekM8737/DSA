public class printdiagonal {
    public static void digonal(int [][]arr){
        for (int i = 0; i < arr.length; i++) {
         for (int j = 0, x=i; x < arr.length; j++) {
            System.out.print(arr[j][x]+" ");
            x++;
        } 
        }
    }
    public static void show(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = { { 11, 22, 33, 54 }, { 44, 55, 66, 64 }, { 77, 88, 99, 74 }, { 10, 11, 12, 84 } };
        show(arr);
        System.out.println();
        digonal(arr);
    }
}
