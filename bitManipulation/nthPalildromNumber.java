import java.util.Scanner;

/**
 * nthPalildromNumber
 */
public class nthPalildromNumber {

    // eg= for n=8 =10101
    public static int nthBinaryPalidroms(int n){
        int count =1;
        int len=1;
        while (count<n) {
            len++;
            int elementForThisLen=(1<<((len-1)/2));
            count+=elementForThisLen;

        }
        count-=(1<<((len-1)/2));
        int offset=n-count-1;

        int ans=(1<<(len-1));
        ans|=(offset<<(len/2));
        int rev=(ans>>(len/2));
        rev=getRevers(rev);
        ans|=rev;
        return ans;
    }

    public static int getRevers(int x){
        int rev=0;
        while (x!=0) {
           int lb=(x&1);
           rev|=lb;
           rev<<=1;
           x>>=1;
        }
        rev>>=1;
        return rev;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x=s.nextInt();

        System.out.println(nthBinaryPalidroms(x));
    }
}