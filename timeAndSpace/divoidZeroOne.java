public class divoidZeroOne {
    public static void sapretZ_O(int[] arr){
        int i=0;
        int j=0;
        while(i<arr.length){
            if(arr[i]==1){
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

    }
    public static void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr={0,1,0,0,1,1,0,1,0,1,1,0,0,1,0};
        print(arr);
        sapretZ_O(arr);
        print(arr);
    }
}
