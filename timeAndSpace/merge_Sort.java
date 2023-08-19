public class merge_Sort {
    public static int[] mrSort(int[] arr, int arr1[]) {
        int[] marr = new int[arr.length + arr1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        for (i = 0; i < marr.length; i++) {
            if (arr[j] > arr1[k]) {
                marr[i] = arr1[k];
                k++;
            }

            else if (arr[j] < arr1[k]) {
                marr[i] = arr[j];
                j++;
            }
            if (j > arr.length - 1 || k > arr1.length - 1) {
                i++;
                break;
            }
        }
        while (j < arr.length) {
            marr[i] = arr[j];
            i++;
            j++;
        }
        while (k < arr1.length) {
            marr[i] = arr1[k];
            i++;
            k++;
        }

        return marr;
    }

    public static int [] sortM(int[] arr, int lo ,int hi){
        if(lo==hi){
            int []arr1=new int[1];
            arr1[0]=arr[lo];
            return arr1;
        }
        int mid=(lo+hi)/2;
        int []h1=sortM(arr, lo, mid);
        int []h2=sortM(arr, mid+1, hi);
        int []fsarr=mrSort(h1, h2);
        return fsarr;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = { 5, 1, 4, 8, 2, 3 };
        print(arr);
        print(sortM(arr,0,arr.length-1));
    }
}
