public class printArrTurn {
    public static String out(int [][] arr){
        int coutc=0;
        int dir=0;
        int coutr=0;
        while(true){
            dir=dir+arr[coutr][coutc]%4;
            if(dir==0){
                coutc++;                
            }
            else if(dir==1){
               coutr++;
            }
            else if(dir==2){
                coutc--;
            }
            else if(dir==3){
                coutr--;              
            }
            if(coutc>=arr[0].length){
                coutc--;
                return coutr+" "+coutc;
            }
            else if(coutc<0){
                coutc++;
                return coutr+" "+coutc;
            }
            if(coutr>=arr.length)
            {   coutr--;
                return coutr+" "+coutc;

            }
            if(coutr<0){
                coutr++;
                return coutr+" "+coutc;
            }
        }        
    }
    
    public static void show(int[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String []arg){
        int [][] arr={{1,0,1,0},{0,0,0,0},{0,0,1,0}};
        System.out.println(out(arr));
        show(arr);
    }

}
