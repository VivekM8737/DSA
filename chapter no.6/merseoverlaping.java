import java.util.Scanner;
import java.util.Stack;

public class merseoverlaping{
    public static void main(String[] args) {
        System.out.println("Enter the length: " );
        Scanner s = new Scanner(System.in);
        int len =s.nextInt();
        
        Pair [] Arrp=new Pair[len];
        for (int i = 0; i < len; i++) {
            int x= s.nextInt();
            int y= s.nextInt();
            Pair Z= new Pair(x,y);
            Arrp[i]=Z;          

        }
        // Z.show();
        Stack<Pair> spair= new Stack<>();
        for (int i = 0; i < Arrp.length; i++) {
            spair.push(Arrp[i]);
        }
        for (int i = 0; i < Arrp.length-1; i++) {
            if(Arrp[i].st > Arrp[i+1].st){
                Pair temp=Arrp[i];
                Arrp[i]=Arrp[i+1];
                Arrp[i+1]=temp;
            }
        }
        for (int i = 0; i < Arrp.length; i++) {
            spair.push(Arrp[i]);
            System.out.println("The value is: " +Arrp[i].st + " "+ Arrp[i].ed);
        }
        
    }
    public static class Pair{

        int st;
        int ed;
        Pair(int st, int ed){
             this.st=st;
             this.ed=ed;
        }
        // void  show(){
        //     System.out.println("MY age is: " + st+ " And my no. is: " + ed);
        // }
    }
}