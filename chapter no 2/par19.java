import java.util.Scanner;

public class par19 {
    public static void main(String[] a){
        System.out.println("Enter the num: ");
        Scanner s= new  Scanner(System.in);
        int x= s.nextInt();
        int n=1;
        for(int i=0;i<x;i++){
            for(int j=0; j<x;j++){
                if(i<=x/2){
                    if(i==x/2){

                        System.out.print("* ");
                    }
                    else if(i==0 && j>x/2 && j<x-1){

                        System.out.print("  ");
                    }
                    else if(i>0 && j!=x/2 && j!=x-1 ){

                        System.out.print("  ");
                    }
                    else{

                        System.out.print("* ");
                    }
                }
                else{

                    if(i==x-1 && j<x/2 && j>0){

                        System.out.print("  ");
                    }
                    else if(i<x-1 && j!=x/2 && j!=0 ){

                        System.out.print("  ");
                    }
                    else{

                        System.out.print("* ");
                    }
                }
                
            }System.out.println("");
        }
        
    }
}
