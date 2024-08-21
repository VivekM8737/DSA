import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class findminimumsXOR {
    public static void main(String[] args) {
        System.out.println("Enter the count of numbers:");
        Scanner s = new Scanner(System.in);
        int len=s.nextInt();
        int [] nums=new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=s.nextInt();
        }
        Arrays.sort(nums);
        int min= Integer.MAX_VALUE;
        ArrayList<String> pair= new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            int xor=nums[i]^nums[i+1];
            if (min<xor) {
                min=xor;
                pair= new ArrayList<>();
                pair.add(nums[i]+" "+nums[i+1]);
            }
            else if (xor==min) {
                pair.add(nums[i]+" "+nums[i+1]);
            }
        }
        System.out.println(pair);
    }
}
