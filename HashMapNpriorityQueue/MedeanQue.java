import java.util.Collections;
import java.util.PriorityQueue;

public class MedeanQue {
    public static class MQueue{
        PriorityQueue<Integer> p1=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> p2=new PriorityQueue<>();
        
        void add(int data){
            if (p1.size()==0) {
                p1.add(data);
            }
            else if (p2.size()==0) {
                if (p1.peek()>data) {
                    p2.add(p1.remove());
                    p1.add(data);
                }
                else{p2.add(data);}
            }
            else if (p1.size()<=p2.size()) {
                if (p1.peek()>=data || p2.peek()>data) {
                    p1.add(data);
                }
                else{
                    p1.add(p2.remove());
                    p2.add(data);
                }
            }
            else if (p1.size()>p2.size()) {
                if (p2.peek()<=data || p1.peek()<data) {
                    p2.add(data);
                }
                else{
                    p2.add(p1.remove());
                    p1.add(data);
                }
            }
        }
        int remove(){
            if (p1.size()>=p2.size()) {
                if (p1.size()==0) {
                    return -1;
                }
                return p1.remove();
            }
            else if (p1.size()<p2.size()) {
                return p2.remove();
            }
            return -1;
        }
        int peek(){
            if (p1.size()>=p2.size()) {
                if (p1.size()==0) {
                    return -1;
                }
                return p1.peek();
            }
            else if (p1.size()<p2.size()) {
                return p2.peek();
            }
            return -1;
        }
        int size(){
            return p1.size()+p2.size();
        }
        
    }
    public static class SirMQueue{
        PriorityQueue<Integer> p1;
        PriorityQueue<Integer> p2;
        public SirMQueue(){
             p1=new PriorityQueue<>(Collections.reverseOrder());
             p2=new PriorityQueue<>();
        }
        
        void add(int data){
            if (p2.size()>0 && p2.peek()<data) {
                p2.add(data);
            }
            else {
                p1.add(data);
            }
            if ((p1.size()-p2.size())>2) {
                p2.add(p1.remove());
            }
            else if((p2.size()-p1.size())>2){
                p1.add(p2.remove());
            }
        }
        int remove(){
            if (this.size()==0) {
                return -1;
            }
            else if (p1.size()>=p2.size()) {
                return p1.remove();
            }
            else{
                return p2.remove();
            }
        }
        int peek(){
            if (this.size()==0) {
                return -1;
            }
            else if (p1.size()>=p2.size()) {
                return p1.peek();
            }
            else{
                return p2.peek();
            }
        }
        int size(){
            return p1.size()+p2.size();
        }
        
    }
    public static void main(String[] args) {
        SirMQueue pq=new SirMQueue();
        pq.add(30);//p1
        pq.add(10);//p2
        pq.add(20);//p1
        pq.add(40);//p2
        pq.add(50);//p2
        pq.add(60);//p2
        pq.add(70);//p2
        System.out.println(pq.peek());
        MQueue pq1=new MQueue();
        pq1.add(30);//p1
        pq1.add(10);//p2
        pq1.add(20);//p1
        pq1.add(40);//p2
        pq1.add(50);//p2
        pq1.add(60);//p2
        pq1.add(70);//p2
        System.out.println(pq.peek());
    }
}
