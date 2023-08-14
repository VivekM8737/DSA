import java.util.Scanner;

public class arr2 {

    public static void main(String[] args) { 
    Scanner s= new Scanner(System.in);
    System.out.print("Enter the length of arr:");
    int x=s.nextInt();
    int [] arr=new int [x];
    System.out.print("Enter the element of arr:");
    for(int i=0; i<arr.length; i++){
        
             int y=s.nextInt();
             arr[i]=y;
         }
          int max=arr[0];
          int min=arr[0];
        for(int i=1; i<arr.length; i++){
         
            if(min>arr[i]){
                min=arr[i];
            }
            else {}
            
            if(max<arr[i]){
                max=arr[i];
            }
            else {} 
        }
        System.out.print(max-min);
    }

}
