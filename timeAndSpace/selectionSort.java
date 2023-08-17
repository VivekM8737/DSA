public class selectionSort {
    public static void sSort(int []arr){
        for (int i = 0; i < arr.length; i++) {
            int min=arr[i];
            int midi=i;
            for (int j = i; j < arr.length; j++) {
                if(min>arr[j]){
                    min=arr[j];
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
        int []arr= {1,4,8,2,3};
        print(arr);
        sSort(arr);
        print(arr);


    }
}
