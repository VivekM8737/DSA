import java.util.Scanner;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

public class string_1 {
    public static void main(String[] args) {
        String name="Vivek";
        Scanner s=new Scanner(System.in);
        // System.out.println("Enter thr name: ");
        // String name2=s.nextLine();
        System.out.println(name.length());
        char a=name.charAt(2);
        // System.out.println(a);
        // System.out.println(name);
        // System.out.println(name2);
        // for(int i=0; i<name.length(); i++){
        //     char b=name.charAt(i);
        //     System.out.println(b);
        // }
        System.out.println(name.substring(0, 3));
        // totle substring of name
        // for (int i = 0; i<name.length(); i++) {
        //     for(int j=i+1; j<=name.length();j++){
        //         System.out.println(name.substring(i, j));
        //     }
        // }
        String n="Mishra";
        String x= name+ " "+ n;
        System.out.println(x);
        // split saprat the string by given symbol(, " " . etc)
        String [] part=x.split(" ");
        for (int i = 0; i < part.length; i++) {
            System.out.println(part[i]);
        }
        String j="HI ,vivek my name is ,sani";
        String [] part2=j.split(",");
        for (int i = 0; i < part2.length; i++) {
            System.out.println(part2[i]);
        }
    }
}
