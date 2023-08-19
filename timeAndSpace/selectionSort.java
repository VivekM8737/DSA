public class selectionSort {
    public static void sSort(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            int midi=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[midi]>arr[j]){
                    midi=j;
                }
            }
            int temp=arr[midi];
            arr[midi]=arr[i];
            arr[i]=temp;
           
        }
    }
    public static void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int []arr= {5,1,4,8,2,3};
        print(arr);
        sSort(arr);
        print(arr);


    }
}
