public class rotatearr {
    public static void rprint(int[][] arr, int r, int s) {
        int minr = 0 + s;
        int minc = 0 + s;
        int maxr = arr.length - (1 + s);
        int maxc = arr[0].length - (1 + s);
        int[] tarr = new int[2 * (maxr - minr + maxc - minc)];
        int ind = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            // System.out.print(arr[i][j]+" ");
            tarr[ind] = arr[i][j];
            ind++;
        }
        minc++;
        for (int j = minc, i = maxr; j <= maxc; j++) {
            tarr[ind] = arr[i][j];
            ind++;
        }
        maxr--;
        for (int i = maxr, j = maxc; i >= minr; i--) {
            tarr[ind] = arr[i][j];
            ind++;
        }
        maxc--;
        for (int j = maxc, i = minr; j >= minc; j--) {
            tarr[ind] = arr[i][j];
            ind++;
        }
        rotate(tarr, r);
        fillShell(arr, tarr, s);

    }

    public static void fillShell(int[][] arr, int[] tarr ,int s) {
        int minr = 0 + s;
        int minc = 0 + s;
        int maxr = arr.length - (1 + s);
        int maxc = arr[0].length - (1 + s);
        int ind = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            arr[i][j] = tarr[ind];
            ind++;
        }
        minc++;
        for (int j = minc, i = maxr; j <= maxc; j++) {
            arr[i][j] = tarr[ind];
            ind++;
        }
        maxr--;
        for (int i = maxr, j = maxc; i >= minr; i--) {

            arr[i][j] = tarr[ind];
            ind++;
        }
        maxc--;
        for (int j = maxc, i = minr; j >= minc; j--) {
            arr[i][j] = tarr[ind];
            ind++;
        }
    }

    public static void rotate(int[] arr, int r) {
        r = arr.length-(r % arr.length);
        if(r<0){
            r=arr.length-r;
        }

        for (int i = 0; i < r; i++) {
            int y = arr[0];
            for (int j = 0; j < arr.length; j++) {
                int x = (j + 1);
                if (x >= arr.length) {
                    arr[j] = y;

                } else {

                    arr[j] = arr[x];
                }
            }
        }
        
    }

    public static void show1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
        rprint(arr, 2, 0);
        System.out.println();
        show(arr);

    }
}