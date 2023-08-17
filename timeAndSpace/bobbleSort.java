public class bobbleSort{
    public static void bSort(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            int bll=arr[0];
            for (int j = 1; j < arr.length-i; j++) {
                if(bll>arr[j]){
                    int temp=arr[j];
                    arr[j]=bll;
                    arr[j-1]=temp;
                }else{
                    bll=arr[j];
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
        int []arr= {1,4,8,2,3};
        print(arr);
        bSort(arr);
        print(arr);


    }
}