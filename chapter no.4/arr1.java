import java.util.Scanner;

public class arr1
{
    public static void main(String[] args)
    { 
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the length: ");
        int x=s.nextInt();
        int [] arr=new int [x];
        System.out.print("Enter the element of arr: ");
             for(int i=0; i<arr.length; i++)
             {
                 int y=s.nextInt();
                 arr[i]=y;
             }
              int ele=s.nextInt();
              int m =0;
            System.out.print("Enter the element: ");

            for(int i=0; i<arr.length; i++)
            {   m=arr[i];
                if(ele==arr[i]){
                   
                    System.out.print("Element is present at index: "+i);
                    break ;
                }                 
            }
            if(m!=ele){
                {
                    System.out.print("Element is not present");
                }
            }
    }
}