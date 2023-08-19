public class mergeSort {
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
            if(j>arr.length-1 || k>arr1.length-1){
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

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a1 = { 4 };
        int[] a2 = { 1,3 };
        print(mrSort(a1, a2));

    }
}
