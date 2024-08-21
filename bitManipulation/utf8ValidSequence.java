import java.util.Scanner;

public class utf8ValidSequence {
   
    public static boolean validBySir(int [] arr){
        int reserveNums=0;
        for(int val : arr){
            if (reserveNums==0) {
                if ((val>>7)==0b0) {
                    reserveNums=0;
                }
                else if((val>>5)==0b110){
                    reserveNums=1;
                }
                else if((val>>4)==0b1110){
                    reserveNums=2;
                }
                else if((val>>3)==0b11110){
                    reserveNums=3;
                }

            }
            else{
                if ((val>>6)==0b10) {
                    reserveNums--;
                }
                else{
                    return false;
                }
            }
        }
        if (reserveNums==0) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the length of arr: ");
        Scanner s = new Scanner(System.in);
        int len=s.nextInt();
        System.out.println("Enter the elemnt of array: ");
        int[] arr=new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=s.nextInt();
        }
        System.out.println(validBySir(arr));
    }
}
