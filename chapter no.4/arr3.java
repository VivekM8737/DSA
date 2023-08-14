import java.util.Scanner;

public class arr3 {
   public static void main(String[] args) {
    System.out.println("Enter the length of arr: ");
    Scanner s= new Scanner(System.in);
    int x= s.nextInt();
    int[] arr = new int [x];
    
    System.out.println("Enter the elements of arr: ");
    for(int i=0; i<x; i++){
        int y= s.nextInt();
        arr[i]=y;
    }
    int max=arr[0];
    for(int i=1; i<arr.length; i++){        
        if(max<arr[i]){
            max=arr[i];
        }
        else {} 
    }
    for(int  i=max; i>=1; i--){
        for(int j=0; j<x; j++){
            if(arr[j]>=i){
                System.out.print("* ");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.println(" ");

    }




   }

   
}
