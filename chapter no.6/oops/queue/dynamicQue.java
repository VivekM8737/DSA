public class dynamicQue{
    public static class dQue {
        int fr;
        int size;
        int [] arr;
        int x=0;
        dQue(int x){
            arr = new int[x];
         
            this.x=x;
        }
        int size(){
            return size;
        }
        void push(int y){
            if(size>=x){
              int [] arr1 =new int [2*arr.length];
              for(int i=0; i<arr.length; i++){
                int idx=fr;
                arr1[i]=arr[idx+i];
               }
               arr =arr1;
               x=arr.length;
               fr=0;
               int rear =(fr+size)%x;
               arr[rear]=y;
               size++;
            }
            else{
                int rear =(fr+size)%x;
               arr[rear]=y;
               size++;
            }
        }
        int pop(){
            if(size<=0){
                System.out.println("Queue is underflow!");
                return 0;
            }
            else{

                int val = arr[fr%x];
                size--;
                fr=(fr+1)%x;
                return val;
                
            }
        }
        void disp(){
            for(int i=0; i<size; i++){
                int in=(fr+i)%x;
                System.out.print(arr[in]+" ");
            }
        }
        int peek(){
            if(size<=0){
                System.out.println("Queue is underflow!");
                return 0;
            }
            else{

                return arr[fr%x];
            }
        }
    } 
    public static void main(String[] args) {
        dQue a = new dQue(4);
        a.push(10);
        a.push(11);
        a.push(12);
        a.push(13);
        a.push(14);
        a.push(15);
        a.push(16);
        a.push(17);
        System.out.println(a.pop()+" Queued element!");
        System.out.println(a.pop()+" Queued element!");
        System.out.println(a.pop()+" Queued element!");
        a.push(19);
        a.push(18);
        a.disp();
    }
}