import java.text.NumberFormat.Style;
import java.util.*;

public class a1{
     public static void main(String[] args) {
        int str=0;
        int x=4;
        int spc=x;

        for(int i=6;i>0;i--){
            if(i==6 || i==1){
                str=4;
                spc=0;
            }
            else{
                str=1;
                spc=x;        
            }
            for(int k=0; k<spc; k++){

                System.out.print("     ");
            }
            for(int j=0; j<str; j++){

                System.out.print("*    ");
            }
            System.out.println("");
            x--;

            
        }
    }
}