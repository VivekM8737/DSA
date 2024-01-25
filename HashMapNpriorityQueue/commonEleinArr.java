import java.util.HashMap;

public class commonEleinArr {
    public static void printCommonEle(int [] arr1,int [] arr2){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            if (hm.get(arr1[i])==null) {
                
                hm.put(arr1[i], 1);
            }
            else{
            }
        }
        for(int i=0;i<arr2.length;i++){
            if (hm.get(arr2[i])==null) {

            }
            else{

                System.out.println(arr2[i]);
                hm.remove(arr2[i]);
            }
        }
    }
    public static void printCommonEleRepeatable(int [] arr1,int [] arr2){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            if (hm.get(arr1[i])==null) {
                
                hm.put(arr1[i], 1);
            }
            else{
                hm.put(arr1[i], hm.get(arr1[i])+1);
            }
        }
        for(int i=0;i<arr2.length;i++){
            if (hm.get(arr2[i])==null || hm.get(arr2[i])==0) {

            }
            else{

                System.out.println(arr2[i]);
                hm.put(arr2[i], hm.get(arr2[i])-1);
            }
        }
    }
    public static void main(String[] args) {
       int []arr1={1,1,2,2,3,6,5};
       int []arr2={2,1,1,1,2,6,4};
        // printCommonEle(arr1, arr2);
        printCommonEleRepeatable(arr1, arr2);
    }
}
