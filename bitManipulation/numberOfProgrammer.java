import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class numberOfProgrammer {
    static ArrayList<Integer> asList=new ArrayList<>();
    public static void soluction(int[] programmer,int nskills, int cp , ArrayList<Integer> oneSolu,int mask){
        if (cp==programmer.length) {
            if(mask==((1<<nskills)-1)){
                if (asList.size()==0 || asList.size()>oneSolu.size()) {
                asList =new ArrayList<>(oneSolu);
                }
            }
            return;
        }
        
        soluction(programmer, nskills, cp+1, oneSolu, mask); // when not selected
        oneSolu.add(cp);
        soluction(programmer, nskills, cp+1, oneSolu, (mask | programmer[cp]));
        oneSolu.remove(oneSolu.size()-1);
    }


    public static void main(String[] args) {
        System.out.println("Enter the number of Skill require: ");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        HashMap<String,Integer> hs=new HashMap<>();
        System.out.println("Enter the name of skills: ");
        for (int i = 0; i < n; i++) {
            hs.put(s.next(), i);
        }
        System.out.println("Enter the number of programmers: ");
        int np=s.nextInt();
        int []programmer=new int[np];
        for (int i = 0; i < programmer.length; i++) {
            System.out.println("Enter the skills number of "+i+"th programmer have");
            int ns=s.nextInt();
            System.out.println("Enter the skills of "+i+"th programmer have");
            for (int j = 0; j < ns; j++) {
                String skill=s.next();
                int snum=hs.get(skill);
                programmer[i]=programmer[i] | (1<<snum);
            }
        }
        soluction(programmer, n, 0, new ArrayList<>(), 0);
        System.out.println(asList);

    }
}
