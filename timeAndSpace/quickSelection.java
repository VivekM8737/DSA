import java.util.Scanner;

public class quickSelection{
    public static int qSelect(int[] arr,int lo,int hi,int nth){
        int pivot=divideonPivotBase(arr, lo, hi);
       if((nth)==pivot){
            return arr[nth];
       }
       else if((nth)<pivot){

            return qSelect(arr, lo, pivot-1, nth);
       }
       else if((nth)>pivot){

            return qSelect(arr, pivot+1, hi,nth);
       }
       else{
        return 0;
       }

    }
    public static int divideonPivotBase(int []arr,int si,int hi){
        int i=si;
        int j=si;
        int ind=0;
        int pivot=arr[hi];
        while(i<arr.length){
            if(arr[i]>pivot){
                i++;
            }
            else{
                if(arr[i]==pivot){
                    ind=j;
                }
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        return ind;
    }
    public static void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr= {5,1,4,8,2,10,9,7};
        print(arr);
        System.out.println("Enter the num: ");
        Scanner s= new Scanner(System.in);
        int x=s.nextInt()-1;
        int ans=qSelect(arr, 0, arr.length-1, x);
        System.out.println(ans);
    }
}