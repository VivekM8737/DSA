public class printReverseArr {
    public static void show(int ind, int[] arr){
        if(ind>=arr.length){
            return;
        }
        show(ind+1, arr);
        System.out.println(arr[ind]);
        
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,8,9};
        show(0, arr);
    }
}
