public class partitionAnArr {
    public static void divideonPivotBase(int []arr,int pivot){
        int j=0;
        int i=0;
        while(i<arr.length){
            if(arr[i]>pivot){
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
    public static void divideOnOddEvenBase(int []arr){
        int j=0;
        int i=0;
        while(i<arr.length){
            if(arr[i]%2!=0){
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
        int []arr= {5,1,4,8,2,3,9,7};
        print(arr);
        divideonPivotBase(arr,6);
        print(arr);
        divideOnOddEvenBase(arr);
        print(arr);

    }
}
// by the help of this you can sovle the odd and even saprete , 0 1 sapret and non zero sapret