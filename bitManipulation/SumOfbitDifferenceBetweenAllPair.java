import java.util.Scanner;
// ques a=10111
//      b=11001
//      c=10101
//      d=10010
//  find count of defferent bits in (ab ac ad ba bc bd ca cb cd da db dc) mean all pair but in order of less than n^2


public class SumOfbitDifferenceBetweenAllPair {
    public static void main(String[] args) {
        System.out.println("Enter the count of numbers: ");
        Scanner s = new Scanner(System.in);
        int []arr=new int[s.nextInt()];
        System.out.println("Enter the numbers: ");
       for (int i = 0; i < arr.length; i++) {
            arr[i]=s.nextInt();
       }
        int count=0;
        for(int i=0; i<32;i++){
            int temp1=0;
            int temp2=0;
            for (int j = 0; j < arr.length; j++) {
                
                if ((arr[j]&(1<<i))==0) {
                    temp1++;
                }
                else{
                    temp2++;
                }
            }
            count+=temp1*temp2*2;
        }
        System.out.println(count);
    }
}
