import java.util.ArrayList;

public class grayCode {
    public static ArrayList<String> grayC(int n_bits){
        if (n_bits==1) {
            ArrayList<String> ar=new ArrayList<>();
            ar.add("0");
            ar.add("1");
            return ar;
        }
        ArrayList<String> my_1=grayC(n_bits-1);
        ArrayList<String> newLt=new ArrayList<>();
        for(String x :my_1){
            newLt.add("0"+x);
        }
        for (int i = my_1.size()-1; i >=0; i--) {
            String x=my_1.get(i);
            newLt.add("1"+x);
        }
        return newLt;
    }
    public static void main(String [] args){
       
        System.out.println(grayC(3));
    }
}
