public class pivotOfSortedRotatArr {
    public static int pivot(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = (lo + hi) / 2;
        while (lo<hi) {
            mid=(lo+hi)/2;
            if (arr[mid] < arr[hi] ){
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        System.out.println(arr[hi]);
        return arr[hi];
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 8,9,10,11, 2, 3, 5, 6, 7 };
        pivot(arr);

    }
}
