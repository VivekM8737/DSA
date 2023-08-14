import java.util.*;

public class input_take{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        System.out.println("Enter the number: ");
        int a=Integer.parseInt( scn.nextLine());
        System.out.println("Enter the name: ");
        String name=scn.nextLine();
        System.out.println(a+ " "+ name);
    }
}