public class antiClockarr {
    public static void revc(int [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int x = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=x;
            }
        }
        show(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length/2; j++) {
                int x= arr[i][j];
                arr[i][j]=arr[i][(arr.length-1)-j];
                arr[i][(arr.length-1)-j]=x;
            }
        }
        show(arr);

    }
    public static void show(int[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String []arg){
        int [][] arr={{1,3,1,0},{8,2,0,5},{3,0,9,4},{1,5,3,7}};
        show(arr);
        System.out.println();
        revc(arr);
    }
}
