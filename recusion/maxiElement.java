public class maxiElement {

public static int max(int[] arr, int ind){
    if (ind==arr.length-1){
        return arr[ind];
        
    }
    int m=max(arr, ind+1);
    if(m<arr[ind]){
        return arr[ind];
    }
    else{
        return m;
    }

}
    public static void main(String[] args) {
        int [] x = {1,2,5,6,4,8868,45,248,6,48,};
        System.out.println(max(x,0));
    }
}
