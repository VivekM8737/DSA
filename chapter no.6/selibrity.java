import java.util.Stack;

public class selibrity {
    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 1, 1 }, { 0, 0, 0, 0 },{ 0, 1, 0, 0 }, { 0, 1, 1, 0 }};
        Stack<Integer> s1= new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            s1.push(i);
        }
        while(s1.size()>1) {
            int y=s1.pop();
            int x=s1.pop();
            if(arr[x][y]!=1){
                s1.push(x);
            }
            else if(arr[x][y]==1){
                s1.push(y);
            }
        } 
        int z=0;
        int x1=0;
        z=s1.pop();
        for (int i = 0; i < arr.length; i++) {
            if(arr[z][i]!=0){
                x1=1;
                break;
            }
            if(arr[i][z]!=1 && z!=i){
                x1=1;
                break;
            }
        }if(x1==1){

            System.out.println("There is no Selebrity! :(");
        }else{

            System.out.println(z+1+" is Selebrity! :)");
        }
    }
}
