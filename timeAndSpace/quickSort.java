public class quickSort {
    public static void qSort(int[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }
       int j =divideonPivotBase(arr, lo, hi);
       qSort(arr, lo, j-1);
       qSort(arr, j+1, hi);
    }
    public static int divideonPivotBase(int []arr,int si,int li){
        int i=si;
        int j=si;
        int pivot=arr[li];
        while(i<arr.length){
            if(arr[i]>pivot){
                i++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        return j-1;
    }
    public static void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr= {5,1,4,8,2,3,9,7};
        print(arr);
        System.out.println(divideonPivotBase(arr,0,arr.length-1));
        qSort(arr, 0, arr.length-1);       
        print(arr);

    }
}
