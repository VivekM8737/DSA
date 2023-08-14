import java.util.ArrayList;

public class arrlist {
    public static void main(String[] args) {
        ArrayList <Integer> l1 =new ArrayList<>();
        System.out.println(l1);
        l1.add(10);
        l1.add(100);
        l1.add(1000);
        l1.add(10000);
        l1.add(100000);
        System.out.println(l1);
        l1.set(1,20);
        System.out.println(l1);
        l1.add(2,200000);
        System.out.println(l1);
        l1.remove(3);
        System.out.println(l1);
        // int val=l1.get(0);
        for(int val:l1){
            System.out.println(val);
        }

        ArrayList <String> s1 =new ArrayList<>();
        s1.add("Vivek Mishra");
        s1.add("Avik Mishra");
        s1.add("Vaishnvi Mishra");
        s1.add("Viru Mishra");
        System.out.println(s1);

    }
}
