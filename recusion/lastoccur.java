public class lastoccur {
    public static int[] find(int[] arr, int x, int i,int ct) {
        if (i == arr.length) {
            
            return new int[ct];
        }

        if (x == arr[i]) {
            int []arr1=find(arr, x, i + 1, ct+1);
            arr1[ct]=i;
            return arr1;

        } else {
            int []arr1=find(arr, x, i + 1, ct);
            return arr1;
        }
    

    }

    public static void main(String[] args) {
        int[] arr = { 1, 23, 4, 7, 5, 8, 7,48,8,89 };
        int[] ar=find(arr, 7, 0,0);
        for (int i=0; i< ar.length;i++) {
            
            System.out.println(ar[i]);
        }
    }
}
