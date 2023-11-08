public class countsort{
    public static void cSort(int []arr, int max, int min){
        int len=max-min+1;
        int [] farr= new int [len];
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i]-min]=farr[arr[i]-min]+1;
        }
        farr[0]=farr[0]-1;
        for (int i = 1; i < farr.length; i++) {
            farr[i]=farr[i-1]+farr[i];
        }
        int []res=new int[arr.length];
        for (int i = res.length-1; i >=0 ; i--) {
            res[farr[arr[i]-min]]=arr[i];
            farr[arr[i]-min]--;
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
        int []arr= {5,1,1,1,4,4,8,8,8,2,2,2,2,3};
        print(arr);
        cSort(arr,8,1);
        print(arr);
    }
}