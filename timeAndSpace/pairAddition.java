import java.util.Arrays;

public class pairAddition {
    public static void pairSum(int []arr, int ele){
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            if(arr[i]+arr[j]>ele){
                j--;
            }
            else if(arr[i]+arr[j]<ele){
                i++;
            }
            else if(arr[i]+arr[j]==ele){
                System.out.println(arr[i]+"+"+arr[j]);
                j--;
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int []arr={1,5,25,8,10,15,32,35,50};
        pairSum(arr, 40);

    }
}
