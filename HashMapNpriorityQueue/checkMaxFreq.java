import java.util.HashMap;
import java.util.Set;

public class checkMaxFreq{
    public static void main(String[] args) {
        String s="abrakadabra";
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if (hm.get(s.charAt(i))==null) {
                
                hm.put(s.charAt(i), 1);
            }
            else{hm.put(s.charAt(i), hm.get(s.charAt(i))+1);}
        }
        // Set<Character> keys=hm.keySet();
        Integer max=Integer.MIN_VALUE;
        Character y='x';
        for (Character character : hm.keySet()) {
            // max=Math.max(max, hm.get(character));
            if (max<hm.get(character)) {
                max=hm.get(character);
                y=character;
            }
        }
        System.out.println(y+" = "+max);

    }
}