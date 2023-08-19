public class insertionSort{
    public static void inSort(int []arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i-1; j >=0; j--) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                else{
                    break;
                }
            }
           
        }
    }
    public static void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int []arr= {5,6,1,4,8,2,3};
        print(arr);
        inSort(arr);
        print(arr);


    }
}