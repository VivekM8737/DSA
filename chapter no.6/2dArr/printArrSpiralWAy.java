public class printArrSpiralWAy {
    public static void print(int[][] arr) {
        int minr=0;
        int minc=0;
        int maxr=arr.length-1;
        int maxc=arr[0].length-1;
        int count=1;
        int ele=arr.length*arr[0].length;
        while(count<=ele){
            for (int i = minr,j=minc; i <=maxr && count<=ele; i++) {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            minc++;
            for (int j = minc,i=maxr; j <=maxc && count<=ele; j++) {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            maxr--;
            for (int i = maxr,j=maxc; i >=minr && count<=ele; i--) {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            maxc--;
            for (int j = maxc,i=minr; j >=minc && count<=ele; j--) {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            minr++;
            
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
        int[][] arr = { { 11, 22,33,54 }, { 44, 55,66,64 }, { 77, 88,99,74 },{10,11,12,84} };
        show(arr);
        print(arr);
    }
}
