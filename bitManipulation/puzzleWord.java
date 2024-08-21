import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class puzzleWord {

    public static ArrayList<Integer> solution(String []punch , String []words){
        HashMap<Character,ArrayList<Integer>> hs= new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> st= new ArrayList<>();
            hs.put((char)('a'+i), st);
        }
        for(int i =0;i<words.length;i++){
            HashSet<String> st=new HashSet<>();
            int mask=0;
            for(char ch:words[i].toCharArray()){
                mask=(mask|(1<<(ch-97)));
            }
            for(char ch:words[i].toCharArray()){
                mask=(mask|(1<<(ch-97)));
                if (!st.contains(words[i])) {
                    st.add(words[i]);
                    hs.get(ch).add(mask);
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(String s:punch){
            int mask=0;
            for(char ch:s.toCharArray()){
                mask=(mask|(1<<(ch-97)));
            }
            int count=0;
            for(int t:hs.get(s.charAt(0))){
                if ((mask&t)==t) {
                    count++;
                }
            }
            ans.add(count);

        }
        return ans;

    }
    
    public static void main(String[] args) {
        HashMap<Character,Integer> hs= new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            hs.put((char)('a'+i), i);
        }

        
        System.out.println("Enter the number of words in you punctuation: ");
        Scanner s= new Scanner(System.in);
        int [] p_bits=new int[s.nextInt()];
        String [] pt=new String[p_bits.length];
        System.out.println("Enter the word in punctation");
        for (int i = 0; i < p_bits.length; i++) {
            String punct=s.next();
            pt[i]=punct;
            p_bits[i]=0;
            for(int j=0; j<punct.length();j++){
                int onbit=hs.get(punct.charAt(j));
                p_bits[i]=(p_bits[i]|(1<<onbit));
            }
        }
        System.out.println("Enter the number of words in your words:");
        int [] w_bits=new int[s.nextInt()];
        String [] wds=new String[w_bits.length];
        System.out.println("Enter the words: ");
        for (int i = 0; i < w_bits.length; i++) {
            String word=s.next();
            wds[i]=word;
            w_bits[i]=0;
            for(int j=0; j<word.length();j++){
                int onbit=hs.get(word.charAt(j));
                w_bits[i]=(w_bits[i]|(1<<onbit));
            }
        }
        ArrayList<ArrayList<String>> asw= new ArrayList<>();
        for (int i = 0; i < pt.length; i++) {
            char fch= pt[i].charAt(0);
            int bt_n=hs.get(fch);
            ArrayList<String> t=new ArrayList<>();
            // t.add("for "+pt[i]);
            for (int j = 0; j < wds.length; j++) {
                if ((w_bits[j]&(1<<bt_n))!=0) {
                    if ((w_bits[j]&p_bits[i])==w_bits[j]) {
                       t.add(wds[j]);
                    }
                }
            }
            asw.add(t);

        }
        System.out.println(solution(pt, wds));
        System.out.println(asw);

        

    }
}
