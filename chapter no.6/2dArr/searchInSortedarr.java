public class searchInSortedarr {
    public static void find(int [][]arr, int ele){
        int i=0;
        int j=arr[0].length-1;
        boolean x=false;
        while(i<arr.length && j>-1 ){
            if(arr[i][j]<ele){
                i++;
            }
            else if(arr[i][j]>ele){
                j--;
            }
            else{
                System.out.println("Element is present at:"+i+" "+j);
                x=true;
                break;
            }
        }
        if(!x){
            System.out.println("Element is not present!");
        }
    }
    public static void main(String[] args) {
        int [][] arr={{1,2,3},{4,5,6},{7,8,9}};
        find(arr, 7);
    }
}
