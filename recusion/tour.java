public class tour {
    public static void creatTour(int x , char t1 ,char t2,char t3){
        if(x==0){
            return;
        }
        creatTour(x-1, t1, t3, t2);
        System.out.println(x+"["+t1 +"->"+t2 +"]");
        creatTour(x-1, t3, t2, t1);
    }
    public static void main(String[] args) {
        creatTour(3, 'A', 'B', 'C');
    }
}
