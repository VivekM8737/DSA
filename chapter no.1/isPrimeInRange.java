import java.util.Scanner;

public class isPrimeInRange {
    public static void main(String[] args){
        System.out.println("Enter the Low: ");
        Scanner s= new Scanner(System.in);
        int low=s.nextInt();
        System.out.println("Enter the high: ");
        int high=s.nextInt();
        for(int i=low; i<=high; i++)
        {
            int x=2;
            int c=0;
            do{
                
                if(i%x==0){
                    c++;
                }else{

                }
                // System.out.println(x);
                if(c>=1){
                    // System.out.println("Not Prime!");
                    
                    break;
                }
                else{

                }
                

                x++;
            }while(x<=Math.sqrt(i));

            if(c==0 || i==2 ){
                System.out.println("Prime is: "+i);
            }
        }
    }
}
