public class lastFirstoccur{
    public static int find(int ind , int[]arr , int data){
        if(ind == arr.length){
            return -1;
        }
        if(data == arr[ind]){
            return ind;
        }
        else{
            int x=find(ind+1, arr, data);
            return x;
        }
        

    }
    public static void main(String[] args) {
        int [] arr={1,7,2,4,7,8,5,6};
        
        if(find(0, arr,7)==-1){
            System.out.println("Nae milal!");
        }
        else{

            System.out.println(find(0, arr,7));
        }
    }
}