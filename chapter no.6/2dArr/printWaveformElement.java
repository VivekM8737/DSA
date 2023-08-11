public class printWaveformElement {
    // Create by me...
    public static void printWaveEle(int[][] arr) {
        int ind = 0;
        for (int i = 0; i < arr[0].length; i++) {
            if (ind == arr.length) {

                for (int j = ind - 1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
                ind = 0;
            } else {

                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j][i]);
                    ind++;
                }
            }
        }
    }
    // created by sir...
    public static void printWaveEle2(int[][] arr) {
        int ind = 0;
        for (int i = 0; i < arr[0].length; i++) {
            if (i%2!=0) {
                for (int j = arr.length - 1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
                
            } else {

                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j][i]);
                    ind++;
                }
            }
        }
    }
    public static void show(int[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] arr={{1,2},{4,5},{7,8}};
        printWaveEle(arr);
        printWaveEle2(arr);
        show(arr);
    }
}
