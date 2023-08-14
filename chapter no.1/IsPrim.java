import java.util.Scanner;
import java.lang.Math;

public class IsPrim {
    public static void  main(String[] args){
        System.out.println("Enetr the Count: ");
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        for(int i=0; i<a; i++){
            System.out.println("Enetr the Num:  ");
            int n=scn.nextInt();
            int x=2;
            int c=0;
            do{
                
                if(n%x==0){
                    c++;
                }else{

                }System.out.println(x);
                if(c>=1){
                    System.out.println("Not Prime!");
                    
                    break;
                }
                else{

                }
                

                x++;
            }while(x<=Math.sqrt(n));

            if(c==0){
                System.out.println("Prime!");
            }
        } 
    }
}
