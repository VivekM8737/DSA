public class oppsswap {
    public static void swaper(Person p1, Person p2){
        Person temp= p1;
        p1=p2;
        p2=temp;
        System.out.println("This is by fuction: "+p1.name +" " +p2.name);
        
    }
    public static void swaper2(Person px1, Person px2){
        int temp= px1.age;
        px1.age=px2.age;
        px1.age=temp;
        String t=px1.name;
        px1.name=px2.name;
        px2.name=t;
        // System.out.println(p1.name +" " +p2.name);

    }
    public static void swaper3(Person px1, Person px2){
        px1 = new Person();
        int temp= px1.age;
        px1.age=px2.age;
        px1.age=temp;
        px2 = new Person();
        String t=px1.name;
        px1.name=px2.name;
        px2.name=t;
    }
    public static void main(String[] args) {
        
        Person p1= new Person();
        p1.age=21;
        p1.name="Ankit";
        Person p2= new Person();
        p2.age=19;
        p2.name="Mr X";
        p1.show();
        p2.show();
        // There is no swap because fuction creat a value and manipulate them it can't change real value
        swaper(p1, p2); 
        p1.show();
        p2.show();
        // // There is swap because fuction creat a copy value but it change the heap value and manipulate them        swaper2(p1, p2);
        // swaper2(p1, p2); 
        // p1.show();
        // p2.show();
        swaper3(p1, p2);
        p1.show();
        p2.show();

    }
    public static class Person{
        int age;
        String name;
        void show(){
            System.out.println("The age is: "+ age+" Name is: "+ name);
        }
    }
}
