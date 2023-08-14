public class sumsubSEt {
    public static void sumSet(int arr[] ,String ansstr,int ans, int idx ,int val){
        if(idx==arr.length){
            if(ans==val){
                System.out.println(ansstr.substring(0, ansstr.length()-1));
            }
            return;
        }

        int x=arr[idx];
        sumSet(arr, ansstr+x+"+",ans+x, idx+1, val);
        sumSet(arr, ansstr+"",ans, idx+1,val);
    }
    public static void main(String[] args) {
        int []arr={10,20,30,40,50,60};
        sumSet(arr, "",0, 0, 80);
    }
}
