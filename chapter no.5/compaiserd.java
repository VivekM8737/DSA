public class compaiserd{
    public static String comp(String r){
        String a=r.charAt(0)+"";
        int cout=1;
        for(int i=1; i<r.length();i++){
            if(r.charAt(i-1)==(r.charAt(i))){
                cout++;
            }
            else{
                if(cout>1){a+=cout;}
                cout=1;
                a+=r.charAt(i);

            }
        }
        if(cout>1){a+=cout;}


        return a;
    }
    public static String comp1(String r){
        String a=r.charAt(0)+"";
        for(int i=1; i<r.length();i++){
            if(r.charAt(i-1)==(r.charAt(i))){
            }
            else{                
                a+=r.charAt(i);

            }
        }
        return a;
    }
    public static void main(String[] args) {
        String sb = new String("Heeeelleeooooo");
        System.out.println(comp(sb));
        System.out.println(comp1(sb));

    }
}