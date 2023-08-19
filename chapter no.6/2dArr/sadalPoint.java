public class sadalPoint {
    public static int sadal(int [][] arr){
        int minx=0;
        for (int i = 0; i < arr.length; i++) {
            int min=arr[i][0];
            for (int j = 1; j < arr.length; j++) {
                if(arr[i][j]<min){
                    min=arr[i][j];
                    minx=j;

                }
            }
            if(max(arr, minx)==i){
                return arr[i][minx];
            }
            
        }
        return 0;
    }
    public static int max(int [][] arr,int minx){
        int maxe=arr[0][minx];
        int maxi=0;
        for (int i = 1; i < arr.length; i++) {
            if(maxe<arr[i][minx]){
                maxi=i;
            }

        }
        return maxi;
    }
    public static void main(String[] args) {
        int [][] arr={{10,9,5},{80,20,3},{40,50,6}};
        if(sadal(arr)==0){
            System.out.println("No sadal Point!");
        }else{
            System.out.println(sadal(arr));
        }
    }
}
