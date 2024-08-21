import java.util.Scanner;

public class printAbrivation {
    public static void abrivation(String str){
        for (int i = 0; i < (1<<str.length()); i++) {
            int c=0;
            String temp="";
            for (int j = 0; j < str.length(); j++) {
                int bit=str.length()-1-j;
                if((i&(1<<bit))==0){
                    if(c!=0){
                        temp+=c;
                        c=0;
                    }
                    temp+=str.charAt(j);
                }
                else{
                    c++;
                }
            }
            if (c!=0) {
                temp+=c;
            }
            System.out.println(temp);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the String");
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        abrivation(str);

    }
}
