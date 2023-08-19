public class binarySEarch {
    public static void main(String[] args) {
        
        int[] arr = { 1, 2, 3, 4, 5};
        int ele=2;
        int lb = 0;
        int ub=arr.length-1;
        while(lb<ub)
        {
            int mid=(lb+ub)/2;
            if(ele<arr[mid]){
                ub=mid-1;
            }
            else if(ele>arr[mid]){
                lb=1+mid;
            }
            else{
                System.out.println("Element is present at");
                break;
            }
        }
    }
}
