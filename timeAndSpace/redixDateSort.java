import java.util.Scanner;

public class redixDateSort{
    public static void rDatesort(String []arr){
        cSort(arr,1000000,100,32); // for date
        cSort(arr,10000,100,13) ; // for month
        cSort(arr,1,10000,2501); // for date

    }
    public static void cSort(String []arr, int exp,int mode,int range){
        int [] farr= new int [range];
        for (int i = 0; i < arr.length; i++) {
            farr[(Integer.parseInt(arr[i],10)/exp)%mode]=farr[(Integer.parseInt(arr[i],10)/exp)%mode]+1;
        }
        farr[0]=farr[0]-1;
        for (int i = 1; i < farr.length; i++) {
            farr[i]=farr[i-1]+farr[i];
        }
        String []res=new String[arr.length];
        for (int i = res.length-1; i >=0 ; i--) {
            res[farr[(Integer.parseInt(arr[i],10)/exp)%mode]]=arr[i];
            farr[(Integer.parseInt(arr[i],10)/exp)%mode]--;
        }
        for (int i = 0; i<res.length ; i++) {
            arr[i]=res[i];
        }
    }
    public static void print(String []arr){
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
        }
        System.out.println(arr.length);
    }
    public static void main(String[] args) {
        System.out.print("Enter the length of datelist:");
        Scanner scn= new Scanner(System.in);
        int x=scn.nextInt();
        String []date=new String[x]; 
        System.out.println("Enter the Dates: ");
        for (int i = 0; i < date.length; i++) {
            String d=scn.next();
            date[i]=d;
        }

        print(date);
        rDatesort(date);
        print(date);
    }
}