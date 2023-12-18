import justCheck.SubsetSum;
public class equalSumPartition {
    public static boolean checkPartition(int []arr){
        int sum=0;
        for (int x : arr) {
            sum+=x;
        }
        System.out.println(sum);
        if(sum%2==0){
            SubsetSum sw =new SubsetSum();
            int x=sw.checkSubset(arr, sum/2);
            if(x==1){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int [] arr={2,3,7,8,10,1,1};
        if (checkPartition(arr)) {
            System.out.println("Yes Equal partition is possible it have two subset whose sum are eual...");
            
        }
        else{
            System.out.println("No Equal partition is NOT possible it have No subset whose sum are eual!!!");
 
        }
    }
}
