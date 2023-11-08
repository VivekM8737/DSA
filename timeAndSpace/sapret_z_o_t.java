public class sapret_z_o_t {
    public static void sapretZ_O(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length-1;
        while(i<=k){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else if(arr[i]==1){
                i++;
            }
            else if(arr[i]==2){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                k--;
            }
            else{
            }
        }
        // print(arr);
        // i=0;
        // while(i<arr.length){
        //     if(arr[i]==2){
        //         i++;
        //     }
        //     else{
        //         int temp=arr[i];
        //         arr[i]=arr[k];
        //         arr[k]=temp;
        //         i++;
        //         k++;
        //     }
        // }

    }
    public static void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr={0,1,0,0,2,2,1,1,2,0,1,2,2,0,2,1,1,0,0,1,0};
        print(arr);
        sapretZ_O(arr);
        print(arr);
    }
}
