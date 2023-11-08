public class radix {
    public static void rsort(int []arr){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int ele=1;
        while(ele<max){
            cSort(arr, ele);
            ele=10*ele;
        }

    }
    public static void cSort(int []arr, int exp){
        int [] farr= new int [10];
        for (int i = 0; i < arr.length; i++) {
            farr[(arr[i]/exp)%10]=farr[(arr[i]/exp)%10]+1;
        }
        farr[0]=farr[0]-1;
        for (int i = 1; i < farr.length; i++) {
            farr[i]=farr[i-1]+farr[i];
        }
        int []res=new int[arr.length];
        for (int i = res.length-1; i >=0 ; i--) {
            res[farr[(arr[i]/exp)%10]]=arr[i];
            farr[(arr[i]/exp)%10]--;
        }
        for (int i = 0; i<res.length ; i++) {
            arr[i]=res[i];
        }
    }
    public static void print(int []arr){
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr= {510,1,47,865,246,391,972,741};
        print(arr);
        rsort(arr);
        print(arr);
    }
}
